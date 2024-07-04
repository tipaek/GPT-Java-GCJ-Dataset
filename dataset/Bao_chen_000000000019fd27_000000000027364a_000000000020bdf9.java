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
  
  private static boolean check(boolean[] scs, int start, int end) {
        int left = start;
        int right = end;
        while(left <= right) {
            if(scs[left] && left != start) {
                return false;
            }
            if(scs[right] && right != end) {
                return  false;
            }
            left++;
            right--;
        }
        return true;
    }


    private static void solve(int[][] a, int caseNum) {
        boolean[] scsJ = new boolean[3601];
        boolean[] scsC = new boolean[3601];
        int length = a.length;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int start = a[i][0];
            int end = a[i][1];
            if (check(scsJ, start, end)) {
                int left = start;
                int right = end;
                while (left < right) {
                    scsJ[left] = true;
                    scsJ[right] = true;
                    left++;
                    right--;
                }
                answer.append("J");
            } else if (check(scsC, start, end)) {
                int left = start;
                int right = end;
                while (left < right) {
                    scsC[left] = true;
                    scsC[right] = true;
                    left++;
                    right--;
                }
                answer.append("C");
            } else {
                i = length;
            }
        }
        if (answer.length() == length) {
            System.out.println("Case #" + caseNum + ": " + answer.toString());
        } else {
            System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
        }
    }
}