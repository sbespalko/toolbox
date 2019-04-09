package week3.largestnumber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LargestNumberTest {

  @Test
  void largestNumber() {
    assertThat(LargestNumber.largestNumber(new String[]{"21", "22", "2229"})).isEqualTo("22292221");
    assertThat(LargestNumber.largestNumber(new String[]{"21", "2"})).isEqualTo("221");
    assertThat(LargestNumber.largestNumber(new String[]{"9", "4", "6", "1", "9"}))
        .isEqualTo("99641");
    assertThat(LargestNumber.largestNumber(new String[]{"23", "39", "92"})).isEqualTo("923923");
    assertThat(LargestNumber
        .largestNumber(new String[]{"2", "8", "2", "3", "6", "4", "1", "1", "10", "6", "3", "3", "6", "1", "3", "8", "4", "6", "1", "10", "8", "4", "10", "4", "1", "3", "2", "3", "2", "6", "1", "5", "2", "9", "8", "5", "10", "8", "7", "9", "6", "4", "2", "6", "3", "8", "8", "9", "8", "2", "9", "10", "3", "10", "7", "5", "7", "1", "7", "5", "1", "4", "7", "6", "1", "10", "5", "4", "8", "4", "2", "7", "8", "1", "1", "7", "4", "1", "1", "9", "8", "6", "5", "9", "9", "3", "7", "6", "3", "10", "8", "10", "7", "2", "5", "1", "1", "9", "9", "5"}))
        .isEqualTo(
            "9999999998888888888887777777776666666666555555554444444443333333333222222222111111111111111101010101010101010");
  }

  @Test
  void name() {
    assertThat(LargestNumber.largestNumber(new String[]{"2", "22", "222", "3"})).isEqualTo("3222222");
    assertThat(LargestNumber.largestNumber(new String[]{"3", "222", "22", "1"})).isEqualTo("3222221");
    assertThat(LargestNumber.largestNumber(new String[]{"22", "22", "22", "22"})).isEqualTo("22222222");
    assertThat(LargestNumber.largestNumber(new String[]{"1000", "100", "89", "899"})).isEqualTo("899891001000");
    assertThat(LargestNumber.largestNumber(new String[]{"797", "79", "7"})).isEqualTo("797977");
    assertThat(LargestNumber.largestNumber(new String[]{"7978", "79", "7"})).isEqualTo("7979787");
    assertThat(LargestNumber.largestNumber(new String[]{"79797", "79", "7"})).isEqualTo("79797977");
    assertThat(LargestNumber.largestNumber(new String[]{"778", "7"})).isEqualTo("7787");
    assertThat(LargestNumber.largestNumber(new String[]{"778", "7", "7","8"})).isEqualTo("7787");
  }
}