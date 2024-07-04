import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int activities = in.nextInt();
      int startTime[] = new int[activities];
      int st = 0;
      int et = 0;
      Map<Integer,Integer> map = new HashMap<Integer,Integer>();
      for(int j = 0;j<activities;j++) {
         int m = in.nextInt();
         int n = in.nextInt();
         startTime[st++] = m;
         map.put(m,n);
      }
      
      Arrays.sort(startTime);
      int available = 2;
      String output = "";
      int jEndTime = 0;
      int cEndTime = 0;
      boolean jAvailable = true;
      boolean cAvailable = true;
      for(int k=0;k<startTime.length;k++) {
          int endTime = map.get(startTime[k]);
          if(!jAvailable) {
              if((jEndTime <= startTime[k])) {
                  jAvailable = true;
              }
          }
          
          if(!cAvailable) {
              if((cEndTime <= startTime[k])) {
                  cAvailable = true;
              }
          }
          
          if(jAvailable) {
              output += "J";
              available --;
              jEndTime = endTime;
              jAvailable = false;
          } else if(cAvailable) {
              output += "C";
              available --;
              cEndTime = endTime;
              cAvailable = false;
          } else {
              output = "IMPOSSIBLE";
              break;
          }
      }
      
      
      System.out.println("Case #" + i + ": " + output);
    }
  }
}