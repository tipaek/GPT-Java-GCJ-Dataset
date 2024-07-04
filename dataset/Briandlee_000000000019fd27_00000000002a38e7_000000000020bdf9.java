import java.util.*;

public class Solution {

  public static void main(String[] args){
    calculations();
  }

  public static void calculations(){
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int i = 0; i < T; i++){
      int N = scanner.nextInt();
      int[] startingTimes = new int[N];
      int[] endingTimes = new int[N];
      for (int j = 0; j < N; j++){
        startingTimes[j] = scanner.nextInt();
        endingTimes[j] = scanner.nextInt();
      }
      ArrayList<Integer> cameronList = new ArrayList<Integer>();
      ArrayList<Integer> jamieList = new ArrayList<Integer>();
      ArrayList<String> parentsList = new ArrayList<String>();
      String parentsString = "";
      // finding the greatestTime
      int greatestTime = startingTimes[0];
      for (int j = 0; j < startingTimes.length; j++){
        if (startingTimes[j] > greatestTime){
          greatestTime = startingTimes[j];
        }
      }

      for (int jj = 0; jj < endingTimes.length; jj++){
        if (endingTimes[jj] > greatestTime){
          greatestTime = endingTimes[jj];
        }
      }
      greatestTime++;
      // setting the initial time for c and j to be 0 for everything
      for (int jjj = 0; jjj < greatestTime; jjj++){
        cameronList.add(0);
        jamieList.add(0);
      }
      // actual calculations
      // try c first and then j
      for (int jjjj = 0; jjjj < N; jjjj++){
        if (cameronList.get(startingTimes[jjjj]) == 0 && cameronList.get(endingTimes[jjjj]) == 0){
          for (int k = startingTimes[jjjj]; k < endingTimes[jjjj]; k++){
            cameronList.set(k, 1);
          }
          parentsList.add("C");
          parentsString = parentsString + "C";
        } else if (jamieList.get(startingTimes[jjjj]) == 0 && jamieList.get(startingTimes[jjjj]) == 0){
          for (int kk = startingTimes[jjjj]; kk < endingTimes[jjjj]; kk++){
            jamieList.set(kk, 1);
          }
          parentsList.add("J");
          parentsString = parentsString + "J";
        } else {
          parentsList.add("IMPOSSIBLE");
        }
      }

      int index = i + 1;
      if (parentsList.contains("IMPOSSIBLE")){
        System.out.println("Case #" + index + ": " + "IMPOSSIBLE");
      } else {
        System.out.println("Case #" + index + ": " + parentsString);
      }
    }
  }

}
