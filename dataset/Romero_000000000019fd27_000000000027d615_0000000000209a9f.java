import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        for (int inputNumber = 1; inputNumber <= cases; ++inputNumber) {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();
            int depth = 0;
            for (char c : s.toCharArray()) {
                int value = c - '0';
                if (depth < value) {
                    while (depth < value) {
                        sb.append('(');
                        depth++;
                    }
                } else if (depth > value) {
                    while (depth > value) {
                        sb.append(')');
                        depth--;
                    }
                }
                sb.append(c);
            }
            while (depth > 0) {
                sb.append(')');
                depth--;
            }

            System.out.println(String.format("Case #%d: %s", inputNumber, sb.toString()));
        }
    }
}
