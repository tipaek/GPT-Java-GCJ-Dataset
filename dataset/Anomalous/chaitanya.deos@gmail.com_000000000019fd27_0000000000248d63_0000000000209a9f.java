import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")));
        
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                String input = scanner.next();
                StringBuilder builder = new StringBuilder();
                int prev = 0;

                for (int j = 0; j < input.length(); j++) {
                    int current = input.charAt(j) - '0';
                    if (j > 0) {
                        builder.append(prev);
                    }

                    int diff = current - prev;
                    char ch = (diff > 0) ? '(' : ')';

                    for (int k = 0; k < Math.abs(diff); k++) {
                        builder.append(ch);
                    }

                    prev = current;
                }

                builder.append(prev);
                for (int k = 0; k < prev; k++) {
                    builder.append(')');
                }

                System.out.printf("Case #%d: %s%n", (i + 1), builder.toString());
            }
        }

        scanner.close();
    }
}