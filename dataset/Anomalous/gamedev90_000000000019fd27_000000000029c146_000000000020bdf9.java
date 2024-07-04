import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
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

            String schedule = getSchedule(timeArray, new char[] {'J', 'C'});
            String result = (schedule == null ? "IMPOSSIBLE" : schedule);
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    static String getSchedule(String[][] timeArray, char[] persons) {
        Map<String, List<Integer>> indexForTimeCode = new HashMap<>();
        for (int i = 0; i < timeArray.length; i++) {
            String[] time = timeArray[i];
            String key = time[0] + "-" + time[1];
            indexForTimeCode.putIfAbsent(key, new ArrayList<>());
            indexForTimeCode.get(key).add(i);
        }

        Arrays.sort(timeArray, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        int currPerson = 0;
        char[] result = new char[timeArray.length];
        List<Integer> indexList = indexForTimeCode.get(timeArray[0][0] + "-" + timeArray[0][1]);
        int targetIndex = indexList.remove(0);
        result[targetIndex] = persons[currPerson];

        for (int i = 1; i < timeArray.length; i++) {
            String[] currTime = timeArray[i];
            String[] previousTime = timeArray[i - 1];
            List<Integer> loopIndexList = indexForTimeCode.get(currTime[0] + "-" + currTime[1]);
            int loopTargetIndex = loopIndexList.remove(0);

            if (Integer.parseInt(currTime[0]) < Integer.parseInt(previousTime[1])) {
                if (i != 1 && Integer.parseInt(currTime[0]) < Integer.parseInt(timeArray[i - 2][1])) {
                    return null;
                } else {
                    currPerson = 1 - currPerson;
                }
            }

            result[loopTargetIndex] = persons[currPerson];
        }

        return String.valueOf(result);
    }
}