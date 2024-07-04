import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int activities = in.nextInt();
        int[][] a = new int[activities][2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < activities; j++) {
            a[j][0] = in.nextInt();
            a[j][1] = in.nextInt();
            min = Math.min(min, a[j][0]);
            max = Math.max(max, a[j][1]);
        }
      solve(min, max, a, i);
    }
  }
  
  private static boolean check(Set<int[]> scs, int start, int end) {
        if(scs.size() <= 0) {
            return true;
        }
        int pre = -1;
        int next = 3601;
        for (int[] sc : scs) {
            if (pre >= 0 && next <= 3600) {
                break;
            }
            if (sc[1] <= start) {
                pre = Math.max(sc[1], pre);
            } else if (sc[0] >= end) {
                next = Math.min(next, sc[0]);
            }
        }
        if (pre >= 0 && next == 3601) {
            return true;
        } else if (next <= 3600 && pre == -1) {
            return true;
        }
        return pre >= 0 && next <= 3600;
    }
  
  private static void solve(int min, int max, int[][] a, int caseNum) {
    Set<int[]> scsJ = new HashSet(); 
    Set<int[]> scsC = new HashSet();
      
    int length = a.length;
    StringBuilder answer = new StringBuilder();
    for(int i = 0; i < length; i++) {
        int start = a[i][0];
        int end = a[i][1];
        if(check(scsC, start, end)) {
            scsC.add(a[i]);
            answer.append("C");
        }else if(check(scsJ, start, end)) {
            scsJ.add(a[i]);
            answer.append("J");
        }else {
            i = length;
        }
    }
    if(answer.length() == length) {
        System.out.println("Case #" + caseNum + ": "+answer.toString());
    }else {
        System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
    }
  }
}