import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
      
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

    for (int i = 1; i <= t; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      String m = in.next();

    int totNoOfSteps = x + y;
     int stepsCanBeTaken = m.length();

     
     int curStepsAway = totNoOfSteps;
     int herCurX = x;
     int herCurY = y;
     
      HashMap<Integer, Integer> map = new HashMap<>();
      int minStepsAway = totNoOfSteps;

      int sol = -1;
     for(int j = 0; j < m.length(); j++) {

        char c = m.charAt(j);

        if(c == 'N') {
           herCurY++;
        }else if( c == 'S') {
          herCurY--;
        }else if(c  == 'E') {
          herCurX++;
        }else if(c  == 'W') {
          herCurY--;
        }

        curStepsAway = Math.abs(herCurX) + Math.abs(herCurY);

        if(curStepsAway < minStepsAway) {
           minStepsAway = curStepsAway;
        }

        Integer min = map.get(curStepsAway);
        if(min == null)
          map.put(curStepsAway, j+1);

        if(curStepsAway <= j+1) {
          sol = j+1;
          break;
        }

     }

     String res = "IMPOSSIBLE";
     if(sol != -1)
        res = Integer.toString(sol);

      System.out.println("Case #" + i + ": " + res);
    }
    
  }

}
