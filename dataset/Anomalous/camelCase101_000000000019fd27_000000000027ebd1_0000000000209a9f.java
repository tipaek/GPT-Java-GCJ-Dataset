import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            boolean isOne = false;

            for (char ch : input.toCharArray()) {
                if (ch == '1') {
                    if (!isOne) {
                        result.append("(1");
                        isOne = true;
                    } else {
                        result.append("1");
                    }
                } else { // ch == '0'
                    if (isOne) {
                        result.append(")0");
                        isOne = false;
                    } else {
                        result.append("0");
                    }
                }
            }

            if (isOne) {
                result.append(")");
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}