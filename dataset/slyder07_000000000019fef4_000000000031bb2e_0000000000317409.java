import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

  private Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

  public static void main(String[] args) {
    new Solution().solveAll();
  }

  void solveAll(){
    int T = in.nextInt();
    for(int i = 1; i <= T; i++){
      String res = solveTest();
      out.println("Case #" + i + ": " + res);
    }
  }


  public String solveTest() {
    long x = in.nextInt();
    long y = in.nextInt();
    String m = in.next();
    if(x == 0 && y == 0){
      return "0";
    }

    for(int i = 1; i <= m.length(); i++){
      switch (m.charAt(i-1)){
        case 'S':
          y--;
          break;
        case 'N':
          y++;
          break;
        case 'E':
          x--;
          break;
        case 'W':
          x++;
          break;
      }

      long newDist = Math.abs(x) + Math.abs(y);
      if(newDist <= i){
        return String.valueOf(i);
      }
    }


    return "IMPOSSIBLE";
  }



}
