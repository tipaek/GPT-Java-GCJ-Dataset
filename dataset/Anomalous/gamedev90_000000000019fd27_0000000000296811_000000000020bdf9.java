import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int initialCases = t;
        
        for (int caseNum = 1; caseNum <= initialCases; caseNum++) {
            int n = Integer.parseInt(br.readLine());
            String[][] timeArray = new String[n][2];
            
            for (int i = 0; i < n; i++) {
                timeArray[i] = br.readLine().split(" ");
            }
            
            String schedule = getSchedule(timeArray, new char[] {'J', 'C'});
            String result = (schedule == null ? "IMPOSSIBLE" : schedule);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    static String getSchedule(String[][] timeArray, char[] persons) {
        StringBuilder result = new StringBuilder();
        Map<String, List<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < timeArray.length; i++) {
            String key = timeArray[i][0] + "-" + timeArray[i][1];
            indexMap.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }
        
        Arrays.sort(timeArray, Comparator.comparingInt(a -> Integer.parseInt(a[0])));
        
        int currPerson = 0;
        result.append(persons[currPerson]);
        int[] originalIndices = new int[timeArray.length];
        originalIndices[0] = indexMap.get(timeArray[0][0] + "-" + timeArray[0][1]).remove(0);
        
        for (int i = 1; i < timeArray.length; i++) {
            String[] currTime = timeArray[i];
            String[] prevTime = timeArray[i - 1];
            
            if (Integer.parseInt(currTime[0]) < Integer.parseInt(prevTime[1])) {
                if (i != 1 && Integer.parseInt(currTime[0]) < Integer.parseInt(timeArray[i - 2][1])) {
                    return null;
                } else {
                    currPerson = 1 - currPerson;
                }
            }
            
            originalIndices[i] = indexMap.get(currTime[0] + "-" + currTime[1]).remove(0);
            result.append(persons[currPerson]);
        }
        
        char[] finalResult = new char[result.length()];
        for (int i = 0; i < originalIndices.length; i++) {
            finalResult[originalIndices[i]] = result.charAt(i);
        }
        
        return new String(finalResult);
    }
}