import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; i++) {
      int size = in.nextInt();
      String output = "Case #" + i + ": ";
      ArrayList<int[]> cList = new ArrayList<>();
      ArrayList<int[]> jList = new ArrayList<>();
      int count;
      for (count = 0; count < size; count++) {
        int[] activity = new int[2];
        activity[0] = in.nextInt();
        activity[1] = in.nextInt();
        int currentIndex = searchInList(cList, activity);
        if (currentIndex == -1) {
          currentIndex = searchInList(jList, activity);
          if (currentIndex == -1) {
            System.out.println("Case #" + i + ": IMPOSSIBLE");
            break;
          } else {
            jList.add(currentIndex, activity);
            output += "J";
          }
        } else {
          cList.add(currentIndex, activity);
          output += "C";
        }
      }
      if (count == size) {
        System.out.println(output);
      }
    }
  }

  public static int searchInList(ArrayList<int[]> aList, int[] newActivity) {
    if (aList.size() == 0) {
      return 0;
    }
    for (int counter = 0; counter < aList.size(); counter++) {
      int[] currentActivity = aList.get(counter);
      if (currentActivity[0] >= newActivity[1]) {
        if (counter == 0) {
          return 0;
        }
        int[] previousActivity = aList.get(counter - 1);
        if (previousActivity[1] > newActivity[0]) {
          return -1;
        }
      }
    }
    int[] previousActivity = aList.get(aList.size() - 1);
    if (previousActivity[1] > newActivity[0]) {
      return -1;
    }
    return aList.size();
  }

}