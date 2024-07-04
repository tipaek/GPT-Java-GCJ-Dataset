import java.util.Scanner;

public class Solution {
  public static void solve(Scanner input, int A, int B) {
      for (int i = -5; i <= 5;i++) {
          for (int j = -5; j <= 5; j++) {
              System.out.println(i + " " + j);
              String s = input.next();
              if (s.equals("Center")) {
                  return;
              }
          }
      }
    return;
    
  }

  public static void main(String args[]) {
      int pow = 1;
      for (int i = 1; i <= 9; i++) 
        pow *= 10;
      long initUpperLeft[] =new long[]{-pow, pow};
      long initBottomRight[] = new long[]{pow,-pow};
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int A = input.nextInt();
    int B= input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
         solve(input,A,B);
    }
  }
}