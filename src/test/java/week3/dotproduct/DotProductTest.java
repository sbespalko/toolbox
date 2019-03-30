package week3.dotproduct;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DotProductTest {

  @Test
  void maxDotProduct() {
    assertThat(DotProduct.maxDotProduct(new int[]{23}, new int[]{39})).isEqualTo(897);
    assertThat(DotProduct.maxDotProduct(new int[]{1, 3, -5}, new int[]{-2, 4, 1})).isEqualTo(23);
    assertThat(DotProduct.maxDotProduct(new int[]{100_000}, new int[]{100_000}))
        .isEqualTo(10_000_000_000L);
  }
}