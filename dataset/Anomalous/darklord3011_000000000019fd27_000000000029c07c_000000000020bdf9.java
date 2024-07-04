import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = activities[i][0];
                endTimes[i] = activities[i][1];
            }
            
            int count = 0;
            int i = 0;
            int j = 0;
            StringBuilder answer = new StringBuilder();
            
            while (i < n && j < n) {
                if (startTimes[i] < endTimes[j]) {
                    count++;
                    i++;
                } else {
                    count--;
                    j++;
                }
                
                if (count == 1 && answer.length() < n) {
                    answer.append("C");
                } else if (count == 2 && answer.length() < n) {
                    answer.append("J");
                }
            }
            
            if (count > 2) {
                answer = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + t + ": " + answer.toString());
        }
        
        scanner.close();
    }
}