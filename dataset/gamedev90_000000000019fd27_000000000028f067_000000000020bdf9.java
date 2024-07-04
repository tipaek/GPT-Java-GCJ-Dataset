import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int offset = t;
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int offset1 = n - 1;
      String[][] timeArray = new String[n][2];
      while (n-- > 0) {
        String[] s = br.readLine().split(" ");
        timeArray[offset1 - n] = s;
      }
      String schedule = getSchedule(timeArray, new char[] {'J', 'C'});
      String result = (schedule == null ? "IMPOSSIBLE" : schedule);
      System.out.println("Case #" + (offset - t) + ": " + result);
    }
  }

  static String getSchedule(String[][] timeArray, char[] persons) {
    StringBuilder result = new StringBuilder();
    Map<String, Integer> indexForTimeCode = new HashMap<>();
    for (int i = 0; i < timeArray.length; i++) {
        String[] time = timeArray[i];
        indexForTimeCode.put(time[0] + "-" + time[1], i);
    }
    Arrays.sort(
        timeArray,
        new Comparator<String[]>() {
          public int compare(String[] time1, String[] time2) {
            return Integer.parseInt(time1[0]) - Integer.parseInt(time2[0]);
          }
        });
    int currPerson = 0;
    result.append(persons[currPerson]);
    int[] referenceArray = new int[timeArray.length];
    referenceArray[0] = indexForTimeCode.get(timeArray[0][0] + "-" + timeArray[0][1]);
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
      referenceArray[i] = indexForTimeCode.get(currTime[0] + "-" + currTime[1]);
      result.append(persons[currPerson]);
    }
//    StringBuilder finalResult = new StringBuilder(result);
    char[] finalResult = new char[result.length()];
    for (int i = 0; i < referenceArray.length; i++) {
        int targetIndex = referenceArray[i];
        finalResult[targetIndex] = result.charAt(i);
//        finalResult.insert(targetIndex, result.charAt(i));
    }
//    finalResult.delete(result.length(), finalResult.length());
//    String
    return String.copyValueOf(finalResult);
//    return finalResult.toString();
  }
}
