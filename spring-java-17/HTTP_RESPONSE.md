# HTTP 주요 응답 코드 - for TDD status response 
```java
    @DisplayName("getAllMembers : 아티클 조회에 성공한다.")
    @Test //GWT pattern
    public void getAllMembers() throws Exception {
        //given : G - 멤버 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(4L, "abc"));
    
        //when - 멤버 리스트 조회
        final ResultActions result = mockMvc.perform(get(url) //1 - perform : 요청을 전송하는것.
                .accept(MediaType.APPLICATION_JSON)); // 2 - accept : 무슨 타입으로 응답을 받을지 정하는것.
    
        //then - 저장된 멤버와 조회도니 멤버의 값이 동일한지 ?
        result
                .andExpect(status().isOk()) //3 - 응답 검증, 200(응답 ok) 인지 확인한다. 201 = Created
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    
    }
```
1. 200 OK - isOk()
2. 201 Created - isCreated()
3. 400 Bad Request - isBadRequest()
4. 403 Forbidden - isForbidden()
5. 404 Not Found - isNotFound()
6. 400 번대 응답 코드 - is4xxClientError()
7. 500 Internal Server Error - isInternalServerError()
8. 500 번대 응답 코드 - is5xxServerError()