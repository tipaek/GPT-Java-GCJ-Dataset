import java.util.*;

public class Solution {
    private static Scanner sc;
    private static int testCaseNumber = 1;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        
        while (testCases-- > 0) {
            solve();
        }
    }
    
    private static void solve() {
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        int[][] sortedIntervals = new int[n][2];
        char[] assignments = new char[n];
        Stack<int[]> jStack = new Stack<>();
        Stack<int[]> cStack = new Stack<>();
        boolean isImpossible = false;
        
        Map<int[], Integer> intervalIndexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
            sortedIntervals[i] = intervals[i];
            intervalIndexMap.put(intervals[i], i);
        }
        
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));
        
        char currentPerson = 'J';
        for (int i = 0; i < n; i++) {
            assignments[intervalIndexMap.get(sortedIntervals[i])] = currentPerson;
            
            if (i < n - 1 && doesOverlap(sortedIntervals[i], sortedIntervals[i + 1])) {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    
                    if (!cStack.isEmpty() && doesOverlap(cStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                } else {
                    cStack.push(sortedIntervals[i]);
                    currentPerson = switchPerson(currentPerson);
                    
                    if (!jStack.isEmpty() && doesOverlap(jStack.peek(), sortedIntervals[i + 1])) {
                        isImpossible = true;
                        break;
                    }
                }
            } else {
                if (currentPerson == 'J') {
                    jStack.push(sortedIntervals[i]);
                } else {
                    cStack.push(sortedIntervals[i]);
                }
            }
        } 
        
        System.out.println("Case #" + (testCaseNumber++) + ": " + (isImpossible ? "IMPOSSIBLE" : new String(assignments)));
    }
    
    private static char switchPerson(char person) {
        return person == 'J' ? 'C' : 'J';
    }
    
    private static boolean doesOverlap(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }
}