import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
        int activities = in.nextInt();
        int[][] a = new int[activities][2];
        for(int j = 0; j < activities; j++) {
            a[j][0] = in.nextInt();
            a[j][1] = in.nextInt();
        }
        solve(a, i);
    }
  }
  
  private static boolean check(Set<int[]> scs, int start, int end) {
        if (scs.size() == 0) {
            return true;
        } else if (scs.size() == 1) {
            for (int[] s : scs) {
                if (start >= s[1]) {
                    return true;
                } else if (end <= s[0]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        int left = -1;
        int right = 3601;
        for (int[] s : scs) {
            if (start >= s[1]) {
                left = Math.max(left, s[1]);
            }
            if (end <= s[0]) {
                right = Math.min(right, s[0]);
            }
        }
        System.out.println(left + "," + right);
        if(left >= 0 && right == 3601) {
            return true;
        }
        return left >= 0 && right <= 3600;
    }


    private static void solve(int[][] a, int caseNum) {
        Set<int[]> scsJ = new HashSet();
        Set<int[]> scsC = new HashSet();
        int length = a.length;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int start = a[i][0];
            int end = a[i][1];
            if (check(scsJ, start, end)) {
                scsJ.add(a[i]);
                answer.append("J");
            } else if (check(scsC, start, end)) {
                scsC.add(a[i]);
                answer.append("C");
            } else {
                i = length;
            }

            // System.out.println(answer.toString());
        }
        if (answer.length() == length) {
            System.out.println("Case #" + caseNum + ": " + answer.toString());
        } else {
            System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
        }
    }
}