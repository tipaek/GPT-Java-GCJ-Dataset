import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EN2018Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        try {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int t = 0; t < testCases; t++) {
                String inputString = scanner.nextLine();
                StringBuilder result = new StringBuilder();
                int currentDepth = 0;

                for (char ch : inputString.toCharArray()) {
                    int digit = ch - '0';
                    while (currentDepth < digit) {
                        result.append('(');
                        currentDepth++;
                    }
                    while (currentDepth > digit) {
                        result.append(')');
                        currentDepth--;
                    }
                    result.append(digit);
                }

                while (currentDepth > 0) {
                    result.append(')');
                    currentDepth--;
                }

                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        } finally {
            scanner.close();
        }
    }
}