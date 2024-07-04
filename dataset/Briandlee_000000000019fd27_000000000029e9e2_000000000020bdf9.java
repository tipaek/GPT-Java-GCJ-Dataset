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
      // finding the greatestTime
      int greatestTime = startingTimes[0];
      for (int j = 0; j < startingTimes.length; j++){
        if (startingTimes[j] > greatestTime){
          greatestTime = startingTimes[j];
        }
      }
      for (int j = 0; j < endingTimes.length; j++){
        if (endingTimes[j] > greatestTime){
          greatestTime = endingTimes[j];
        }
      }
      // setting the initial time for c and j to be 0 for everything
      for (int j = 0; j < greatestTime; j++){
        cameronList.add(0);
        jamieList.add(0);
      }
      // actual calculations
      // try c first and then j
      for (int j = 0; j < N; j++){
        if (cameronList.get(startingTimes[j]) == 0 && cameronList.get(endingTimes[j] - 1) == 0){
          // adding to cameronList
          for (int k = startingTimes[j]; k < endingTimes[j] - 2; k++){
            cameronList.add(k, 1);
          }
          parentsList.add("C");
        } else if (jamieList.get(startingTimes[j]) == 0 && jamieList.get(endingTimes[j] - 1) == 0){
          for (int k = startingTimes[j]; k < endingTimes[j]; k++){
            jamieList.add(k, 1);
          }
          parentsList.add("J");
        } else {
          parentsList.add("IMPOSSIBLE");
        }

      }
      int index = i + 1;
      if (parentsList.contains("IMPOSSIBLE")){
        System.out.println("Case #" + index + ": " + "IMPOSSIBLE");
      } else {
        System.out.print("Case #" + index + ": ");
        for (String e : parentsList){
          System.out.print(e);
        }
        System.out.println();
      }
    }
  }

}
