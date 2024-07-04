import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= testCases; ++i) {
      System.out.print("Case #" + i + ": " + schedule(in) + "\n");
    }
  }

  private static String schedule(Scanner in) {
    int events = in.nextInt();
    List<Tuple> times = getTimesList(in, events);
    sortTimesByStart(times);

    boolean impossible = false;
    int cEnd = 0;
    int jEnd = 0;

    for (int i=0; i < events; i++) {
      int start = times.get(i).start;
      int end = times.get(i).end;

      if (start >= cEnd) {
        cEnd = end;
        times.get(i).setPerson("C");
      } else if (start >= jEnd) {
        jEnd = end;
        times.get(i).setPerson("J");
      } else {
        return "IMPOSSIBLE";
      }
    }
    times.sort(new TupleIndexComparator());

    StringBuilder sb = new StringBuilder();
    for (Tuple t : times) {
      sb.append(t.person);
    }
    return sb.toString();
  }

  private static List<Tuple> getTimesList(Scanner in, int items) {
    List<Tuple> times = new ArrayList<>();
    for (int i=0; i < items; i++) {
      int start = in.nextInt();
      int end = in.nextInt();
      times.add(new Tuple(i, start, end));
    }
    return times;
  }

  private static void sortTimesByStart(List<Tuple> times) {
    times.sort(new TupleComparator());
  }

  static class Tuple {
    final int index;
    final int start;
    final int end;
    String person;
    Tuple(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }

    void setPerson(String person) {
      this.person = person;
    }
  }

  static class TupleComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple o1, Tuple o2) {
      if (o1.start < o2.start) {
        return -1;
      } else if (o1.start > o2.start) {
        return 1;
      }
      return 0;
    }
  }

  static class TupleIndexComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple o1, Tuple o2) {
      if (o1.index < o2.index) {
        return -1;
      } else if (o1.index > o2.index) {
        return 1;
      }
      return 0;
    }
  }
}

