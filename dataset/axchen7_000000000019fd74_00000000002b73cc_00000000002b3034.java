import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int curT = 1; curT <= t; curT++) {
            System.out.print("Case #" + curT + ": ");
            test:
            {
                int n = scanner.nextInt();
                String[] p = new String[n];
                boolean[] starts = new boolean[n];
                boolean[] ends = new boolean[n];
                for (int i = 0; i < n; i++) p[i] = scanner.next();
                String[][] c = new String[n][];
                String full = "";
                for (int i = 0; i < n; i++) {
                    c[i] = p[i].split("\\*");
                    starts[i] = p[i].charAt(0) != '*';
                    ends[i] = p[i].charAt(p[i].length() - 1) != '*';
                    if (c[i].length == 0) c[i] = new String[]{""};
                    if (c[i].length == 1 && starts[i] && ends[i]) full = c[i][0];
                }

                String maxStart = "";
                String maxEnd = "";
                for (int i = 0; i < n; i++) {
                    if (starts[i] && c[i][0].length() > maxStart.length())
                        maxStart = c[i][0];
                    if (ends[i] && c[i][c[i].length - 1].length() > maxEnd.length())
                        maxEnd = c[i][c[i].length - 1];
                }

                for (int i = 0; i < maxStart.length(); i++) {
                    char cur = maxStart.charAt(i);
                    for (int j = 0; j < n; j++) {
                        if (starts[j] && i < c[j][0].length() && c[j][0].charAt(i) != cur) {
                            System.out.println("*");
                            break test;
                        }
                    }
                }
                for (int i = 0; i < maxEnd.length(); i++) {
                    char cur = maxEnd.charAt(maxEnd.length() - 1 - i);
                    for (int j = 0; j < n; j++) {
                        if (ends[j] && i < c[j][c[j].length - 1].length() && c[j][c[j].length - 1].charAt(c[j][c[j].length - 1].length() - 1 - i) != cur) {
                            System.out.println("*");
                            break test;
                        }
                    }
                }

                StringBuilder out = new StringBuilder();
                out.append(maxStart);
                for (int i = 0; i < n; i++) {
                    int start = 0;
                    int end = c[i].length;
                    if (starts[i]) start++;
                    if (ends[i]) end--;
                    for (int j = start; j < end; j++) {
                        out.append(c[i][j]);
                    }
                }
                out.append(maxEnd);
                System.out.println(out);
            }
        }
    }
}
