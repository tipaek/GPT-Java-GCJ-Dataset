import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

  private static final String IMPOSSIBLE = "IMPOSSIBLE";

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int caseCount = Integer.parseInt(in.nextLine());
    for (int caseNumber = 1; caseNumber <= caseCount; caseNumber++) {
      int rangeCount = Integer.parseInt(in.nextLine());
      boolean impossible = false;
      Kid c = new Kid();
      Kid j = new Kid();
      StringBuilder sb = new StringBuilder();
      while (rangeCount > 0) {
        rangeCount--;
        String rangeString = in.nextLine();
        if (impossible) {
          continue;
        }
        Range range = new Range(rangeString);
        if (c.accept(range)) {
          sb.append("C");
        } else if (j.accept(range)) {
          sb.append("J");
        } else {
          c = null;
          j = null;
          sb = null;
          impossible = true;
        }
      }


      System.out.println("Case #" + caseNumber + ": " + (impossible ? IMPOSSIBLE : sb.toString()));
    }
  }

  static class Kid {
    private final LinkedList<Range> busySlots = new LinkedList<>();

    boolean accept(Range r) {
      if (busySlots.isEmpty() || busySlots.stream().allMatch(range -> range.notOverlaps(r))) {
        busySlots.add(r);
        return true;
      }
      return false;
    }
  }

  static class Range {
    private final int start, end;

    Range(String line) {
      String[] vals = line.split(" ");
      start = Integer.parseInt(vals[0]);
      end = Integer.parseInt(vals[1]);
    }

    boolean notOverlaps(Range r) {
      return r.start >= end || r.end <= start;
    }

    @Override
    public String toString() {
      return "[" + start + "," + end + "]";
    }
  }
}
