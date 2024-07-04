import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();
            int d = 0;
            for (int p = 0; p < s.length(); p++) {
                int n = s.charAt(p) - '0';
                int delta = n - d;
                if (delta == 0) {
                    sb.append(s.charAt(p));
                } else if (delta > 0) {
                    for (int j = 0; j<delta; j++) {
                        sb.append('(');
                    }
                    sb.append(s.charAt(p));
                } else {
                    delta = - delta;
                    for (int j = 0; j<delta; j++) {
                        sb.append(')');
                    }
                    sb.append(s.charAt(p));
                }
                d = n;
            }
            for (int j=0; j<d; j++) {
                sb.append(')');
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}


