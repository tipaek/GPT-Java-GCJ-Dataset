import java.util.*;
import java.io.*;

abstract class Time {
  int value;

  public Time(int value) {
    this.value = value;
  }

  abstract Time getStart();

  abstract boolean isStart();
}

class Start extends Time {
  public Start(int value) {
    super(value);
  }

  @Override
  boolean isStart() {
    return true;
  }

  @Override
  Time getStart() {
    return null;
  }
}

class End extends Time {
  private final Start start;

  public End(int value, Start start) {
    super(value);
    this.start = start;
  }

  @Override
  boolean isStart() {
    return false;
  }

  @Override
  Time getStart() {
    return start;
  }
}

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = in.nextInt();

    for (int i = 1; i <= testCases; i++) {
      System.out.println("Case #" + i + ": " + getSequence(in));
    }
  }

  private static String getSequence(Scanner in) {
    int schedules = in.nextInt();
    in.nextLine();
    List<Time> times = new ArrayList<>();

    for (int j = 0; j < schedules; j++) {
      String[] splits = in.nextLine().split(" ");
      Start start = new Start(Integer.parseInt(splits[0]));
      End end = new End(Integer.parseInt(splits[1]), start);
      times.add(start);
      times.add(end);
    }

    times.sort(Comparator.comparingInt(t -> t.value));
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
        } else {
          sb.append("J");
          jamie = time;
        }
      } else {
        if (cameron == time.getStart()) {
          cameron = null;
        } else {
          jamie = null;
        }
      }
    }
    return sb.toString();
  }
}