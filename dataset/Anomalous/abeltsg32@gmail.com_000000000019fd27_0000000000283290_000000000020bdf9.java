import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    
    public static String schedule(int[][] intervals, int caseNumber) {
        StringBuilder result = new StringBuilder();
        ArrayList<int[]> cList = new ArrayList<>();
        ArrayList<int[]> jList = new ArrayList<>();
        
        if (intervals.length > 0) {
            result.append("C");
            cList.add(new int[] { intervals[0][0], intervals[0][1] });
            
            for (int index = 1; index < intervals.length; index++) {
                char lastAssigned = result.charAt(result.length() - 1);
                
                if (lastAssigned == 'C') {
                    if (isValid(cList, intervals[index])) {
                        result.append('C');
                        cList.add(intervals[index]);
                    } else if (isValid(jList, intervals[index])) {
                        result.append('J');
                        jList.add(intervals[index]);
                    } else {
                        return String.format("Case #%d: IMPOSSIBLE", caseNumber + 1);
                    }
                } else if (lastAssigned == 'J') {
                    if (isValid(jList, intervals[index])) {
                        result.append('J');
                        jList.add(intervals[index]);
                    } else if (isValid(cList, intervals[index])) {
                        result.append('C');
                        cList.add(intervals[index]);
                    } else {
                        return String.format("Case #%d: IMPOSSIBLE", caseNumber + 1);
                    }
                }
            }
        }
        
        return String.format("Case #%d: %s", caseNumber + 1, result.toString());
    }
    
    public static boolean isValid(ArrayList<int[]> list, int[] interval) {
        for (int[] timeSlot : list) {
            if ((interval[0] >= timeSlot[0] && interval[0] < timeSlot[1]) || 
                (interval[1] > timeSlot[0] && interval[1] <= timeSlot[1]) || 
                (interval[0] == timeSlot[0] && interval[1] <= timeSlot[1])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int testCaseCounter = 0; testCaseCounter < numTestCases; testCaseCounter++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            int[][] intervals = new int[size][2];
            
            for (int i = 0; i < size; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }
            
            result.append(schedule(intervals, testCaseCounter)).append("\n");
        }
        
        System.out.print(result.toString());
    }
}