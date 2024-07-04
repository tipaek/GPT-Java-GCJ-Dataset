import java.util.Scanner;

public class Solution {
  public static void solve(Scanner input,String m) {
    System.out.println(m);
    String s = input.next();
    if (s.equals("0")) {
      return;
    } else if (s.equals("1")) {
      solve(input, s);
    } else {
      solve(input, s);
    }
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int b = input.nextInt();
    for (int s = 1; s <= T; s++) {
      solve(input,"11");
    }
  }
}