
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int N = scanner.nextInt();
      Interval[] intervals = new Interval[N];
      for (int i = 0; i < N; i++) {
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        intervals[i] = new Interval(start, end);
      }
      printCase(t, solve(intervals));
    }
  }

  private static String solve(Interval[] intervals) {
    Deque<Character> available = new ArrayDeque<>();
    available.push('J');
    available.push('C');
    Deque<Character> busy = new ArrayDeque<>();

    List<Event> events = new ArrayList<>();
    IntStream.range(0, intervals.length)
      .forEach(i -> {
        events.add(new Event(i, intervals[i].start, true));
        events.add(new Event(i, intervals[i].end, false));
      });
    events.sort(Comparator.<Event>comparingInt(e -> e.time)
      .thenComparing((e1, e2) -> Boolean.compare(e1.start, e2.start)));

    char[] assignees = new char[intervals.length];
    for (Event event : events) {
      if (event.start) {
        if (available.isEmpty()) return "IMPOSSIBLE";
        Character c = available.pop();
        busy.push(c);
        assignees[event.index] = c;
      } else {
        busy.remove(assignees[event.index]);
        available.push(assignees[event.index]);
      }
    }

    return new String(assignees);
  }

  private static class Event {
    private final int index;
    private final int time;
    private final boolean start;

    Event(int index, int time, boolean start) {
      this.index = index;
      this.time = time;
      this.start = start;
    }
  }

  private static void printCase(int t, String s) {
    System.out.println(String.format(
      "Case #%d: %s",
      t + 1,
      s
    ));
  }

  private static class Interval {
    private final int start;
    private final int end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
