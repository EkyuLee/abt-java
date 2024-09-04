"# springboot" 
스프링부트 참조코드 및 테스트 진행을 위한 repogitory 입니다.

> 20240824 - [semiboard] JPA entity 구현 및 insert, select test in h2
  1. properties.yml
  2. member entity
  
> 20240824 - [semiboard] dynamic, static 반환 html page 구현
  1. template.hello.html
  2. source.hello.html
  3. Restconroller

> 20240903 [jpa-tdd-redis-example]
  1. CREATE, INSERT, SELECT USING the JpaRepository
  2. Caution about '@RequiredArgsConstructor' if you want to using without calling of construction, you must have using the final.
  3. Have to check JpaRepository interfaces types.

> 20240904 [jpa-tdd-redis-example]
  1. Making standard TDD.

> about TDD
  1. 메소드별 간략한 설명
    - assertEquals(a, b); // 객체 a(expect), b(input)의 결과가 동일한가?
    - assertSame(a, b); // 객체 a, b가 동일한 객체 인지 확인한다. 
    - assertTrue(a); // 조건 a가 참인지?
    - assertNotNull(a); // a가 null이 아닌지?
  
  2. 통합 테스트 어노테이션
    - @SpringBootTest

  3. 단위 테스트 어노테이션
    - @WebMvcTest
    - @DataJpaTest
    - @RestClientTest
    - @JsonTest

> What is bean?
  - 클래스 호출을, new를 이용해서 호출하는것이 아닌, xml에 등록함으로써 사용할 수 있는것이다. 
  <예시>
  1. XML 등록
    ```
    <bean id="testService" class="com.demo.app.di.testService">
    ```
  
  2. Bean 어노테이션 이용 
    // @Bean
    ```
    @importResource(value{"**.xml"})
    public class test {
      public testService tsv(){return new testService();}
    }
    ```