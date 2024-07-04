import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        for (int curCase = 1; curCase <= numCases; curCase++) {
            String s = scanner.next();
            System.out.println("Case #" + curCase + ": " + generateNestedString(s));
        }
    }

    public static String generateNestedString(String s) {
        StringBuilder result = new StringBuilder();
        List<String> segments = new ArrayList<>();
        StringBuilder currentSegment = new StringBuilder().append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentSegment.charAt(0)) {
                currentSegment.append(s.charAt(i));
            } else {
                segments.add(currentSegment.toString());
                currentSegment = new StringBuilder().append(s.charAt(i));
            }
        }
        segments.add(currentSegment.toString());

        int nestingLevel = 0;
        for (String segment : segments) {
            int digit = segment.charAt(0) - '0';
            while (nestingLevel < digit) {
                result.append("(");
                nestingLevel++;
            }
            while (nestingLevel > digit) {
                result.append(")");
                nestingLevel--;
            }
            result.append(segment);
        }
        while (nestingLevel > 0) {
            result.append(")");
            nestingLevel--;
        }

        return result.toString();
    }
}