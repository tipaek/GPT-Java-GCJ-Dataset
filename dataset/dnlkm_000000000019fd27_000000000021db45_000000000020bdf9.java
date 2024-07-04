import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();

    testF: for (int t = 1; t <= T; t++) {
      int n = in.nextInt();

      Event[] events = new Event[n * 2];
      char[] result = new char[n];

      for (int i = 0; i < n; i++) {
        events[i * 2] = new Event(i, in.nextInt(), 1);
        events[i * 2 + 1] = new Event(i, in.nextInt(), -1);
      }

      Arrays.sort(events);

      // index of the event they are working on
      int c = -1;
      int j = -1;

      for (Event e : events) {
        
        if (e.delta > 0) {
          // work starts
          if (c < 0) {
            result[e.index] = 'C';
            c = e.index;
          } else if (j < 0) {
            result[e.index] = 'J';
            j = e.index;
          } else {
            System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            continue testF;
          }
        } else {
          // work ends
          if (c == e.index) {
            c = -1;
          } else {
            j = -1;
          }
        }
      }

      System.out.printf("Case #%d: ", t);
      for (char cc : result)
        System.out.print(cc);
      System.out.println();

    }
    in.close();
  }

  static class Event implements Comparable<Event> {
    int index; // event index
    int time; // when it happened
    int delta;  // +1 start, -1 end

    Event(int i, int t, int d) {
      index = i;
      time = t;
      delta = d;
    }

    @Override
    public int compareTo(Event o) {
      if (time == o.time) {
        return delta - o.delta;
      }
      return time - o.time;
    }
  }
}