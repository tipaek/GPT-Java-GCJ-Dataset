import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static String schedule(int[][] intervals, int caseNumber) {
        StringBuilder result = new StringBuilder();
        ArrayList<int[]> cList = new ArrayList<>();
        ArrayList<int[]> jList = new ArrayList<>();
        
        for (int[] interval : intervals) {
            if (isValid(cList, interval)) {
                result.append('C');
                cList.add(interval);
            } else if (isValid(jList, interval)) {
                result.append('J');
                jList.add(interval);
            } else {
                return String.format("Case #%d: IMPOSSIBLE", caseNumber + 1);
            }
        }
        
        return String.format("Case #%d: %s", caseNumber + 1, result.toString());
    }

    // Checks if the interval can be added to the list without conflicts
    public static boolean isValid(ArrayList<int[]> list, int[] interval) {
        for (int[] current : list) {
            if ((interval[0] < current[1] && interval[1] > current[0])) {
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
            int[][] intervals = new int[size][2];
            
            for (int i = 0; i < size; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            result.append(schedule(intervals, testCaseCounter)).append("\n");
        }
        
        System.out.print(result.toString());
        scanner.close();
    }
}