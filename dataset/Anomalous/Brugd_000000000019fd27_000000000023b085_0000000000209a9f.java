import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in); PrintWriter output = new PrintWriter(System.out)) {
            int testCases = input.nextInt();

            for (int i = 0; i < testCases; i++) {
                String result = process(input.next().toCharArray());
                output.printf("Case #%d: %s%n", i + 1, result);
            }
        }
    }

    public static String process(char[] str) {
        StringBuilder builder = new StringBuilder();
        int state = 0;

        if (str[0] == '1') {
            state = 1;
            builder.append('(');
        }

        for (char c : str) {
            if (state == 0 && c == '1') {
                state = 1;
                builder.append('(');
            } else if (state == 1 && c == '0') {
                state = 0;
                builder.append(')');
            }
            builder.append(c);
        }

        if (state == 1) {
            builder.append(')');
        }

        return builder.toString();
    }
}