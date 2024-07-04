import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        if (TEST_MODE) {
            try {
                String filePath = System.getProperty("user.dir") + "/src/solution/jam2020_q1.txt";
                System.setIn(new FileInputStream(filePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            for (int i = 1; i <= testCases; i++) {
                String input = scanner.nextLine();
                System.out.println("Case #" + i + ": " + solve(input));
            }
        }
    }

    private static String solve(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}