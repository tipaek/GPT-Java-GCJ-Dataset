import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    int b = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      solve(B, in);
      if (in.next().charAt(0) == 'N') {
          break;
      } else{
          continue;
      }
    }
  }
  
  public static solve(int B, Scanner in) {
    System.out.println("111111");
    System.out.flush();
  }
}