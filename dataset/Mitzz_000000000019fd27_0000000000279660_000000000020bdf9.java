import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner sc  = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    for(int i = 0; i < t; ++i) {
      int n = sc.nextInt();
      sc.nextLine();

      List<IntervalTimeHolder> jobs = new ArrayList<>();
      char[] assignment = new char[n];
      for(int j = 0; j < n; ++j) {
        String[] intervalTime = sc.nextLine().split(" ");
        jobs.add(new IntervalTimeHolder(Integer.parseInt(intervalTime[0]), Integer.parseInt(intervalTime[1]), j));
      }

      Collections.sort(jobs);
      boolean flag = true;
      int cLatestAvailableTime = -1, jLatestAvailableTime = -1;
      for(IntervalTimeHolder interval: jobs) {
        //System.out.println(interval.startTime);
        if(interval.startTime >= cLatestAvailableTime) {
          assignment[interval.index] = 'C';
          cLatestAvailableTime = interval.endTime;
        } else if(interval.startTime >= jLatestAvailableTime) {
          assignment[interval.index] = 'J';
          jLatestAvailableTime = interval.endTime;
        } else {
          System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
          flag = false;
          break;
        }
      }

      if(flag) {
        System.out.println("Case #" + (i + 1) + ": " + String.valueOf(assignment));
      }
    }
  }

  private static class IntervalTimeHolder implements Comparable {
    int startTime;
    int endTime;
    int index;

    public IntervalTimeHolder(int startTime, int endTime, int index) {
      this.startTime = startTime;
      this.endTime = endTime;
      this.index = index;
    }

    @Override
    public int compareTo(Object o) {
      IntervalTimeHolder anotherInterval = (IntervalTimeHolder) o;
      return Integer.compare(this.startTime, anotherInterval.startTime);
    }
  }
}