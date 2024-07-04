import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] jamie = new int[n][2];
            int[][] cameron = new int[n][2];
            int jIndex = 0, cIndex = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (possible) {
                    if (isAvailable(jamie, start, end, jIndex)) {
                        schedule.append("J");
                        jamie[jIndex][0] = start;
                        jamie[jIndex++][1] = end;
                    } else if (isAvailable(cameron, start, end, cIndex)) {
                        schedule.append("C");
                        cameron[cIndex][0] = start;
                        cameron[cIndex++][1] = end;
                    } else {
                        schedule.setLength(0);
                        schedule.append("IMPOSSIBLE");
                        possible = false;
                    }
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + schedule.toString());
        }
        
        scanner.close();
    }

    private static boolean isAvailable(int[][] schedule, int start, int end, int count) {
        for (int i = 0; i < count; i++) {
            if ((start < schedule[i][1] && end > schedule[i][0])) {
                return false;
            }
        }
        return true;
    }
}