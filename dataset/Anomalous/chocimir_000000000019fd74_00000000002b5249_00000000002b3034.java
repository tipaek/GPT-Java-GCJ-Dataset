import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    String solve(Scanner in) {
        int n = in.nextInt();
        List<String> strings = new ArrayList<>();
        List<String> revStrings = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            String s = in.next();
            strings.add(s);
            revStrings.add(reverseString(s));
        }
        
        String prefix = findCommonPrefix(strings);
        if (prefix.equals("*")) {
            return prefix;
        }

        String suffix = reverseString(findCommonPrefix(revStrings));
        if (suffix.equals("*")) {
            return suffix;
        }

        StringBuilder result = new StringBuilder(prefix);
        for (String s : strings) {
            result.append(extractMiddle(s));
        }
        result.append(suffix);
        return result.toString();
    }

    private String extractMiddle(String s) {
        int firstAsterisk = s.indexOf('*');
        int lastAsterisk = s.lastIndexOf('*');
        StringBuilder middlePart = new StringBuilder();

        for (int i = firstAsterisk; i <= lastAsterisk; ++i) {
            if (s.charAt(i) != '*') {
                middlePart.append(s.charAt(i));
            }
        }
        return middlePart.toString();
    }

    private String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String findCommonPrefix(List<String> strings) {
        String prefix = "";

        for (String s : strings) {
            int i = 0;
            while (s.charAt(i) != '*') {
                if (prefix.length() > i && prefix.charAt(i) != s.charAt(i)) {
                    return "*";
                }
                if (prefix.length() <= i) {
                    prefix += s.charAt(i);
                }
                i++;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        Solution solution = new Solution();

        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solution.solve(in));
        }
    }
}