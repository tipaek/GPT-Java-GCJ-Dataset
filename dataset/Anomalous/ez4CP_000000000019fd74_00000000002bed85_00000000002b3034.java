import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            List<String> strings = new ArrayList<>();
            int n = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            int maxLength = Integer.MIN_VALUE;
            String maxString = "";

            for (int i = 0; i < n; i++) {
                String input = sc.nextLine();
                strings.add(input);

                if (input.length() > maxLength) {
                    maxLength = input.length();
                    maxString = input;
                }
            }

            boolean isMatch = true;

            for (String str : strings) {
                if (!match(maxString, str)) {
                    System.out.println("Case #" + caseNum + ": *");
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                System.out.println("Case #" + caseNum + ": " + maxString.substring(1));
            }
        }
    }

    public static boolean match(String s1, String s2) {
        if ((s1.endsWith("*") && s2.startsWith("*")) || (s1.startsWith("*") && s2.endsWith("*"))) {
            return true;
        } else if (s1.startsWith("*") && s2.startsWith("*")) {
            return s1.substring(1).endsWith(s2.substring(1));
        } else if (s1.endsWith("*") && s2.endsWith("*")) {
            return s1.substring(0, s1.length() - 1).contains(s2.substring(0, s2.length() - 1));
        }
        return false;
    }
}