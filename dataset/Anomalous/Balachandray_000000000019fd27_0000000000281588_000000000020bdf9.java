import java.io.*;
import java.util.*;

public class Solution {

    public static void sortByColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(entry -> entry[col]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int c = 0; c < t; c++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            sortByColumn(activities, 0);
            System.out.print("Case #" + (c + 1) + ": ");
            
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();
            int[] cEnd = {-1, -1};
            int[] jEnd = {-1, -1};
            
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    schedule.append("C");
                    cEnd[0] = activities[i][0];
                    cEnd[1] = activities[i][1];
                } else {
                    if (cEnd[1] <= activities[i][0]) {
                        schedule.append("C");
                        cEnd[0] = activities[i][0];
                        cEnd[1] = activities[i][1];
                    } else if (jEnd[1] <= activities[i][0]) {
                        schedule.append("J");
                        jEnd[0] = activities[i][0];
                        jEnd[1] = activities[i][1];
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            
            System.out.println(schedule.toString());
        }
        
        scanner.close();
    }
}