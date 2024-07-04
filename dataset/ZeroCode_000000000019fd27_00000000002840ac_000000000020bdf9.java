import java.util.*;
import java.io.*;

class Activity {
    int st;
    int et;
    char doer;
    int pos;
    public Activity(int st, int et, int pos) {
        this.st = st;
        this.et = et;
        this.pos = pos;
    }
    
}

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      boolean flag = false;
      System.out.print("Case #" + i + ": ");
      List<Activity> activities = new ArrayList<>();
      for(int j = 0; j<n; j++) {
        activities.add(new Activity(in.nextInt(),in.nextInt(),j));
      }
      Collections.sort(activities, (a,b) -> { 
          if(a.st==b.st) return a.et-b.et;
          return a.st-b.st;
      });
      Queue<Activity> q = new PriorityQueue<>(4,(a,b)-> a.et-b.et);
      activities.get(0).doer = 'C';
      q.add(activities.get(0));
      for(int j=1; j<n; j++) {
          Activity a = activities.get(j);
          while(q.size()>0 && q.peek().et<=a.st) q.poll();
          if(q.size()>1) {
              flag =true;
              break;
          }
          if(q.size()==1) {
          	if(q.peek().doer=='C') a.doer = 'J';
          	else a.doer = 'C';
          }
          else a.doer = 'C';
          q.add(a);
      }
      
      if(flag) {
          System.out.println("IMPOSSIBLE");
      }
      else {
          Collections.sort(activities, (a,b) -> a.pos-b.pos);
          for(int j=0; j<n;j++) {
              System.out.print(activities.get(j).doer);
          }
          System.out.println("");
      }
      
    }
  }
}