import java.util.*;
import java.io.*;

public class Solution {
    
    private boolean checkIfFree(int[][] time, int start, int end) {
        boolean free = true;
        for ( int i = 0 ; i < time.length; i++ ) {
            if ( (time[i][0] == 0 && time[i][1] == 0) ) continue;
            
            if ( ( time[i][0] < start && time[i][1] > start ) || ( time[i][0] < end && time[i][1] > end )) {
                return false;
            } else if (( start < time[i][0] && end > time[i][0] ) || ( start < time[i][1] && end > time[i][1])){
                return false;
            }
            if ( time[i][0] == start && time[i][1] == end ) {
                return false;
            }
            //System.out.println("->Start #" + start + ": END : " + end + ": Arrays : " + Arrays.toString(time[i]));
        }
        
        return free;
    }
    
    private String checkTheSchedule(int[][] time) {
        String person = "";
        //Solution sol = new Solution();
        int[][] c = new int[time.length][2];
        int countC = 0;
        int[][] j = new int[time.length][2];
        int countJ = 0;
        for ( int i = 0; i < time.length; i++ ) {
             if ( checkIfFree(c, time[i][0], time[i][1]) ) {
                person += "C";
                 c[countC][0] = time[i][0];
                c[countC][1] = time[i][1];   
                countC++;
            } else if ( checkIfFree(j, time[i][0], time[i][1]) ) {
                person += "J";
                j[countJ][0] = time[i][0];
                j[countJ][1] = time[i][1];
                countJ++;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return person;
    }
    
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution sol = new Solution();
        int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
          int matrixLength = in.nextInt(); // N
          int[][] timeMatrix = new int[matrixLength][2] ;
          for (int j = 0; j < matrixLength; j++) {
            for (int k = 0; k < 2; k++) {
                timeMatrix[j][k] = in.nextInt();
            }
          }
          String activity = sol.checkTheSchedule(timeMatrix);
          System.out.println("Case #1: POSSIBLE");
          System.out.println("2 1 3");
          System.out.println("3 2 1");
          System.out.println("1 3 2");
          System.out.println("Case #2: IMPOSSIBLE");
          // System.exit(0);
        }
      }
}