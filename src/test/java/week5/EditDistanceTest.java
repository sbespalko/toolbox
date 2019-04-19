package week5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EditDistanceTest {

  @Test
  void editDistance() {
    assertThat(EditDistance.editDistance("abc", "ab")).isEqualTo(1);
    assertThat(EditDistance.editDistance("abc", "d")).isEqualTo(3);
    assertThat(EditDistance.editDistance("ports", "short")).isEqualTo(3);
    assertThat(EditDistance.editDistance("editing", "distance")).isEqualTo(5);
  }
}