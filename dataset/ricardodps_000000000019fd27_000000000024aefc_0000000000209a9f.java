
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) throws FileNotFoundException {

    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    //Scanner sc = new Scanner(new File("java/src/codejam/nesting/depth/input.in"));
    int T = sc.nextInt();

    for (int t = 0; t < T; t++) {
      String digits = sc.next();
      int n = 0;
      System.out.printf("Case #%d: ", t + 1);
      for (int i = 0; i < digits.length(); i++) {
        int d = (int) digits.charAt(i) - '0';
        if(d > n) {
          for (int j = 0; j < d - n; j++)
            System.out.print("(");
        }
        else if(d < n) {
          for (int j = 0; j < n - d; j++)
            System.out.print(")");
        }
        n = d;
        System.out.print(d);
      }
      //Closing remainders
      for (int j = 0; j < n; j++)
        System.out.print(")");

      System.out.println();
    }
  }
}
