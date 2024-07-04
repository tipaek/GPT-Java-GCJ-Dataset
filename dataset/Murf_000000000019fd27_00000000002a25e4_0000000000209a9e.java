import java.util.Scanner;

public class Solution {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      StringBuilder sb = new StringBuilder();
      for( int i=1; i<=B; i++ ) {
          System.out.println( i );
          int v = input.nextInt();
          sb.insert(0, Integer.toString(v));
      }
      System.out.println(sb.toString());
      String response = input.next();
      if( response.equals("N")) {
          ks = T;
      }
    }
  }
}