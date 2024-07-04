import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // Consume the newline character after the integer input
        for (int i = 1; i <= t; ++i) {
            String data = in.nextLine();
            StringBuilder result = new StringBuilder();
            int depth = 0;

            for (int j = 0; j < data.length(); j++) {
                int currentDigit = Character.getNumericValue(data.charAt(j));
                if (currentDigit > depth) {
                    for (int z = 0; z < currentDigit - depth; z++) {
                        result.append("(");
                    }
                    depth = currentDigit;
                } else if (currentDigit < depth) {
                    for (int z = 0; z < depth - currentDigit; z++) {
                        result.append(")");
                    }
                    depth = currentDigit;
                }
                result.append(currentDigit);
            }

            while (depth > 0) {
                result.append(")");
                depth--;
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}