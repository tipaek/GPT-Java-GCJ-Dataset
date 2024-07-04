import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
            
            int endC = 0, endJ = 0;
            boolean impossible = false;
            
            for (int i = 0; i < n; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                
                if (start >= endC) {
                    endC = end;
                    result.append('C');
                } else if (start >= endJ) {
                    endJ = end;
                    result.append('J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}