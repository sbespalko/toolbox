package week3.coveringsegments;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoveringSegmentsTest {

  @Test
  void optimalPoints() {
    assertThat(CoveringSegments.optimalPoints(new CoveringSegments.Segment[]{
        new CoveringSegments.Segment(1, 3),
        new CoveringSegments.Segment(2, 5),
        new CoveringSegments.Segment(3, 6),
    })).contains(3);

    assertThat(CoveringSegments.optimalPoints(new CoveringSegments.Segment[]{
        new CoveringSegments.Segment(4, 7),
        new CoveringSegments.Segment(1, 3),
        new CoveringSegments.Segment(2, 5),
        new CoveringSegments.Segment(5, 6),
    })).contains(3, 6);

    assertThat(CoveringSegments.optimalPoints(new CoveringSegments.Segment[]{
        new CoveringSegments.Segment(0, 1),
        new CoveringSegments.Segment(0, 4),
        new CoveringSegments.Segment(1, 7),
        new CoveringSegments.Segment(2, 5),
        new CoveringSegments.Segment(3, 4),
        new CoveringSegments.Segment(3, 3),
        new CoveringSegments.Segment(6, 10),
        new CoveringSegments.Segment(8, 9),
        new CoveringSegments.Segment(9, 11),
        new CoveringSegments.Segment(12, 13),
    })).contains(1, 3, 9, 13);

  }
}