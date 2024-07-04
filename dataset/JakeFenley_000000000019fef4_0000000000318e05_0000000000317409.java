import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt();
    //System.out.println("Total cases: " + t);
    
    for (int cas = 0; cas < t; cas++) { // Each file
      //System.out.println("Case number: " + cas);

      int x = scnr.nextInt();
      int y = scnr.nextInt();
      String path = scnr.next();
      
      
      boolean possible = false;
      int currDist = Math.abs(x) + Math.abs(y);
      
      for (int i = 0; i < path.length(); ++i) {
        char c = path.charAt(i);
        switch (c) {
          case 'N':
            y += 1;
            break;
          case 'S':
            y -=1;
            break;
          case 'E':
            x +=1;
            break;
          case 'W':
            x -=1;
            break;
        }

        if (Math.abs(x) + Math.abs(y) <= i + 1) {
          System.out.println("Case #" + (cas +1 ) + ": " + (i+1));
          possible = true;
          break;
        }
        
          
      }
      if (!possible) {
        System.out.println("Case #" + (cas + 1)+ ": IMPOSSIBLE");
      }
    }
    
  }
}

