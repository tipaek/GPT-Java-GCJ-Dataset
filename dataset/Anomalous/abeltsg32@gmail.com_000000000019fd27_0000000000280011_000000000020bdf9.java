import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static String schedule(int[][] intervals, int caseNumber) {
        StringBuilder result = new StringBuilder("Case #" + (caseNumber + 1) + ": ");
        ArrayList<int[]> CList = new ArrayList<>();
        ArrayList<int[]> JList = new ArrayList<>();
        
        if (intervals.length > 0) {
            result.append("C");
            CList.add(intervals[0]);
            
            for (int i = 1; i < intervals.length; i++) {
                if (result.charAt(result.length() - 1) == 'C') {
                    if (isValid(CList, intervals[i])) {
                        result.append('C');
                        CList.add(intervals[i]);
                    } else if (isValid(JList, intervals[i])) {
                        result.append('J');
                        JList.add(intervals[i]);
                    } else {
                        return "Case #" + (caseNumber + 1) + ": IMPOSSIBLE";
                    }
                } else {
                    if (isValid(JList, intervals[i])) {
                        result.append('J');
                        JList.add(intervals[i]);
                    } else if (isValid(CList, intervals[i])) {
                        result.append('C');
                        CList.add(intervals[i]);
                    } else {
                        return "Case #" + (caseNumber + 1) + ": IMPOSSIBLE";
                    }
                }
            }
        }
        return result.toString();
    }

    public static boolean isValid(ArrayList<int[]> list, int[] interval) {
        for (int[] current : list) {
            if ((interval[0] < current[1] && interval[0] >= current[0]) || 
                (interval[1] > current[0] && interval[1] <= current[1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        StringBuilder result = new StringBuilder();
        
        for (int testCaseCounter = 0; testCaseCounter < numTestCases; testCaseCounter++) {
            int size = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            int[][] intervals = new int[size][2];

            for (int i = 0; i < size; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                if (scanner.hasNextLine()) scanner.nextLine();  // Consume the newline character
            }
            
            result.append(schedule(intervals, testCaseCounter)).append("\n");
        }
        
        System.out.print(result.toString());
        scanner.close();
    }
}