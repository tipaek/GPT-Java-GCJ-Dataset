import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            if (scanner.hasNext()) {
                int intervalsCount = scanner.nextInt();
                boolean[] cameronSchedule = new boolean[1441];
                boolean[] jamieSchedule = new boolean[1441];
                boolean isImpossible = false;
                StringBuilder result = new StringBuilder();
                
                for (int j = 0; j < intervalsCount; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt() - 1;
                    
                    if (isAvailable(cameronSchedule, start, end)) {
                        result.append("C");
                        markInterval(cameronSchedule, start, end);
                    } else if (isAvailable(jamieSchedule, start, end)) {
                        result.append("J");
                        markInterval(jamieSchedule, start, end);
                    } else {
                        isImpossible = true;
                    }
                }
                
                if (isImpossible) {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + testCase + ": " + result.toString());
                }
            }
        }
        
        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markInterval(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = true;
        }
    }
}