import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        for (int tc = 1; tc <= numberOfTestCases; tc++) {
            String string = scanner.next();
            int depth = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : string.toCharArray()) {
                int num = c - '0';
                while (depth < num) {
                    sb.append('(');
                    depth++;
                }
                while (depth > num) {
                    sb.append(')');
                    depth--;
                }
                sb.append(c);
            }
            while (depth > 0) {
                sb.append(')');
                depth--;
            }
            System.out.println("Case #" + tc + ": " + sb.toString());
        }
    }
}