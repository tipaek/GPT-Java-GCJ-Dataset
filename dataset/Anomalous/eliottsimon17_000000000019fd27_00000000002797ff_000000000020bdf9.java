import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int activityCount = scanner.nextInt();
            scanner.nextLine();
            
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];
            int[] indices = new int[activityCount];
            
            for (int i = 0; i < activityCount; ++i) {
                indices[i] = i;
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            // Sort activities by start time using bubble sort
            for (int i = 0; i < activityCount; ++i) {
                for (int j = i + 1; j < activityCount; ++j) {
                    if (startTimes[i] > startTimes[j]) {
                        swap(startTimes, i, j);
                        swap(endTimes, i, j);
                        swap(indices, i, j);
                    }
                }
            }
            
            StringBuilder schedule = new StringBuilder("");
            boolean impossible = false;
            int cFreeTime = 0;
            int jFreeTime = 0;
            
            for (int i = 0; i < activityCount; ++i) {
                if (startTimes[i] < cFreeTime && startTimes[i] < jFreeTime) {
                    impossible = true;
                    break;
                }
                if (startTimes[i] >= cFreeTime) {
                    schedule.append('C');
                    cFreeTime = endTimes[i];
                } else {
                    schedule.append('J');
                    jFreeTime = endTimes[i];
                }
            }
            
            if (!impossible) {
                char[] result = new char[activityCount];
                for (int i = 0; i < activityCount; ++i) {
                    result[indices[i]] = schedule.charAt(i);
                }
                System.out.println("Case #" + caseNum + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}