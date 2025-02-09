import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numberOfCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.


    for(int k = 1; k <= numberOfCases; k++) {
      int size = in.nextInt();
      in.nextLine();
      int[][] timeTable = sanitizeInput(size, in);
      Arrays.sort(timeTable, Comparator.comparing((int[] itv) -> itv[0]));

      int cStart = timeTable[0][0];
      int cEnd = timeTable[0][1];
      int jStart = -1;
      int jEnd = -1;
      String[] answer = new String[size];
      answer[timeTable[0][2]] = "C";


      for(int i = 1; i < timeTable.length; i++) {
        int startTime = timeTable[i][0];
        int endTime = timeTable[i][1];
        int originalPos = timeTable[i][2];
        if(cEnd <= startTime) {
          answer[originalPos] = "C";
          cStart = startTime;
          cEnd = endTime;
        } else if (cEnd > startTime && jEnd > startTime) {
          answer[0] = "IMPOSSIBLE";
          break;
        } else if (cEnd > startTime && jEnd <= startTime) {
          answer[originalPos] = "J";
          jStart = startTime;
          jEnd = endTime;
        }
      }

      if(!answer[0].equals("IMPOSSIBLE")) {
        String ans = "";
        for(int i = 0; i < answer.length; i++) {
          ans += answer[i];
        }
        System.out.println("Case #" + k + ": " + ans);
      } else {
        System.out.println("Case #" + k + ": IMPOSSIBLE");
      }

      // for(int i = 0; i < timeTable.length; i++) {
      //   for(int j = 0; j < timeTable[0].length; j++) {
      //     System.out.print(timeTable[i][j] + " ");
      //   }
      //   System.out.println(" ");
      // }
    }

    }


  public static int[][] sanitizeInput(int num, Scanner in) {
    int[][] timeTable = new int[num][3];
    for(int i = 0; i < num; i++) {
      String[] tokens = in.nextLine().split(" ");
      timeTable[i][0] = Integer.parseInt(tokens[0]);
      timeTable[i][1] = Integer.parseInt(tokens[1]);
      timeTable[i][2] = i;
    }
    return timeTable;
  }
}