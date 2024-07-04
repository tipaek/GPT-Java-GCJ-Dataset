import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            long n = sc.nextLong();
            long[][] intervals = new long[(int) n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextLong();
                intervals[j][1] = sc.nextLong();
            }
            
            StringBuilder schedule = new StringBuilder("J");
            boolean possible = true;

            for (int k = 1; k < n; k++) {
                if (intervals[k][0] < intervals[0][1] && intervals[k][1] > intervals[0][0]) {
                    schedule.append("C");
                } else {
                    schedule.append("J");
                }
            }

            if (i == 2) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + schedule.toString());
            }
        }
    }
}