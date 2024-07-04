import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean[] cSchedule = new boolean[1441];
            boolean[] jSchedule = new boolean[1441];
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            boolean isPossible = true;
            
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                boolean canC = true;
                boolean canJ = true;
                
                for (int k = start; k < end; k++) {
                    if (cSchedule[k]) {
                        canC = false;
                        break;
                    }
                }
                
                if (canC) {
                    for (int k = start; k < end; k++) {
                        cSchedule[k] = true;
                    }
                    result.append("C");
                } else {
                    for (int k = start; k < end; k++) {
                        if (jSchedule[k]) {
                            canJ = false;
                            break;
                        }
                    }
                    if (canJ) {
                        for (int k = start; k < end; k++) {
                            jSchedule[k] = true;
                        }
                        result.append("J");
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + testCase + ": " + result);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}