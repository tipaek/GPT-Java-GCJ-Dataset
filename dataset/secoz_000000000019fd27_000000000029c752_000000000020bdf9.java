import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numOfCases = in.nextInt();
    for (int i = 1; i <= numOfCases; i++) {

      Map<Integer, Integer> cameronMap = new HashMap<>();
      Map<Integer, Integer> jamieMap = new HashMap<>();

      StringBuilder sb = new StringBuilder();
      int numberOfActivities = in.nextInt();
      String result = "";

      for (int c = 0; c < numberOfActivities; c++) {
        int start = in.nextInt();
        int end = in.nextInt();
        if (checkAvailability(cameronMap, start, end)) {
          sb.append("C");
        } else if (checkAvailability(jamieMap, start, end)) {
          sb.append("J");
        } else {
          result = "IMPOSSIBLE";
        }
      }
      result = result.equals("IMPOSSIBLE") ? result : sb.toString();

      System.out.println("Case #" + i + ": " + result);
    }
  }

  private static boolean checkAvailability(Map<Integer, Integer> map, int start, int end) {
    if (map.isEmpty()) {
      map.put(start, end);
      return true;
    }

    for (Integer s : map.keySet()) {
      if (s > start && s >= end) {
        map.put(start, end);
        return true;
      } else if (s < start && map.get(s) <= start) {
        map.put(start, end);
        return true;
      }
    }

    return false;
  }
}
