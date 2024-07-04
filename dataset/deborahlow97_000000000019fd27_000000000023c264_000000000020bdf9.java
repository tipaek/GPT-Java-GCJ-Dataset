import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int num = Integer.parseInt(input.nextLine());
    StringBuilder sb;
    String line, ans="";
    PriorityQueue<Activity> alist;
    Activity act;
    for (int i=0; i<num; i++) {
      int activities = Integer.parseInt(input.nextLine());
      alist = new PriorityQueue<>((a,b) -> a.start - b.start);
      char[] actarr = new char[activities];
      ans = "";
      for (int j=0; j<activities; j++) {
        line = input.nextLine();
        String[] split = line.split(" ");
        alist.add(new Activity(Integer.parseInt(split[0]), Integer.parseInt(split[1]), j));
      }
      int C = 0;
      int J = 0;
      while (!alist.isEmpty()) {
        act = alist.poll();
        if (C < J) {
          if (C <= act.start) {
            C = act.end;
            actarr[act.idx] = 'C';
          }
          else if (J <= act.start) {
            J = act.end;
            actarr[act.idx] = 'J';
          }
          else {
            ans = "IMPOSSIBLE";
            break;
          }
        }
        else {
          if (J <= act.start) {
            J = act.end;
            actarr[act.idx] = 'J';
          }
          else if (C <= act.start) {
            C = act.end;
            actarr[act.idx] = 'C';
          }
          else {
            ans = "IMPOSSIBLE";
            break;
          }
        }
      }

      sb = new StringBuilder();
      if (ans.equals("IMPOSSIBLE"))
        sb.append("Case #").append(i+1).append(": ").append(ans);
      else {
        String string = new String(actarr);
        sb.append("Case #").append(i+1).append(": ").append(string);
      }
      System.out.println(sb.toString());
    }
  }
}

class Activity {
  int start;
  int end;
  int idx;
  public Activity(int start, int end, int idx) {
    this.start = start;
    this.end = end;
    this.idx = idx;
  }
}