import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            boolean[] jamie = new boolean[1441];
            boolean[] cameron = new boolean[1441];
            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            
            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isPossible && isFree(jamie, start, end)) {
                    result.append('J');
                    markTime(jamie, start, end);
                } else if (isPossible && isFree(cameron, start, end)) {
                    result.append('C');
                    markTime(cameron, start, end);
                } else {
                    isPossible = false;
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }
            
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }
    
    private static boolean isFree(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static void markTime(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}