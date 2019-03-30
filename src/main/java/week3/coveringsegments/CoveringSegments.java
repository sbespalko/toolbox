package week3.coveringsegments;

import java.util.*;

public class CoveringSegments {

  static int[] optimalPoints(Segment[] segments) {
    List<Integer> points = new ArrayList<>();
    Arrays.sort(segments, Comparator.comparingInt(segment -> segment.start));
    boolean first = true;
    int maxStart = -1;
    int minEnd = -1;
    for (int i = 0; i < segments.length; i++) {
      Segment segment = segments[i];
      if (first) {
        maxStart = segment.start;
        minEnd = segment.end;
        first = false;
      }
      if (segment.start > minEnd) {
        points.add(minEnd);
        maxStart = segment.start;
        minEnd = segment.end;
      }
      if (segment.start > maxStart) {
        maxStart = segment.start;
      }
      if (segment.end < minEnd) {
        minEnd = segment.end;
      }
      if (i == segments.length - 1) {
        points.add(minEnd);
      }
    }

    return points.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    Segment[] segments = new Segment[n];
    for (int i = 0; i < n; i++) {
      int start, end;
      start = scanner.nextInt();
      end = scanner.nextInt();
      segments[i] = new Segment(start, end);
    }
    int[] points = optimalPoints(segments);
    System.out.println(points.length);
    for (int point : points) {
      System.out.print(point + " ");
    }
  }

  static class Segment {
    int start, end;

    Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
 
