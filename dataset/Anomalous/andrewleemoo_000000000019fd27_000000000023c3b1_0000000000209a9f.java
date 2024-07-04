import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.nextLine();
            String result = processString(input, 0, input.length() - 1, 0);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processString(String s, int left, int right, int depth) {
        if (left > right) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (left <= right) {
            int ptr = left;
            while (ptr <= right && (Character.getNumericValue(s.charAt(ptr)) - depth) > 0) {
                ptr++;
            }
            if (ptr > left) {
                result.append("(").append(processString(s, left, ptr - 1, depth + 1)).append(")");
            } else {
                result.append(s.charAt(ptr));
            }
            left = (left == ptr) ? left + 1 : ptr;
        }
        return result.toString();
    }
}