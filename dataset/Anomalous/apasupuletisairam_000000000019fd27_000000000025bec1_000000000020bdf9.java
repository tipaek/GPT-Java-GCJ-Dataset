import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }
            
            StringBuilder schedule = new StringBuilder("J");
            
            outerLoop:
            for (int k = 1; k < n; k++) {
                for (int l = 0; l < 2; l++) {
                    if (intervals[k][0] < intervals[0][1] && intervals[k][1] > intervals[0][0]) {
                        schedule.append("C");
                        continue outerLoop;
                    } else {
                        schedule.append("J");
                        continue outerLoop;
                    }
                }
            }
            
            if (i == 2) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
        
        sc.close();
    }
}