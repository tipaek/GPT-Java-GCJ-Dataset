import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            Map<int[], Integer> indexMap = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                indexMap.put(intervals[i], i);
            }
            
            int[][] sortedIntervals = intervals.clone();
            Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));
            
            char[] result = new char[n];
            Stack<int[]> jamieStack = new Stack<>();
            Stack<int[]> cameronStack = new Stack<>();
            boolean isImpossible = false;
            char currentPerson = 'J';
            
            for (int i = 0; i < sortedIntervals.length; i++) {
                result[indexMap.get(sortedIntervals[i])] = currentPerson;
                
                if (i < sortedIntervals.length - 1 && intervalsOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                    if (currentPerson == 'J') {
                        jamieStack.push(sortedIntervals[i]);
                        currentPerson = switchPerson(currentPerson);
                        
                        if (!cameronStack.isEmpty() && intervalsOverlap(cameronStack.peek(), sortedIntervals[i + 1])) {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        cameronStack.push(sortedIntervals[i]);
                        currentPerson = switchPerson(currentPerson);
                        
                        if (!jamieStack.isEmpty() && intervalsOverlap(jamieStack.peek(), sortedIntervals[i + 1])) {
                            isImpossible = true;
                            break;
                        }
                    }
                } else {
                    if (currentPerson == 'J') {
                        jamieStack.push(sortedIntervals[i]);
                    } else {
                        cameronStack.push(sortedIntervals[i]);
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + (isImpossible ? "IMPOSSIBLE" : new String(result)));
        }
    }

    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}