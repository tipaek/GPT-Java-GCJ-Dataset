import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            StringBuilder result = new StringBuilder("Case #" + testCase + ": ");
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();
            int[] C = new int[2];
            int[] J = new int[2];
            
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    schedule.append("C");
                    C[0] = activities[i][0];
                    C[1] = activities[i][1];
                } else {
                    if (C[1] <= activities[i][0]) {
                        schedule.append("C");
                        C[0] = activities[i][0];
                        C[1] = activities[i][1];
                    } else if (J[1] <= activities[i][0]) {
                        schedule.append("J");
                        J[0] = activities[i][0];
                        J[1] = activities[i][1];
                    } else {
                        if (C[0] >= activities[i][0] && C[0] >= activities[i][1]) {
                            schedule.append("C");
                        } else if (J[0] >= activities[i][0] && J[0] >= activities[i][1]) {
                            schedule.append("J");
                        } else {
                            schedule = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }
            result.append(schedule);
            System.out.println(result);
        }
    }
}