import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int activities = scanner.nextInt();
            List<int[]> intervals = new ArrayList<>();
            for (int j = 0; j < activities; j++) {
                int[] interval = new int[2];
                interval[0] = scanner.nextInt();
                interval[1] = scanner.nextInt();
                intervals.add(interval);
            }
            String[] resultArray = makeString(intervals);
            String result = "";
            for (String s : resultArray) {
                if (s == null) {
                    result = "IMPOSSIBLE";
                    break;
                } else {
                    result += s;
                }
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    public static String[] makeString(List<int[]> intervals) {
        boolean cAvail, jAvail;
        int cEnd = 0;
        int jEnd = 0;
        String[] result = new String[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            int minIndex = findNext(intervals);
            int[] interval = intervals.get(minIndex);
            if (interval[0] < cEnd) {
                cAvail = false;
            } else {
                cAvail = true;
            }
            if (interval[0] < jEnd) {
                jAvail = false;
            } else {
                jAvail = true;
            }
            if (cAvail) {
                result[minIndex] = "C";
                cEnd = interval[1];
                intervals.get(minIndex)[0] = Integer.MAX_VALUE;
            } else if (jAvail) {
                result[minIndex] = "J";
                jEnd = interval[1];
                interval[0] = Integer.MAX_VALUE;
            }
        }
        return result;
    }
    
    public static int findNext(List<int[]> intervals) {
        int min = 1441; 
        int index = 0;
        for (int i = 0; i < intervals.size(); i++) {
            int start = intervals.get(i)[0];
            if (start < min) {
                min = start;
                index = i;
            }
        }
        return index;
    }
} 