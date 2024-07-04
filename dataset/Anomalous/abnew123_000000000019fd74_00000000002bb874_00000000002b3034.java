import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            String prefix = "";
            String suffix = "";
            
            for (int j = 0; j < n; j++) {
                String pattern = scanner.next();
                String[] parts = pattern.split("\\*");
                String reversedPattern = new StringBuilder(pattern).reverse().toString();
                String[] reversedParts = reversedPattern.split("\\*");

                // Update prefix
                if (!prefix.startsWith(parts[0])) {
                    if (parts[0].startsWith(prefix)) {
                        prefix = parts[0];
                    } else {
                        prefix = "*";
                    }
                }

                // Update suffix
                if (!suffix.startsWith(reversedParts[0])) {
                    if (reversedParts[0].startsWith(suffix)) {
                        suffix = reversedParts[0];
                    } else {
                        suffix = "*";
                    }
                }
            }

            if (prefix.equals("*") && suffix.equals("*")) {
                System.out.println("Case #" + i + ": *");
            } else {
                System.out.println("Case #" + i + ": " + prefix + new StringBuilder(suffix).reverse().toString());
            }
        }

        scanner.close();
    }
}