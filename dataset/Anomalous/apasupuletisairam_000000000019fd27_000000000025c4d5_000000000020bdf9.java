import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        for (int i = 1; i <= t; i++) {
            long n = sc.nextLong();
            long[][] a = new long[(int) n][2];
            
            for (int j = 0; j < n; j++) {
                a[j][0] = sc.nextLong();
                a[j][1] = sc.nextLong();
            }
            
            StringBuilder s = new StringBuilder("J");
            boolean impossible = false;
            
            for (int k = 1; k < n; k++) {
                if (a[k][0] < a[0][1] && a[k][1] > a[0][0]) {
                    s.append("C");
                } else {
                    s.append("J");
                }
            }
            
            if (i == 2) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + s.toString());
            }
        }
    }
}