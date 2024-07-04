import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
  public static void main(String[] args) {
    Scanner sc  = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    for(int i = 0; i < t; ++i) {
      int n = sc.nextInt();
      sc.nextLine();

      Map<Integer, int[]> intervals = new TreeMap<>();
      char[] assignment = new char[n];
      for(int j = 0; j < n; ++j) {
        String[] intervalTime = sc.nextLine().split(" ");
        intervals.put(Integer.parseInt(intervalTime[0]), new int[]{ Integer.parseInt(intervalTime[1]), j });
      }

      /*if(n == 2) {
        System.out.println("Case #" + (i + 1) + ": CJ");
        continue;
      }*/

      boolean flag = true;
      int cLatestAvailableTime = -1, jLatestAvailableTime = -1;
      for(Map.Entry<Integer, int[]> interval: intervals.entrySet()) {
        //System.out.println(interval.getKey());
        if(interval.getKey() >= cLatestAvailableTime) {
          assignment[interval.getValue()[1]] = 'C';
          cLatestAvailableTime = interval.getValue()[0];
        } else if(interval.getKey() >= jLatestAvailableTime) {
          assignment[interval.getValue()[1]] = 'J';
          jLatestAvailableTime = interval.getValue()[0];
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
}