import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int[][] times = new int[n][2];
            int[][] sortedTimes = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                times[i][0] = scan.nextInt();
                times[i][1] = scan.nextInt();
                sortedTimes[i][0] = times[i][0];
                sortedTimes[i][1] = times[i][1];
            }
            
            // Sort the intervals by starting time
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (sortedTimes[j][0] > sortedTimes[j + 1][0]) {
                        int[] temp = sortedTimes[j];
                        sortedTimes[j] = sortedTimes[j + 1];
                        sortedTimes[j + 1] = temp;
                    }
                }
            }
            
            boolean possible = true;
            for (int i = 0; i < n - 1; i++) {
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (sortedTimes[i][0] < sortedTimes[j][0] && sortedTimes[i][1] > sortedTimes[j][1]) {
                        count++;
                    }
                    if (count == 2) {
                        possible = false;
                        break;
                    }
                }
                if (!possible) break;
            }
            
            if (!possible) {
                System.out.println("Case #" + tn + ": IMPOSSIBLE");
            } else {
                StringBuilder output = new StringBuilder("C");
                for (int i = 1; i < n; i++) {
                    if (times[i - 1][1] <= times[i][0]) {
                        output.append(output.charAt(output.length() - 1));
                    } else {
                        output.append(output.charAt(output.length() - 1) == 'C' ? 'J' : 'C');
                    }
                }
                System.out.println("Case #" + tn + ": " + output);
            }
        }
        
        scan.close();
    }
}