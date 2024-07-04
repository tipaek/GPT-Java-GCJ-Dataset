import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int tIndex = 1; tIndex <= t; tIndex++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String output = "IMPOSSIBLE";
            
            if (n == 2) {
                if (k == 2 || k == 4) {
                    output = "POSSIBLE";
                }
            } else {
                int sum = n * (n + 1) / 2;
                if (sum == k) {
                    output = "POSSIBLE";
                } else {
                    for (int x = 1; x <= n; x++) {
                        if (x * n == k) {
                            output = "POSSIBLE";
                            break;
                        }
                    }
                    if (!output.equals("POSSIBLE") && n != 3) {
                        for (int x = 1; x <= n; x++) {
                            for (int y = 1; y <= n; y++) {
                                if (y != x) {
                                    int temp = (n - 2) * x + 2 * y;
                                    if (temp == k) {
                                        output = "POSSIBLE";
                                        break;
                                    }
                                }
                            }
                            if (output.equals("POSSIBLE")) {
                                break;
                            }
                        }
                    }
                }
            }
            result.append("Case #").append(tIndex).append(": ").append(output).append("\n");
        }
        System.out.print(result.toString());
    }
}