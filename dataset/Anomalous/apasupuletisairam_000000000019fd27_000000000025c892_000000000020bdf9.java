import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        for (int i = 1; i <= t; i++) {
            long n = sc.nextLong();
            int[][] intervals = new int[(int) n][2];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    intervals[j][k] = sc.nextInt();
                }
            }
            
            StringBuilder schedule = new StringBuilder("J");
            boolean impossible = false;
            
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
        
        sc.close();
    }
}