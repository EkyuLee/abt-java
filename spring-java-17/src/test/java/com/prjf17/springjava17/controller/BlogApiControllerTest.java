package com.prjf17.springjava17.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prjf17.springjava17.domain.Article;
import com.prjf17.springjava17.dto.AddArticleRequest;
import com.prjf17.springjava17.dto.UpdateArticleRequest;
import com.prjf17.springjava17.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest // 테스트용 어플리케이션 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {
    @Autowired //@Autowired : dependency objective에 Bean을 찾아 기입한다.
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; // 직렬화 및 역직렬화를 위한 클래스.

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach //Test를 실행하기전에 진행.
    public void mockMvcSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build(); //mockMvc를 실행함
        blogRepository.deleteAll(); // repository에 혹시 있는 내용을 미리 삭제한다.
    }

    @DisplayName("addArticle: 블로그 글 추가에 성공한다. ")
    @Test
    public void addArticle() throws Exception{

        //given
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";
        final AddArticleRequest userRequest = new AddArticleRequest(title, content); // 객체 생성
        final String requestBody = objectMapper.writeValueAsString(userRequest); //객체를 JSON으로 직렬화 함.

        //when
        ResultActions result = mockMvc.perform(post(url) //post 로 요청 한다.
                .contentType(MediaType.APPLICATION_JSON_VALUE) // type
                .content(requestBody)); //JSON으로 직렬화 된 객체를 담아서 보낸다.

        //then
        result.andExpect(status().isCreated()); //expect 202

        List<Article> articles = blogRepository.findAll(); // 저장된 내용 전체 조회

        assertThat(articles.size()).isEqualTo(1); // 1개만 저장되었는지?
        assertThat(articles.size()).isGreaterThan(0); // 0보다 큰지?
        assertThat(articles.get(0).getTitle()).isEqualTo(title); // title이 동일한지?
        assertThat(articles.get(0).getContent()).isEqualTo(content); // content는 동일한지?
    }

    @DisplayName("Get Articles")
    @Test
    public void getArticles() throws Exception {
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";

        //save - given
        blogRepository.save(Article.builder().title(title).content(content).build());

        final ResultActions resultActions = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON_VALUE)); //JSON으로 받는다.

        //resultActions.andExpect(status().isOk()); // expect is ok

        //복수형으로 확인
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].content").value(content))
                .andExpect(jsonPath("$[0].title").value(title));
    }

    @DisplayName("Get Article using id")
    @Test
    public void getArticleById() throws Exception {
        final String url = "/api/articles/{id}";
        final String title = "title";
        final String content = "content";

        //Given
        Article savedArticle = blogRepository.save(Article.builder().title(title).content(content).build());

        //When
        final ResultActions resultActions = mockMvc.perform(get(url, savedArticle.getId())); // 저장한 리소스의 id를 parameter로 사용한다.

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.title").value(title));
    }

    @DisplayName("delete using id")
    @Test
    public void deleteArticleById() throws Exception {
        final String url = "/api/articles/{id}";
        final String title = "title";
        final String content = "content";
        //given
        Article article = blogRepository.save(Article.builder().title(title).content(content).build());

        //when
        mockMvc.perform(delete(url, article.getId())).andExpect(status().isOk());

        //then
        List<Article> articles = blogRepository.findAll();
        assertThat(articles.size()).isEqualTo(0);
    }

    @DisplayName("data update")
    @Test
    public void updateArticle() throws Exception {

        final String url = "/api/articles/{id}";
        final String title = "title";
        final String content = "content";
        //given
        Article savedArticle = blogRepository.save(Article.builder().title(title).content(content).build());

        final String newTitle = "newTitle";
        final String newContent = "newContent";

        UpdateArticleRequest request = new UpdateArticleRequest(newTitle, newContent);

        //when
        ResultActions result = mockMvc.perform(put(url, savedArticle.getId()) // path param 추가
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))); // body 에 객체를 넣음

        //then
        result.andExpect(status().isOk());

        Article article = blogRepository.findById(savedArticle.getId()).get(); // 저장한 객체의 아이디를 이용하여 데이터 조회.

        assertThat(article.getTitle()).isEqualTo(newTitle); // title 확인
        assertThat(article.getContent()).isEqualTo(newContent); // content 확인
    }
}