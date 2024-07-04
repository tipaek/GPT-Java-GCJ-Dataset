import java.util.*;
import java.io.*;

class Solution {
  
  public static void main(String[] args) throws Exception {
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    
    int TT = Integer.parseInt(in.readLine());
    int currTT = 0;
    StringBuilder output = new StringBuilder();
    
    while (currTT++ < TT) {
      output.append("Case #" + currTT + ": ");
      
      int N = Integer.parseInt(in.readLine());

      PriorityQueue<Activity> activities = new PriorityQueue<Activity>();
      for (int i = 0; i < N; i++) {
        String[] input = in.readLine().split("\\s+");
        activities.add(new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
      }

      boolean possible = true;
      Activity Ca = new Activity(-1, -1);
      Activity Ja = new Activity(-1, -1);
      StringBuilder schedule = new StringBuilder();
      while(!activities.isEmpty()) {
        Activity a = activities.poll();
        if (a.s >= Ca.e) {
          schedule.append('C');
          Ca = a;
        } else if (a.s >= Ja. e) {
          schedule.append('J');
          Ja = a;
        } else {
          possible = false;
          break;
        }
      }

      output.append(possible ? schedule : "IMPOSSIBLE");
      output.append('\n');
    }
    
    out.print(output);
    
    in.close();
    out.close();
  }
  
}

class Activity implements Comparable<Activity> {
  int s, e;

  Activity (int s, int e) {
    this.s = s;
    this.e = e;
  }

  public int compareTo(Activity a) {
    if (this.s < a.s) {
      return -1;
    }
    if (this.s > a.s) {
      return 1;
    }
    return Integer.compare(this.e, a.e);
  }
}
