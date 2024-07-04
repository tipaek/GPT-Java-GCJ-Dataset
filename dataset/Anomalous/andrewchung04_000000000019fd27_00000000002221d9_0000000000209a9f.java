import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            int n = str.length();
            int[] front = new int[n + 1];
            int[] back = new int[n + 1];
            boolean[] blocked = new boolean[n + 1];
            blocked[n] = true;
            int curApplied = 0;

            for (int j = 0; j < 10; j++) {
                boolean factor = false;
                for (int k = 0; k < n; k++) {
                    if (str.charAt(k) == (char) (j + '0')) {
                        factor = true;
                        break;
                    }
                }

                if (factor) {
                    boolean left = true;
                    for (int k = 0; k <= n; k++) {
                        if (!blocked[k] && left) {
                            left = false;
                            front[k] += j - curApplied;
                        } else if (blocked[k] && !left) {
                            left = true;
                            back[k] += j - curApplied;
                        }
                    }
                    curApplied = j;
                }

                for (int k = 0; k < n; k++) {
                    if (str.charAt(k) == (char) (j + '0')) {
                        blocked[k] = true;
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < front[j]; k++) {
                    ans.append("(");
                }
                for (int k = 0; k < back[j]; k++) {
                    ans.append(")");
                }
                ans.append(str.charAt(j));
            }

            for (int j = 0; j < back[n]; j++) {
                ans.append(")");
            }

            System.out.println("Case #" + (i + 1) + ": " + ans.toString());
        }
    }
}