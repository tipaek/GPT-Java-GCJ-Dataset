import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            StringBuilder result = new StringBuilder();
            int n = scanner.nextInt();
            int cameronEnd = 0, jamieEnd = 0;
            boolean isPossible = true;
            
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }
            
            for (int j = 0; j < n; j++) {
                int start = startTimes[j];
                int end = endTimes[j];
                
                if (start >= cameronEnd) {
                    cameronEnd = end;
                    result.append("C");
                } else if (start >= jamieEnd) {
                    jamieEnd = end;
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}