import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() {
    solution = new Solution();
  }

  @Test
  public void emptyStringYieldsZero() {
    assertEquals(0, solution.myAtoi(""));
  }

  @Test
  public void numberPrecededByWhitespacesYieldsNumber() {
    assertEquals(42, solution.myAtoi(" 42"));
    assertEquals(81, solution.myAtoi("  81"));
  }

  @Test
  public void numberYieldsNumber() {
    assertEquals(5, solution.myAtoi("5"));
  }

  @Test
  public void numberPrecededByPlusSignYieldsPositiveNumber() {
    assertEquals(65, solution.myAtoi("+65"));
    assertEquals(65, solution.myAtoi("  +65"));
    assertEquals(-65, solution.myAtoi("-65"));
    assertEquals(-65, solution.myAtoi("  -65"));
  }

  @Test
  public void stringContainingNoDigitsYieldsZero() {
    assertEquals(0, solution.myAtoi("x"));
    assertEquals(0, solution.myAtoi("   abc"));
  }

  @Test
  public void stringContainingDigitsPrecededByNonValidNonDigitsNumbersYieldsZero() {
    assertEquals(0, solution.myAtoi("x123"));
    assertEquals(0, solution.myAtoi("  x123"));
    assertEquals(0, solution.myAtoi("  -x123"));
    assertEquals(0, solution.myAtoi("  +x123"));
  }

  @Test
  public void bigPosNumberIsClampedToMaxInteger() {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi("91283472332"));
    assertEquals(Integer.MAX_VALUE, solution.myAtoi("2147483648"));
    assertEquals(2147483647, solution.myAtoi("2147483647"));
  }

  @Test
  public void bigPosNumberIsClampedToMinInteger() {
    assertEquals(Integer.MIN_VALUE, solution.myAtoi("-91283472332"));
    assertEquals(Integer.MIN_VALUE, solution.myAtoi("-2147483649"));
    assertEquals(-2147483648, solution.myAtoi("-2147483648"));
  }

  @Test
  public void ifNonDigitEncounteredAfterDigitsThenNumberEnds() {
    assertEquals(12, solution.myAtoi("12a34"));
  }

  @Test
  public void ifNonDigitFollowsSignThenYieldIsZero() {
    assertEquals(0, solution.myAtoi("+-12"));
    assertEquals(0, solution.myAtoi("  +-12"));
    assertEquals(0, solution.myAtoi("  +  12"));
  }

  @Test
  public void ifNothingFollowsSignThenYieldIsZero() {
    assertEquals(0, solution.myAtoi("+"));
    assertEquals(0, solution.myAtoi("-"));
  }

  @Test
  public void testExecutionTime() {
    StopWatch sw = new StopWatch();
    sw.start();
    solution.myAtoi("   +20000000000000000000");
    sw.stop();
    System.out.println("Execution Time: " + sw.getNanoTime() + " ns");
  }
}