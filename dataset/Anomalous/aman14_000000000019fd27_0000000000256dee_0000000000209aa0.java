import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String result = "IMPOSSIBLE";
            boolean found = false;

            if (n != 2) {
                int sum = n * (n + 1) / 2;

                if (sum == k) {
                    result = "POSSIBLE";
                    found = true;
                }

                if (!found) {
                    for (int x = 1; x <= n; x++) {
                        if (x * n == k) {
                            result = "POSSIBLE";
                            found = true;
                            break;
                        }
                    }
                }

                if (!found && n != 3) {
                    for (int x = 1; x <= n; x++) {
                        for (int y = 1; y <= n; y++) {
                            if (y == x) continue;
                            int temp = (n - 2) * x + 2 * y;
                            if (temp == k) {
                                result = "POSSIBLE";
                                found = true;
                                break;
                            }
                        }
                        if (found) break;
                    }
                }
            } else {
                if (k == 4 || k == 2) {
                    result = "POSSIBLE";
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        sc.close();
    }
}