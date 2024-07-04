import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int c = 1; c <= t; c++) {
            String input = scanner.next();
            StringBuilder out = new StringBuilder();
            int d = 0;
            for (int i = 0; i < input.length(); i++) {
                int cur = input.charAt(i) - '0';
                int diff = cur - d;
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) out.append('(');
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) out.append(')');
                }
                out.append(cur);
                d = cur;
            }
            for (int j = 0; j < d; j++) out.append(')');
            System.out.println("Case #" + c + ": " + out);
        }
    }
}
