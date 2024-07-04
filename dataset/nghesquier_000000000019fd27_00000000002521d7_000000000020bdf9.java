import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


    //Number of tests
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    //For each test case
    for (int k = 1; k <= t; ++k) {
      int n = in.nextInt();

      List<Pair> intervals = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        int start = in.nextInt();
        int end = in.nextInt();

        Pair p = new Pair(start, end);
        intervals.add(p);
      }

      intervals.sort(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
          return  o1.start - o2.start;
        }
      });

      String result = "";

      int jFinishTime = 0;
      int cFinishTime = 0;

      for (int i = 0; i < intervals.size(); i++) {
        int currentTaskFinish = intervals.get(i).getEnd();

        if(i+1 > intervals.size() - 1)
          break;

        int nextTaskBegin = intervals.get(i + 1).getStart();
        int nextTaskFinish = intervals.get(i + 1).getEnd();

        if(i == 0) {
          result += 'C';
          cFinishTime = currentTaskFinish;
        }

        if(cFinishTime <= nextTaskBegin) {
          result += 'C';
          cFinishTime = nextTaskFinish;
        } else if (jFinishTime <= nextTaskBegin) {
          result += 'J';
          jFinishTime = nextTaskFinish;
        } else if(cFinishTime <= nextTaskBegin && jFinishTime <= nextTaskBegin) {
          result += 'C';
          cFinishTime = nextTaskFinish;
        } else {
          result = "IMPOSSIBLE";
          break;
        }
      }

      System.out.println("Case #" + k + ": " + result);
    }
  }

  private static class Pair {
    private int start;
    private int end;

    public Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public void setStart(int start) {
      this.start = start;
    }

    public int getEnd() {
      return end;
    }

    public void setEnd(int end) {
      this.end = end;
    }
  }
}
