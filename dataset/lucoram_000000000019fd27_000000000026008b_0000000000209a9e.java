import java.util.*;
import java.io.*;

public class Solution {
    
  public static void main(String[] args) {
      
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine();
    
    for (int i = 1; i <= t; ++i) {
      String b = in.nextLine();
      String r = "";
      
      for(int k = 0; k <= 10; k++) {
          System.out.println(k);
          r += in.nextLine();
      }
      
      System.out.println(r);
      
      String res = in.nextLine();
      
      if(res.equals("N")) {
          System.exit(0);
      }
    }
  }
}