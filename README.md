## 일자별 특이사항
> 20240824 - [semiboard] JPA entity 구현 및 insert, select test in h2
> > 1. properties.yml
> > 2. member entity
  
> 20240824 - [semiboard] dynamic, static 반환 html page 구현
> > 1. template.hello.html
> > 2. source.hello.html
> > 3. Restconroller

> 20240903 [jpa-tdd-redis-example]
> > 1. CREATE, INSERT, SELECT USING the JpaRepository
> > 2. Caution about '@RequiredArgsConstructor' if you want to using without calling of construction, you must have using the final.
> > 3. Have to check JpaRepository interfaces types.

> 20240904 [jpa-tdd-redis-example]
> > 1. Making standard TDD.


# --------------------------------------------------

## 기능별 팁

> about TDD
> > 1. 메소드별 간략한 설명
> > > - assertEquals(a, b); // 객체 a(expect), b(input)의 결과가 동일한가?
> > > - assertSame(a, b); // 객체 a, b가 동일한 객체 인지 확인한다. 
> > > - assertTrue(a); // 조건 a가 참인지?
> > > - assertNotNull(a); // a가 null이 아닌지?
  
> > 2. 통합 테스트 어노테이션
> > > - @SpringBootTest

> > 3. 단위 테스트 어노테이션
> > > - @WebMvcTest
> > > - @DataJpaTest
> > > - @RestClientTest
> > > - @JsonTest

> What is bean?
> > - 클래스 호출을, new를 이용해서 호출하는것이 아닌, xml에 등록함으로써 사용할 수 있는것이다.

> > <예시>
> > >  1. XML 등록

```xml 
      <bean id="testService" class="com.demo.app.di.testService">
```
  
> > > 2. Bean 어노테이션 이용
 
```java
      @Bean
      @importResource(value{"**.xml"}) 
      public class test {
         public testService tsv(){return new testService();}
      }
```

> How to install REDIS? (참조 : 내 블로그 - https://soft-tip.tistory.com/entry/REDIS-%EC%84%A4%EC%B9%98-%EB%B6%80%ED%84%B0-%EA%B8%B0%EB%B3%B8-%EC%84%A4%EC%A0%95)
> > 1. WSL2 설치 (window 환경일 경우)
> > > 참조 : https://learn.microsoft.com/en-us/windows/wsl/install
    
> > 2. REDIS 설치
> > > 참조 : https://redis.io/docs/latest/develop/connect/cli/
> > > 참조2 : https://github.com/microsoftarchive/redis/releases

> > 3. REDIS CLI 활용
> > > - PUB/SUB 

```terminal
      $redis-cli PSUBSCRIBE '*' //read all of publish and subscribe
      $redis-cli PUBLISH {channel-name} '{message}' // publish of message to channel-name
      $redic-cli SUBSCRIBE {channel-name} //subscribe about channel-name
```

> > > - RDB 백업

```terminal
      $redis-cli --rdb /tmp/dump.rdb
```

> > 4. 상세 내용은 블로그 참조

   
# ----------------------------------------------------------------

## 용어 정리

> 레이턴시 ? 
> > 1. 레이턴시(latency)는 자극과 반응 사이의 시간이며, 더 일반적인 관점에서는 관찰되는 시스템에서의 어떠한 물리적 변화에 대한 원인과 결과 간의 지연 시간이다. (https://ko.wikipedia.org/wiki/%EB%A0%88%EC%9D%B4%ED%84%B4%EC%8B%9C)

> TTY ? 
> > 1. 유닉스 표준 입력에 연결된 터미널의 이름을 출력하는 명령어

> redis sentinel?
> > 1. 장애 발생시 운영 서비스에 영향이 없도록(고가용성) redis master monitoring 및 자동 장애 극복 조치 (Fail over) 해주는 서비스 이다.
