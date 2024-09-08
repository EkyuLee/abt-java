## 01. SpringBootApplication Annotation 이해하기.
> @SpringBootApplication
> > @SpringBootConfiguration : @Configuration을 상속해서 만든 Annotation
> > @ComponentScan 
> > > 사용자가 등록한 빈을 읽고 등록하는 Annotation
> > > @Configuration // 설정 파일 등록
> > > @Repository // ORM 매핑
> > > @Controller, @RestController // 라우터
> > > @Service // 비즈니스 로직
> > @EnableAutoConfiguration : 스프링 부트가 실행될때 스프링 부트 메타 파일읅 읽고 정의된 설정들을 자동으로 구성하는 역할을 한다.
> > @Component Annotation을 가지고 있는 Annotations
> > > @Controller, @Configuration, @Repository, @Service

## 02. Spring의 계층
> 1. Controller (프레젠테이션 계층) - HTTP 요청 처리
> 2. Service (비즈니스 계층) - 처리 로직 구현
> 3. Repository (퍼시스턴스 계층) - 데이터 베이스 관련 로직
> 4. 데이터베이스

## 03. Directory
> 1. main - 실제 코드 작성 경로
> 2. test - 테스트코드 혹은 리소스 파일 등
> 3. build.gradle - 빌드 설정 (플러그인 등)
> 4. settings.gradle - 프로젝트 정보 설정

## 04. test.test 내부의 스프링 객체에 따른 구성
> 1. Controller 생성 (TestController.java)
> > @RestController, @Autowired, @GetMapping

> 2. Service 생성 (TestService.java)
> > @Service, @Autowired

> 3. Member entity 생성 (Member.java)
> > @NoArgsConstructor, @AllArgsConstructor, @Getter, @Entity, @Id, @GeneratedValue, @Column

> 4. Repository 생성 (MemberRepository.java - interface)
> > @Repository
 
> 5. 데이터 입력하기 (path : resource/data.sql)
> > insert into member(id, name) values (1, 'name 1')

> 6. application.yml 변경하기 

## 05. 스프링 부트의 요청과 응답 과정 
1. Get 요청
2. 스프링 부트 내의 Disfetcher Sublet에서 URL 분석 후 내부 controller 검색 후 controller 으로 요청
3. 메서드와 요청이 매치 되고, 비즈니스 계층과 퍼시스턴스 계층을 통해서 필요한 데이터를 가져온다.
4. 그 뒤 데이터를 return 해서 클라이언트가 볼 수 있게 한다.