import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; i++) {
      int size = in.nextInt();
      String output = "Case #" + i + ": ";

      ArrayList<int[]> activityList = new ArrayList<>();

      boolean possible = true;
      ArrayList<String> activityEntryList = new ArrayList<>();
      for (int count = 0; count < size; count++) {
        int[] activity = new int[2];
        activity[0] = in.nextInt();
        activity[1] = in.nextInt();
        if (possible) {
          activityEntryList.add("");
          possible = addInList(activityList, activity, count);
          if (!possible) {
            System.out.println("Case #" + i + ": IMPOSSIBLE");
          }
        }
      }
      if (possible) {
        int busy = -1;
        for (int count = 0; count < activityList.size(); count++) {
          int[] activities = activityList.get(count);
          if (activities[1] != -1) {
            if (busy == -1) {
              activityEntryList.set(activities[1], "C");
              busy = activities[1];
            } else {
              activityEntryList.set(activities[1], "J");
            }
          } else if(busy != -1 && activities[2] == busy){
            busy = -1;
          }
        }
        for (int count = 0; count < activityEntryList.size(); count++) {
          output += activityEntryList.get(count);
        }
        System.out.println(output);
      }
    }
  }

  public static boolean addInList(ArrayList<int[]> aList, int[] newActivity, int entryCount) {
    int counter;
    for (counter = 0; counter < aList.size() && aList.get(counter)[0] <= newActivity[0]; counter++)
      ;
    if (counter == aList.size()) {
      int[] startInfo = { newActivity[0], entryCount, -1, 1 };
      aList.add(startInfo);
      int[] endInfo = { newActivity[1], -1, entryCount, 0 };
      aList.add(endInfo);
    } else {
      int newTotal = aList.get(counter)[3];
      if(aList.get(counter)[2] != -1){
        newTotal+=2;
      }
      if (newTotal > 2) {
        return false;
      }
      int[] startInfo = { newActivity[0], entryCount, -1, newTotal };
      aList.add(counter, startInfo);
      int counter2;
      for (counter2 = counter+1; counter2 < aList.size() && aList.get(counter2)[0] < newActivity[1]; counter2++) {
        newTotal = aList.get(counter2)[3]+1;

        if (newTotal > 2) {
          return false;
        }
        int[] updateInfo = { aList.get(counter2)[0], aList.get(counter2)[1], aList.get(counter2)[2], newTotal };
        aList.set(counter2, updateInfo);
      }
      if (counter2 == aList.size()) {
        int[] endInfo = { newActivity[1], -1, entryCount, 0 };
        aList.add(endInfo);
      } else {
        int[] endInfo = { newActivity[1], -1, entryCount, newTotal - 1 };
        aList.add(counter2, endInfo);
      }
    }
    return true;
  }
}