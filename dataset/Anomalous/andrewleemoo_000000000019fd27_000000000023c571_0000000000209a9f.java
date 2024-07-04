import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= testCases; i++) {
            String inputString = scanner.nextLine();
            String result = processString(inputString, 0, inputString.length() - 1, 0);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processString(String str, int left, int right, int depth) {
        if (left > right) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (left <= right) {
            int ptr = left;
            while (ptr <= right && (Character.getNumericValue(str.charAt(ptr)) - depth) > 0) {
                ptr++;
            }

            if (ptr > left) {
                result.append("(")
                      .append(processString(str, left, ptr - 1, depth + 1))
                      .append(")");
            } else {
                result.append(str.charAt(ptr));
            }

            left = (left == ptr) ? left + 1 : ptr;
        }
        return result.toString();
    }
}