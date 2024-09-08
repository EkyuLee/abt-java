import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitUseAssertJ {
    @DisplayName("isEqualsTo") //동일한가?
    @Test
    public void testAssertJ_isEqualsTo() {
        int a = 1;
        int b = 2;
        int result = 3;

        assertThat(a + b).isEqualTo(result);
    }

    @DisplayName("isGreaterThan") //() 안의 값보다 큰지?
    @Test
    public void testAssertJ_isGreaterThan() {
        int a = 1;
        int b = 2;
        int result = 3;

        assertThat(a + b).isGreaterThan(result);
    }

    @DisplayName("isLessThan")
    @Test
    public void testAssertJ_isLessThan() {
        int a = 1;
        int b = 2;
        int result = 3;

        assertThat(a + b).isLessThan(result);
    }

    @DisplayName("isNotEqualsTo") //동일하지 않은가?
    @Test
    public void testAssertJ2_isNotEqualsTo() {
        int a = 1;
        int b = 2;
        int result = 3;

        assertThat(a + b).isNotEqualTo(result);
    }

    @DisplayName("contains") // 포함되어 있는가?
    @Test
    public void testAssertJ_contains() {
        String input = "Hello World!";
        String output = "World";

        assertThat(input).contains(output);
    }

    @DisplayName("doesNotContain") //포함되어 있지 않은가?
    @Test
    public void testAssertJ_doesNotContain() {
        String input = "Hello World!";
        String output = "World";

        assertThat(input).doesNotContain(output);
    }

    @DisplayName("startsWith") // 시작점이 맞는가?
    @Test
    public void testAssertJ_startsWithA() {
        String input = "Hello World!";
        String output = "World";

        assertThat(input).startsWith(output);
    }

    @DisplayName("endWith") // 끝 점이 맞는가?
    @Test
    public void testAssertJ_endWith() {
        String input = "Hello World!";
        String output = "World";

        assertThat(input).isEqualTo(output);
    }

    @DisplayName("isEmpty") // 비어 있는가? 비어있으면 true
    @Test
    public void testAssertJ_isEmpty() {
        String input = "Hello World!";

        assertThat(input).isEmpty();
    }

    @DisplayName("isNotEmpty") //비어져 있지 않는가? 안비어져 있어야 true
    @Test
    public void testAssertJ_isNotEmpty() {
        String input = "Hello World!";

        assertThat(input).isNotEmpty();
    }

    @DisplayName("isPositive") //양수인지?
    @Test
    public void testAssertJ_isPositive() {
        int a = 1;
        int b = 2;

        assertThat(a + b).isPositive();
    }

    @DisplayName("isNegative") // 음수인지?
    @Test
    public void testAssertJ_isNegative() {
        int a = 1;
        int b = 2;

        assertThat(a + b).isNegative();
    }


}
