import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[][] timeArray = new String[n][2];

            for (int i = 0; i < n; i++) {
                timeArray[i] = br.readLine().split(" ");
            }

            String schedule = getSchedule(timeArray, new char[]{'C', 'J'});
            String result = (schedule == null ? "IMPOSSIBLE" : schedule);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    static String getSchedule(String[][] timeArray, char[] persons) {
        Map<String, List<Integer>> indexForTimeCode = new HashMap<>();
        for (int i = 0; i < timeArray.length; i++) {
            String key = timeArray[i][0] + "-" + timeArray[i][1];
            indexForTimeCode.putIfAbsent(key, new ArrayList<>());
            indexForTimeCode.get(key).add(i);
        }

        Arrays.sort(timeArray, Comparator.comparingInt(time -> Integer.parseInt(time[0])));

        char[] result = new char[timeArray.length];
        int currPerson = 0;

        for (int i = 0; i < timeArray.length; i++) {
            String key = timeArray[i][0] + "-" + timeArray[i][1];
            List<Integer> indexList = indexForTimeCode.get(key);
            int targetIndex = indexList.remove(0);

            if (i > 0 && Integer.parseInt(timeArray[i][0]) < Integer.parseInt(timeArray[i - 1][1])) {
                if (i > 1 && Integer.parseInt(timeArray[i][0]) < Integer.parseInt(timeArray[i - 2][1])) {
                    return null;
                } else {
                    currPerson = 1 - currPerson;
                }
            }

            result[targetIndex] = persons[currPerson];
        }

        return new String(result);
    }
}