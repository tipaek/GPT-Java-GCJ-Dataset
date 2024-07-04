//package Q2020.parentingparenting;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 1; i <= t; i++) {
      int n = sc.nextInt();
      Activity[] act = new Activity[n];
      for(int j=0; j<n;j++) {
        act[j] = new Activity(sc.nextInt(), sc.nextInt(), j);
      }
      Arrays.sort(act);
      ActityAssignee[] actityAssignees = new ActityAssignee[n];
     
      boolean impossible = false;
      int index = 0;
      int cS = 0, cE = 0, jS = 0, jE = 0;
      for (Activity ac : act) {
        if(ac.s >= cE) {
          actityAssignees[index++] = new ActityAssignee(ac, 'C');
          cS = ac.s;
          cE = ac.e;
        } else if(ac.s >= jE)  {
          actityAssignees[index++] =new ActityAssignee(ac, 'J');
          jS = ac.s;
          jE = ac.e;
        } else {
          impossible = true;
          break;
        }
      }
      
      StringBuilder sb = new StringBuilder();
      if(!impossible) {
        Arrays.sort(actityAssignees);
        for (ActityAssignee actityAssignee : actityAssignees)
          sb.append(actityAssignee.assignee);
      }
      System.out.println(String.format("Case #%d: %s", i, impossible ? "IMPOSSIBLE" : sb.toString()));
      }
      sc.close();
    }

  static class ActityAssignee implements Comparable<ActityAssignee> {
    Activity act;
    Character assignee;
    
    ActityAssignee(Activity act, Character assignee) {
      this.act = act;
      this.assignee = assignee;
    }

    @Override
    public int compareTo(ActityAssignee o) {
      return this.act.i - o.act.i;
    }
  }  
    
  static class Activity  implements Comparable<Activity> {
    int s;
    int e;
    int i;
    public Activity(int s, int e, int i) {
      this.s = s;
      this.e = e;
      this.i = i;
    }

    @Override
    public int compareTo(Activity o) {
      return this.s - o.s;
    }

    @Override
    public String toString() {
      return s + " " + e;
    }
  }
}
  
  
