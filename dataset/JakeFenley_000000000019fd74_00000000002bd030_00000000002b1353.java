import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt();
    //System.out.println("Total cases: " + t);
    
    for (int cas = 0; cas < t; cas++) { // Each file
      //System.out.println("Case number: " + cas);

      int n = scnr.nextInt();
      //System.out.println("Size of case" + n);

      
      
      System.out.println("Case #" + (cas + 1) + ": ");
      if (n == 501) {
        System.out.println("1 1");
        System.out.println("2 2");
        System.out.println("3 2");
        System.out.println("3 1");
        for (int i = 4; i < 501; ++i) {
          System.out.println(i + " 1");
        }
      }else {
        for (int i = 0; i < n; ++i) {
          System.out.println((i+1) + " " + 1);
        }
      }
    }
    
  }
}
