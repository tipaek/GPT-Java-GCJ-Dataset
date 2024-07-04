import java.util.*;

public class Solution {

  static boolean isAvail(boolean[] CJ, int s, int e) {
    for (int i = s; i < e; i++) {
      if (CJ[i]) return false;
    }
    return true;
  }

  static void set(boolean[] CJ, int s, int e) {
    for (int i = s; i < e; i++) CJ[i] = true;
  }

  static String algo(int[][] arr) {
    int N = arr.length;
    int[] time = new int[24*60];
    for (int i = 0; i < arr.length; i++) {
      int start = arr[i][0];
      int end = arr[i][1];
      for (int t = start; t < end; t++) {
        time[t]++;
        if (time[t] >= 3) return "IMPOSSIBLE";
      }
    }
    String ans = "";
    boolean[] C = new boolean[24*60];
    boolean[] J = new boolean[24*60];
    for (int i = 0; i < arr.length; i++) {
      int start = arr[i][0];
      int end = arr[i][1];
      if (isAvail(C, start, end)) {
        ans += "C";
        set(C, start, end);
      } else {
        ans += "J";
        set(J, start, end);
      }
    }
    return ans;
  }



  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int[][] arr = new int[N][2];
      for (int n = 0; n < N; n++) {
        arr[n][0] = sc.nextInt();
        arr[n][1] = sc.nextInt();
      }
      String ans = algo(arr);
      System.out.println("Case #" + (t+1) + ": " + ans);
    }
  }
}