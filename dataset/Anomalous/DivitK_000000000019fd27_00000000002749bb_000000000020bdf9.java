import java.util.Scanner;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int[][] intervals = new int[t][2];
            
            for (int j = 0; j < t; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder("C");
            boolean impossible = false;
            
            for (int k = 1; k < t; k++) {
                if (intervals[k][0] >= intervals[k - 1][0] && intervals[k][0] <= intervals[k - 1][1]) {
                    schedule.append('J');
                } else {
                    schedule.append('C');
                }
            }
            
            for (int m = 1; m < t; m++) {
                if (schedule.charAt(m) == 'J' && schedule.charAt(m - 1) == 'J') {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(schedule.toString());
            }
        }
        
        scanner.close();
    }
}