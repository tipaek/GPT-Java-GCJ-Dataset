import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            String line = sc.next();
            int last = 0;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < line.length(); ++i) {
                int n = line.charAt(i) - '0';
                if (n == 0) {
                    if (last == 0) {
                        result.append(n);
                    } else {
                        result.append(repeat(")", last)).append(n);
                        last = 0;
                    }
                } else {
                    if (last == 0) {
                        result.append(repeat("(", n)).append(n);
                    } else {
                        if (last < n) {
                            result.append(repeat("(", n - last)).append(n);
                        } else if (last == n) {
                            result.append(n);
                        } else {
                            result.append(repeat(")", last - n)).append(n);
                        }
                    }
                    last = n;
                }
            }
            if (last != 0) {
                result.append(repeat(")", last));
            }
            System.out.println("Case #" + tt + ": " + result);
        }
    }

    public static String repeat(String str, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            result.append(str);
        }
        return result.toString();
    }
}
