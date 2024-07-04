import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = in.next();
            int n = 0;
            StringBuilder sb = new StringBuilder();
            for (String c : s.split("")) {
                int x = Integer.parseInt(c);
                while (n < x) {
                    n++;
                    sb.append("(");
                }
                while (n > x) {
                    n--;
                    sb.append(")");
                }
                sb.append(x);
            }
            sb.append(")".repeat(n));
            System.out.printf("Case #%d: %s\n", i, sb.toString());
        }
        in.close();
    }
}