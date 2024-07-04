import java.util.Scanner;

public class Solution {
  public static void solve(Scanner input, int[] b) {
    int m = b[0] % 10;
    System.out.println(m);
    String s = input.next();
    if (s.equals("0")) {
      return;
    } else if (s.equals("1")) {
      solve(input, b);
    } else {
      solve(input, b);
    }
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int V = input.nextInt();
    int[] b = new int[V];
    for (int s = 1; s <= T; s++) {
        for(int j =1;j<V;j++ ){
            b[j] = 1%10;
        }
      solve(input, b);
    }
  }
}