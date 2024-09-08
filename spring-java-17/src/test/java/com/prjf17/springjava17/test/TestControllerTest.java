package com.prjf17.springjava17.test;

import org.junit.jupiter.api.AfterEach;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class TestControllerTest {
    //region Description : controller 를 테스트 하기 위한 기본적인 셋팅
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach //테스트 실행 전
    public void mockMvcSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach //테스트 실행 후
    public void cleanUp(){
        memberRepository.deleteAll();
    }
    //endregion

    @DisplayName("getAllMembers : 아티클 조회에 성공한다.")
    @Test //GWT pattern
    public void getAllMembers() throws Exception {
        //given : G - 멤버 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "abc"));
        
        //when - 멤버 리스트 조회
        final ResultActions result = mockMvc.perform(get(url) //1 - perform : 요청을 전송하는것.
                .accept(MediaType.APPLICATION_JSON)); // 2 - accept : 무슨 타입으로 응답을 받을지 정하는것.

        //then - 저장된 멤버와 조회도니 멤버의 값이 동일한지 ?
        result
                .andExpect(status().isOk()) //3 - 응답 검증, 200(응답 ok) 인지 확인한다. 201 = Created
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));

    }
}