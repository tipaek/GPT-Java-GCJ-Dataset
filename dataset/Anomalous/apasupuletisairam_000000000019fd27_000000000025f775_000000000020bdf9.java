import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            long[][] intervals = new long[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextLong();
                intervals[j][1] = sc.nextLong();
            }
            
            StringBuilder schedule = new StringBuilder("J");
            
            outerLoop:
            for (int k = 1; k < n; k++) {
                for (int l = 0; l < k; l++) {
                    if (intervals[k][0] < intervals[l][1] && intervals[k][1] > intervals[l][0]) {
                        schedule.append("C");
                        continue outerLoop;
                    }
                }
                schedule.append("J");
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