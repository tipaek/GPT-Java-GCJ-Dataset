import java.util.*;
    import java.io.*;
    public class Solution {
      
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int taskCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= taskCount; ++i) {
          int n = in.nextInt();
          
          int[][] tasks = new int[n][];
          for( int j=0; j<n; j++ ) {
            tasks[j] = new int[] {in.nextInt(), in.nextInt(), j, 0};
          }
          Arrays.sort(tasks, (A,B)->A[0]-B[0]);
          boolean possible = true;
          int[] maxEnd = new int[2];
          
          tasks[0][3] = 'C';
          maxEnd[0] = tasks[0][1];
          for( int j=1; j<tasks.length && possible; j++ ) {
              if( tasks[j][0] >= tasks[j-1][1] ) { 
                  tasks[j][3] = tasks[j-1][3];
              }
              else {
                  if( tasks[j-1][3] == 'C' ) tasks[j][3] = 'J';
                  else tasks[j][3] = 'C';
              }
              if( maxEnd[0] > tasks[j][0] &&
                  maxEnd[1] > tasks[j][0] ) possible = false;

              if( tasks[j][1] > maxEnd[0] ) {
                  maxEnd[1] = maxEnd[0];
                  maxEnd[0] = tasks[j][1];
              }
              else if( tasks[j][1] > maxEnd[1] ) {
                  maxEnd[1] = tasks[j][1];
              }
          }
          String retStr = "";
          if( !possible ) retStr = "IMPOSSIBLE";
          else {
              Arrays.sort(tasks, (A, B)->A[2]-B[2]);
              for( int j=0; j<tasks.length; j++ ) {
                retStr += (char) tasks[j][3];
              }
          }
          System.out.println("Case #" + i + ": " + retStr);
        }
      }
    }