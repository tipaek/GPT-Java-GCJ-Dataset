import java.util.Scanner;

public class Solution {

    private static final String BREAK = System.getProperty("line.separator");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();

            if (n == 1) {
                sb.append("1 1");
            } else if (n == 2) {
                sb.append("1 1").append(BREAK).append("2 1");
            } else if (n == 3) {
                sb.append("1 1").append(BREAK).append("2 1").append(BREAK).append("2 2");
            } else if (n == 4) {
                sb.append("1 1").append(BREAK).append("2 1").append(BREAK).append("3 2");
            } else {
                int sum = 4;
                int r = 3;
                int c = 2;
                sb.append("1 1").append(BREAK).append("2 1").append(BREAK).append("3 2");
                while (n - sum >= r) {
                    sum += r;
                    r++;
                    sb.append(BREAK).append(r).append(" ").append(c);
                }
                if (sum < n) {
                    c--;
                    sum++;
                    sb.append(BREAK).append(r).append(" ").append(c);
                }
                while (sum < n) {
                    r++;
                    sum++;
                    sb.append(BREAK).append(r).append(" ").append(c);
                }
            }


            System.out.println("Case #" + tt + ":");
            System.out.println(sb.toString());
        }
    }
}
