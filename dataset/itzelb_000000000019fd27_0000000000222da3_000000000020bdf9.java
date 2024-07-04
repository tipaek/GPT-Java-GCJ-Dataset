import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int testCase = 1; testCase <= t; ++testCase) {

      int n = in.nextInt();
      int[] c = new int[1440], j = new int[1440];
      int[][] activities = new int[n][2];
      String order = "";

      //check if possible
      boolean isImpossible = false;
      int[] fullSchedule = new int[1440];
      for(int i=0; !isImpossible && i<n; i++){
        activities[i][0] = in.nextInt();
        activities[i][1] = in.nextInt();
        for(int k = activities[i][0]; !isImpossible && k<activities[i][1]; k++){
          fullSchedule[k]++;
          if(fullSchedule[k]>=3){
            isImpossible = true;
            order = "IMPOSSIBLE";
          }
        }
      }

      if(!isImpossible){
        for(int i=0; i<n; i++){
          boolean isBusy = false;
          for(int k = activities[i][0]; k<activities[i][1]; k++){
            if(c[k]==1)
              isBusy = true;
          }
          if(!isBusy){
            for(int k = activities[i][0]; k<activities[i][1]; k++){
              c[k]++;
            }
            order += "C";  
          } else {
            for(int k = activities[i][0]; k<activities[i][1]; k++){
              j[k]++;
            } 
            order += "J";
          }
        }
      }

      System.out.println("Case #"+ testCase +": "+order);
    }
  }
}