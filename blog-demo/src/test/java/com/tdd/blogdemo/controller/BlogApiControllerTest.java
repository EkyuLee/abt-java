package com.tdd.blogdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.blogdemo.domain.Article;
import com.tdd.blogdemo.dto.AddArticleRequest;
import com.tdd.blogdemo.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class BlogApiControllerTest {
    @Autowired // 필요한 객체를 자동으로 생성하고 주입하는 어노테이션 이다.
    protected MockMvc mvc; //서블릿 컨테이너나 웹 서버를 띄우지 않고 테스트를 할 수 있게 도와준다.

    @Autowired
    protected ObjectMapper objMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach
    public void mockSetUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
        blogRepository.deleteAll(); // 데이터 초기화.
    }

    @DisplayName("add article")
    @Test
    public void addArticle() throws Exception {
        //GIVEN
        final String url = "/api/articles";
        final String title = "title_001";
        final String content = "content_001";
        final AddArticleRequest request = new AddArticleRequest(title, content);
        final String requestBody = objMapper.writeValueAsString(request); //객체를 JSON 형태의 string 으로 전환

        //WHEN
        ResultActions result = mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        //THEN
        result.andExpect(status().isCreated()); // create message가 정상적으로 도착 했는지? 202
        List<Article> articles = blogRepository.findAll();

        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getContent()).isEqualTo(content);
        System.out.println("date result");
        System.out.println(articles.get(0).getCreatedDate());
        System.out.println(articles.get(0).getLastModifiedDate());
    }

    @DisplayName("find by id")
    @Test
    public void findById() throws Exception {
        //GIVEN
        final String url = "/api/articles/{id}";
        final String title = "title_001";
        final String content = "content_001";

        Article savedArticle = blogRepository.save(Article.builder().title(title).content(content).build());

        //When
        final ResultActions result = mvc.perform(get(url, savedArticle.getId()));

        //Then
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.content").value(content));

        //번외 - 출력하기
        MvcResult mvcResult = result.andReturn();
        String resBody = mvcResult.getResponse().getContentAsString();
        System.out.println("RESPONSE BODY \n" + resBody);
    }

    @DisplayName("Find All")
    @Test
    public void findAll() throws Exception {
        //Given
        final String url = "/api/articles";
        final String title = "title_001";
        final String content = "content_001";
        blogRepository.save(Article.builder().title(title).content(content).build());

        final ResultActions result = mvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));

        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(title))
                .andExpect(jsonPath("$[0].content").value(content));
    }
}