import java.util.*;
import java.io.*;

abstract class Time {
  int value;

  abstract Time getStart();

  abstract boolean isStart();

  public Time(int value) {
    this.value = value;
  }
}

class Start extends Time {
  boolean isStart() {
    return true;
  }

  Time getStart() {
    return null;
  }

  public Start(int value) {
    super(value);
  }
}

class End extends Time {
  Start start = null;

  boolean isStart() {
    return false;
  }

  Time getStart() {
    return start;
  }

  public End(int value, Start start) {
    super(value);
    this.start = start;
  }
}

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    int testCases = in.nextInt();
    for (int i = 1; i <= testCases; i++) {
      printSolution(i, getSequence(in));
    }
  }

  private static String getSequence(Scanner in) {
    int schedules = in.nextInt();
    in.nextLine();

    List<Time> times = new ArrayList<>();
    for (int j = 0; j < schedules; j++) {
      String line = in.nextLine();
      String[] splits = line.split(" ");

      Start start = new Start(Integer.parseInt(splits[0]));
      End end = new End(Integer.parseInt(splits[1]), start);

      times.add(start);
      times.add(end);
    }

    Collections.sort(times, (t1, t2) -> t1.value - t2.value);

    StringBuilder sb = new StringBuilder();

    Time cameron = null;
    Time jamie = null;

    for (Time time : times) {
      if (time.isStart()) {
        if (cameron != null && jamie != null) {
          return "IMPOSSIBLE";
        }

        if (cameron == null) {
          sb.append("C");
          cameron = time;
        } else if (jamie == null) {
          sb.append("J");
          jamie = time;
        }
      } else {
        Time start = time.getStart();

        if (cameron == start) {
          cameron = null;
        } else {
          jamie = null;
        }
      }
    }
    return sb.toString();
  }

  private static void printSolution(int i, String line) {
    System.out.println("Case #" + i + ": " + line);
  }
}
