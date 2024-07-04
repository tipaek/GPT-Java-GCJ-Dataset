import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T;t++) {
            String s = sc.next();

            StringBuilder sb = new StringBuilder();
            int open = 0;

            for (int i = 0; i < s.length();i++) {
                int d = s.charAt(i) - '0';
                if (open > d) {
                    while (open != d) {
                        sb.append(')');
                        open--;
                    }
                } else if (open < d) {
                    while (open != d) {
                        sb.append('(');
                        open++;
                    }
                }
                sb.append(d);
            }

            while (open > 0) {
                sb.append(')');
                open--;
            }

            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
