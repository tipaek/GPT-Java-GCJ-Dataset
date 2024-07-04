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
        activities.add(new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1]), i));
      }

      boolean possible = true;
      Activity Ca = new Activity(-1, -1, 0);
      Activity Ja = new Activity(-1, -1, 0);
      char[] assignment = new char[N];
      while(!activities.isEmpty()) {
        Activity a = activities.poll();
        if (a.s >= Ca.e) {
          assignment[a.o] = 'C';
          Ca = a;
        } else if (a.s >= Ja. e) {
          assignment[a.o] = 'J';
          Ja = a;
        } else {
          possible = false;
          break;
        }
      }

      if (possible) {
        for (int i = 0; i < N; i++) {
          output.append(assignment[i]);
        }
      } else {
        output.append("IMPOSSIBLE");
      }
      
      output.append('\n');
    }
    
    out.print(output);
    
    in.close();
    out.close();
  }
  
}

class Activity implements Comparable<Activity> {
  int s, e, o;

  Activity (int s, int e, int o) {
    this.s = s;
    this.e = e;
    this.o = o;
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
