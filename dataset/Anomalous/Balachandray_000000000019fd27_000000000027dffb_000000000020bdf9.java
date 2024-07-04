import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            System.out.print("Case #" + caseNumber + ": ");
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();
            int[] cLastActivity = new int[2];
            int[] jLastActivity = new int[2];
            
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    schedule.append("C");
                    cLastActivity[0] = activities[i][0];
                    cLastActivity[1] = activities[i][1];
                } else {
                    if (cLastActivity[1] <= activities[i][0]) {
                        schedule.append("C");
                        cLastActivity[0] = activities[i][0];
                        cLastActivity[1] = activities[i][1];
                    } else if (jLastActivity[1] <= activities[i][0]) {
                        schedule.append("J");
                        jLastActivity[0] = activities[i][0];
                        jLastActivity[1] = activities[i][1];
                    } else {
                        if (cLastActivity[0] >= activities[i][0] && cLastActivity[1] >= activities[i][1]) {
                            schedule.append("C");
                        } else if (jLastActivity[0] >= activities[i][0] && jLastActivity[1] >= activities[i][1]) {
                            schedule.append("J");
                        } else {
                            schedule = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }
            System.out.println(schedule);
        }
    }
}