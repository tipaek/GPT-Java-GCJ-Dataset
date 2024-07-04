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
    Character[] ansArr = new Character[N];
    boolean[] used = new boolean[N];
    boolean[] C = new boolean[24*60];
    boolean[] J = new boolean[24*60];
    int count = 0;
    while (count < N) {
      // find the min start
      int idx = -1;
      int minStart = 24*60;
      for (int i = 0; i < N; i++) {
        if (!used[i] && arr[i][0] < minStart) {
          idx = i;
          minStart = arr[i][0];
        }
      }
      used[idx] = true;
      int start = arr[idx][0];
      int end = arr[idx][1];
      if (isAvail(C, start, end)) {
        ansArr[idx] = 'C';
        set(C, start, end);
      } else {
        ansArr[idx] = 'J';
        set(J, start, end);
      }
      count++;
    }
    String ans = "";
    for (int i = 0; i < ansArr.length; i++) ans += ansArr[i];
    return ans;
  }

  static void print_2d_arr(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%d %d", arr[i][0], arr[i][1]);
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int[][] arr = new int[N][2];
      int id = 0;
      for (int n = 0; n < N; n++) {
        arr[n][0] = sc.nextInt();
        arr[n][1] = sc.nextInt();
      }
      /*
      Arrays.sort(arr, new Comparator<int[]>() {
        public int compare(int[] a, int [] b) {
          return Integer.compare(a[0], b[0]);
        }
      });
      */
      // print_2d_arr(arr);
      String ans = algo(arr);
      System.out.println("Case #" + (t+1) + ": " + ans);
    }
  }
}