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
                boolean have = false;
                boolean left = true;
                for (int i = 20; i >= 0; i--) {
                    int lineSum = (int) Math.pow(2, i);
                    if (lineSum + i - 1 <= n) {
                        if (lineSum + i <= n) {
                            addFullLine(sb, i + 1, left);
                            n -= lineSum;
                        } else {
                            addPlLine(sb, i + 1, left);
                            n -= lineSum;
                            n++;
                        }
                        have = true;
                        left = !left;
                    } else if (have) {
                        if (left) {
                            sb.append(BREAK).append((i + 1)).append(" ").append(1);
                        } else {
                            sb.append(BREAK).append((i + 1)).append(" ").append((i + 1));
                        }
                        n -= 1;
                    }
                }
            }


            System.out.println("Case #" + tt + ":");
            System.out.println(sb.toString());
        }
    }

    private static void addFullLine(StringBuilder sb, int k, boolean left) {
        if (left) {
            for (int i = 1; i <= k; i++) {
                sb.append(BREAK).append(k).append(" ").append(i);
            }
        } else {
            for (int i = k; i >= 1; i--) {
                sb.append(BREAK).append(k).append(" ").append(i);
            }
        }
    }

    private static void addPlLine(StringBuilder sb, int k, boolean left) {
        if (left) {
            for (int i = 1; i < k; i++) {
                sb.append(BREAK).append(k).append(" ").append(i);
            }
        } else {
            for (int i = k; i >= 2; i--) {
                sb.append(BREAK).append(k).append(" ").append(i);
            }
        }

    }
}
