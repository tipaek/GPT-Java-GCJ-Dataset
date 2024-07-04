import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int i = 0; i < numTests; i++) {
            int numWords = in.nextInt();
            in.nextLine();  // scanner discrepancy

            Set<String> words = new TreeSet<>();

            // for test 1
            String longest = "";

            for (int j = 0; j < numWords; j++) {
                String s = in.nextLine();
                s = s.replace('*', '^');    // alphabetically after UPPERCASE letters
                words.add(s);

                if (s.length() > longest.length()) {
                    longest = s;
                }
            }

            StringBuilder result = new StringBuilder(longest);
            //
            // result.deleteCharAt(0);

            int start = 0;
            boolean match = true;

            for (String s : words) {
                // if (start == 0) {
                // // first term
                // int index = 0;
                // while (s.charAt(index) != '^') {
                // result.append(s.charAt(index));
                // }
                // }
                if (!matches(result, s)) {
                    match = false;
                    break;
                }
            }

            result.deleteCharAt(0);

            if (match)
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            else
                System.out.println("Case #" + (i + 1) + ": *");
        }
    }

    private static boolean matches(StringBuilder result, String s) {
        int offset = result.length() - s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            char oChar = result.charAt(i + offset);
            if (sChar != oChar && sChar != '^') {
                return false;
            }
        }
        return true;
    }
}