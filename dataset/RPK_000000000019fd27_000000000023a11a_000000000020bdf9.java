import java.util.*;
import java.io.*;
public class Solution {
  public class Task {
    int id;
    int s;
    int e;
    char p;
    
    public Task(int id, int s, int e) {
      this.id = id;
      this.s = s;
      this.e = e;
      this.p = ' ';
    }
  }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    Solution sol = new Solution();
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Task[] task = new Task[n];
      for (int j = 0; j < n; ++j) {
          task[j] = sol.new Task(j, in.nextInt(), in.nextInt());
      }
      Arrays.sort(task, new Comparator<Task>() {
        public int compare(Task a, Task b) {
            if(a.s == b.s) {
                return a.e == b.e ? a.id - b.id : a.e - b.e;
            } else {
                return a.s - b.s;
            }
        } 
      });
      int lc = 0;
      int lj = 0;
      boolean imp = false;
      for (int j = 0; j < n; ++j) {
        if (lc <= task[j].s) {
          task[j].p = 'C';
          lc = task[j].e;
        } else if (lj <= task[j].s) {
          task[j].p = 'J';
          lj = task[j].e;
        } else {
          imp = true;
          break;
        }
      }
      String res = "IMPOSSIBLE";
      if (!imp) {
        Arrays.sort(task, new Comparator<Task>(){
          public int compare(Task a, Task b) {
            return a.id - b.id;
          }
        });
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; ++j) {
          sb.append(task[j].p);
        }
        res = sb.toString();
      }
      System.out.println("Case #" + i + ": " + res);
    }
  }
}