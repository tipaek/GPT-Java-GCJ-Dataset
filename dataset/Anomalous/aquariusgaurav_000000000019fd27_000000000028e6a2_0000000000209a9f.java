import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        for (int temp = 1; temp <= t; temp++) {
            String s = scn.next();
            boolean isUniform = isUniformString(s);

            if (isUniform) {
                if (s.charAt(0) == '0') {
                    System.out.println("Case #" + temp + ": " + s);
                } else {
                    System.out.println("Case #" + temp + ": " + "(" + s + ")");
                }
            } else {
                ArrayList<Integer> segments = getSegments(s);
                String formattedString = formatSegments(s.charAt(0), segments);
                System.out.println("Case #" + temp + ": " + formattedString);
            }
        }
    }

    private static boolean isUniformString(String s) {
        char firstChar = s.charAt(0);
        for (char ch : s.toCharArray()) {
            if (ch != firstChar) {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Integer> getSegments(String s) {
        ArrayList<Integer> segments = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                segments.add(count);
                count = 1;
            }
        }
        segments.add(count);
        return segments;
    }

    private static String formatSegments(char firstChar, ArrayList<Integer> segments) {
        StringBuilder result = new StringBuilder();
        boolean isZeroSegment = (firstChar == '0');

        for (int i = 0; i < segments.size(); i++) {
            int segmentLength = segments.get(i);
            if (isZeroSegment) {
                result.append("0".repeat(segmentLength));
            } else {
                result.append("(").append("1".repeat(segmentLength)).append(")");
            }
            isZeroSegment = !isZeroSegment;
        }

        return result.toString();
    }
}