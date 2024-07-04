import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int offset = t;
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String[][] timeArray = new String[n][2];
      while (n-- > 0) {
        String[] s = br.readLine().split(" ");
        timeArray[n] = s;
      }
      String schedule = getSchedule(timeArray, new char[] {'J', 'C'});
      String result = (schedule == null ? "IMPOSSIBLE" : schedule);
      System.out.println("Case #" + (offset - t) + ": " + result);
    }
  }

  private static String getSchedule(String[][] timeArray, char[] persons) {
    StringBuilder result = new StringBuilder();
    Arrays.sort(
        timeArray,
        new Comparator<String[]>() {
          public int compare(String[] time1, String[] time2) {
            return Integer.parseInt(time1[0]) - Integer.parseInt(time2[0]);
          }
        });
    int currPerson = 0;
    result.append(persons[currPerson]);
    for (int i = 1; i < timeArray.length; i++) {
      String[] currTime = timeArray[i];
      String[] previousTime = timeArray[i - 1];
      if (Integer.parseInt(currTime[0]) < Integer.parseInt(previousTime[1])) {
        if (i != 1 && Integer.parseInt(currTime[0]) < Integer.parseInt(timeArray[i - 2][1])) {
          return null;
        } else {
          currPerson = currPerson == 0 ? 1 : 0;
        }
      }
      result.append(persons[currPerson]);
    }
    return result.toString();
  }
}
