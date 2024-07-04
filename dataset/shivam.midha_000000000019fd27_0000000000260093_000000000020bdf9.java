import java.util.*;
import java.io.*;

class Activity {
  private Integer id;
  private Integer startTime;
  private Integer endTime;
  private String jobExecutor;

  public Activity(int id, int startTime, int endTime) {
    this.id = id;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public void setJobExecutor(String jobExecutor) {
    this.jobExecutor = jobExecutor;
  }

  public Integer getEndTime() {
    return endTime;
  }

  public Integer getStartTime() {
    return startTime;
  }

  public String getJobExecutor() {
    return jobExecutor;
  }

  public Integer getId() {
    return id;
  }
}

class FinishTimeSorter implements Comparator<Activity>
{
  @Override
  public int compare(Activity o1, Activity o2) {
    return o1.getEndTime().compareTo(o2.getEndTime());
  }
}

class IdSorter implements Comparator<Activity>
{
  @Override
  public int compare(Activity o1, Activity o2) {
    return o1.getId().compareTo(o2.getId());
  }
}

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      ArrayList<Activity> activities = new ArrayList<>();
      int n = in.nextInt();
      int isPossible = 1;
      if(n == 0) {
        System.out.println("Case #"+i+": ");
        continue;
      }
      else {
        for (int j = 1; j <= n; j++) {
          activities.add(new Activity(j, in.nextInt(), in.nextInt()));
        }

        activities.sort(new FinishTimeSorter());
        Integer cEndTime = activities.get(0).getEndTime();
        Integer jEndTime = null;
        activities.get(0).setJobExecutor("C");

        for(int j=1; j<n; j++) {
          int currentStartTime = activities.get(j).getStartTime();

          if(jEndTime == null) {
            if(cEndTime <= currentStartTime) {
              activities.get(j).setJobExecutor("C");
              cEndTime = activities.get(j).getEndTime();
            } else {
              activities.get(j).setJobExecutor("J");
              jEndTime = activities.get(j).getEndTime();
            }
          } else {
            if(jEndTime <= currentStartTime && cEndTime <= currentStartTime) {
              if(jEndTime > cEndTime) {
                activities.get(j).setJobExecutor("J");
                jEndTime = activities.get(j).getEndTime();
              } else {
                activities.get(j).setJobExecutor("C");
                cEndTime = activities.get(j).getEndTime();
              }
            } else if(jEndTime <= currentStartTime) {
              activities.get(j).setJobExecutor("J");
              jEndTime = activities.get(j).getEndTime();
            } else if(cEndTime <= currentStartTime) {
              activities.get(j).setJobExecutor("C");
              cEndTime = activities.get(j).getEndTime();
            } else {
              isPossible = 0;
              break;
            }
          }
        }

        if(isPossible == 0) {
          System.out.println("Case #"+i+": IMPOSSIBLE");
        } else {
          activities.sort(new IdSorter());
          String finalOutput = "Case #"+i+": ";
          for(int j=0; j<n; j++) {
            finalOutput += activities.get(j).getJobExecutor();
          }
          System.out.println(finalOutput);
        }
      }
    }
  }
}