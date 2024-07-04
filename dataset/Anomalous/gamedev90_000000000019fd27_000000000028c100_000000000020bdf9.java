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
        StringBuilder result = new StringBuilder();
        Map<String, Integer> indexForTimeCode = new HashMap<>();
        
        for (int i = 0; i < timeArray.length; i++) {
            String[] time = timeArray[i];
            indexForTimeCode.put(time[0] + "-" + time[1], i);
        }
        
        Arrays.sort(timeArray, Comparator.comparingInt(time -> Integer.parseInt(time[0])));
        
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
                    currPerson = 1 - currPerson;
                }
            }
            
            referenceArray[i] = indexForTimeCode.get(currTime[0] + "-" + currTime[1]);
            result.append(persons[currPerson]);
        }
        
        char[] finalResult = new char[result.length()];
        
        for (int i = 0; i < referenceArray.length; i++) {
            int targetIndex = referenceArray[i];
            finalResult[targetIndex] = result.charAt(i);
        }
        
        return String.copyValueOf(finalResult);
    }
}