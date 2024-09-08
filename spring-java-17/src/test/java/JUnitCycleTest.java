import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll // 테스트 실행 전 1회 실행하므로 메서드는 static으로 선언한다.
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @BeforeEach //테스트 케이스를 실행하기 전마다 실행한다.
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterAll //전체테스트를 마치고 종료 전에 1회 실행하므로 메서드는 static으로 선언한다.
    static void afterAll(){
        System.out.println("@AfterAll");
    }

    @AfterEach //각각의 테스트 케이스를 종료하기 전마다 실행한다. BeforeEach는 시작전, AfterEach는 종료 전
    public void afterEach(){
        System.out.println("@AfterEach");
    }
}
