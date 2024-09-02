"# springboot" 
스프링부트 참조코드 및 테스트 진행을 위한 repogitory 입니다.

> 20240824 - [semiboard] JPA entity 구현 및 insert, select test in h2
  1. properties.yml
  2. member entity
  
> 20240824 - [semiboard] dynamic, static 반환 html page 구현
  1. template.hello.html
  2. source.hello.html
  3. Restconroller


> [2024-09-02] PROJECT를 마무리 하며, (5가지 기능이 구현된 프로젝트)
  1. JPA(ORM) 의 기본 entity 구성 및 create
       - src/main/java/com/semiboard/Member/entity

  2. Thymleaf, ResponseBody(only text response), html response, response attribute to client
       - src/main/java/com/semiboard/Member/controller
       - src/main/resources/templates/request-sample.html

  3. Parameter를 받는 4가지 방법 (@PathVariable, @RequestParam, @ModelAttribute, @RequestBody)
       - src/main/java/com/semiboard/Member/controller
       - src/main/resources/templates/request-sample.html

  4. dependency injection 예제
       - src/main/java/com/semiboard/dependencyexample

  5. CRUD, USING H2 DATABASE.
       - src/main/java/com/semiboard/notes
       - src/main/resources/templates/note_index.html


> [2024-09-02] 새로운 프로젝트 생성 
     1. JPA
     2. DEPENDENCY
     3. CRUD