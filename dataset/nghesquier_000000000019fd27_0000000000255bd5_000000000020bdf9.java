import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

        Pair p = new Pair(start, end, i);
        intervals.add(p);
      }

      intervals.sort(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
          return  o1.start - o2.start;
        }
      });

      char[] chars = new char[n];
      Arrays.fill(chars, '*');
      String result = new String(chars);
      StringBuilder myString = new StringBuilder(result);

      int jFinishTime = 0;
      int cFinishTime = 0;

      for (int i = 0; i < intervals.size(); i++) {
        int currentTaskFinish = intervals.get(i).getEnd();
        Pair interval = intervals.get(i);

        if(i+1 > intervals.size() - 1)
          break;

        Pair nextInterval = intervals.get(i + 1);

        int nextTaskBegin = nextInterval.getStart();
        int nextTaskFinish = nextInterval.getEnd();

        if(i == 0) {
          myString.setCharAt(interval.getTaskNumber(), 'C');
          cFinishTime = currentTaskFinish;
        }

        if(cFinishTime <= nextTaskBegin) {
          myString.setCharAt(nextInterval.getTaskNumber(), 'C');
          cFinishTime = nextTaskFinish;
        } else if (jFinishTime <= nextTaskBegin) {
          myString.setCharAt(nextInterval.getTaskNumber(), 'J');
          jFinishTime = nextTaskFinish;
        } else if(cFinishTime <= nextTaskBegin && jFinishTime <= nextTaskBegin) {
          myString.setCharAt(nextInterval.getTaskNumber(), 'C');
          cFinishTime = nextTaskFinish;
        } else {
            myString = new StringBuilder("IMPOSSIBLE");
          break;
        }
      }

      System.out.println("Case #" + k + ": " + myString.toString());
    }
  }

  private static class Pair {
    private int start;
    private int end;
    private int taskNumber;

    public Pair(int start, int end, int taskNumber) {
      this.start = start;
      this.end = end;
      this.taskNumber = taskNumber;
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

    public int getTaskNumber() {
      return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
      this.taskNumber = taskNumber;
    }
  }
}
