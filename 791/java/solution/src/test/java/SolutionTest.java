import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp(){
    solution = new Solution();
  }

  @Test
  public void whenSHasOneCharThenOutputIsSRegardlessOfOrder(){
    assertOutputGivenStringAndOrder("a", "a", "a");
    assertOutputGivenStringAndOrder("a", "b", "a");
    assertOutputGivenStringAndOrder("a", "man", "a");
    assertOutputGivenStringAndOrder("a", "xyz", "a");
  }

  @Test
  public void whenSAndOrderHaveTwoCharsEachAndOrderHasDiffCharsThenOutputIsS(){
    assertOutputGivenStringAndOrder("ab", "xy", "ab");
    assertOutputGivenStringAndOrder("xy", "ab", "xy");
  }

  @Test
  public void whenSHasTwoCharsAndOrderHasOneCharAndCharIsInSThenSIsValidOutput(){
    assertOutputGivenStringAndOrder("ab", "b", "ba");
  }

  @Test
  public void whenSHasTwoCharsAndOrderHasSameTwoCharsThenOutputIsOrder(){
    assertOutputGivenStringAndOrder("ab", "ab", "ab");
    assertOutputGivenStringAndOrder("ab", "ba", "ba");
  }

  @Test
  public void whenSHasTwoCharsAndOrderHasMoreCharsIncludngThoseThenOutputIsStrInOrder(){
    assertOutputGivenStringAndOrder("ab", "bac", "ba");
  }

  private void assertOutputGivenStringAndOrder(String s, String order, String output){
    assertEquals(output, solution.customSortString(order, s));
  }

}
