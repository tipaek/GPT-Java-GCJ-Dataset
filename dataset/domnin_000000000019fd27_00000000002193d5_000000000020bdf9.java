
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int tc = 1;
    while (t-- > 0) {
      int N = in.nextInt();
      int[][] arr = new int[N][];
      for (int i = 0; i < N; i++) {
        int inter[] = new int[3];
        inter[0] = in.nextInt();
        inter[1] = in.nextInt();
        inter[2] = i;
        arr[i] = inter;
      }
      Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
      char res[] = new char[N];
      int[] end = new int[2];
      int tot = 0;
      for (int[] inter : arr) {
        if (end[0] <= inter[0]) {
          end[0] = inter[1];
          res[inter[2]] = 'C';
          tot++;
        } else if (end[1] <= inter[0]) {
          end[1] = inter[1];
          res[inter[2]] = 'J';
          tot++;
        } else {
          break;
        }
      }
      if (tot < N) System.out.println("Case #" + tc++ + ": IMPOSSIBLE");
      else System.out.println("Case #" + tc++ + ": " + new String(res));
    }
    System.out.flush();
  }
}
