import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            processCase(t, n, startTimes, endTimes);
        }
    }

    private static void processCase(int caseNumber, int n, int[] startTimes, int[] endTimes) {
        int[] cSchedule = new int[1441];
        int[] jSchedule = new int[1441];
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int start = startTimes[i];
            int end = endTimes[i];
            
            boolean cConflict = false;
            boolean jConflict = false;
            
            for (int k = start + 1; k <= end; k++) {
                if (cSchedule[k] != 0) {
                    cConflict = true;
                }
                if (jSchedule[k] != 0) {
                    jConflict = true;
                }
            }
            
            if (cConflict && jConflict) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            } else {
                if (!cConflict) {
                    for (int k = start; k <= end; k++) {
                        cSchedule[k] = 1;
                    }
                    result.append("C");
                } else {
                    for (int k = start; k <= end; k++) {
                        jSchedule[k] = 1;
                    }
                    result.append("J");
                }
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}