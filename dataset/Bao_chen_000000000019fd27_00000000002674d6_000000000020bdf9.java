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
  
  private static String check(int[] minMaxJ, int[] minMaxC, int min, int max) {
      int J = 0;
      int C = 0;
      for(int i = min; i <= max; i++) {
         if(minMaxJ[i] == 1 && J <= 1) {
            J++;
         }
         if(minMaxC[i] == 1 && C <= 1) {
            C++;
         }
         if(C >= 2 && J >= 2){
            i = max;
         }
      }
      if(J <= 1) {
        return "J";  
      }else if(C <= 1) {
        return "C";
      }else {
        return "IMPOSSIBLE";  
      }
  }
  
  private static void solve(int min, int max, int[][] a, int caseNum) {
    int[] minMaxC = new int[max+1]; 
    int[] minMaxJ = new int[max+1];
      
    int length = a.length;
    StringBuilder answer = new StringBuilder();
    for(int i = 0; i < length; i++) {
        int start = a[i][0];
        int end = a[i][1];
        String temp = check(minMaxJ, minMaxC, start, end);
        if(temp == "J") {
            for(int j = start; j <= end; j++) {
                minMaxJ[j] = 1;
            }
            answer.append(temp);
        }else if(temp == "C") {
            for(int j = start; j <= end; j++) {
                minMaxC[j] = 1;
            }
            answer.append(temp);
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