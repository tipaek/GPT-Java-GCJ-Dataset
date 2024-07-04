import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String result = solve(scanner);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        scanner.close();
    }

    public static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        List<String> frontParts = new ArrayList<>();
        List<String> backParts = new ArrayList<>();
        List<String> patterns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String pattern = "A" + scanner.next() + "Z";
            patterns.add(pattern);
            String[] parts = pattern.split("\\*");
            frontParts.add(parts[0]);
            backParts.add(parts[parts.length - 1]);
        }

        String longestFrontPart = findLongest(frontParts);
        String longestBackPart = findLongest(backParts);

        if (!isValid(frontParts, longestFrontPart) || !isValid(backParts, longestBackPart)) {
            return "*";
        }

        StringBuilder result = new StringBuilder(longestFrontPart);
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            for (int i = 1; i < parts.length - 1; i++) {
                result.append(parts[i]);
            }
        }
        result.append(longestBackPart);

        return result.substring(1, result.length() - 1);
    }

    private static String findLongest(List<String> parts) {
        String longest = "";
        for (String part : parts) {
            if (part.length() > longest.length()) {
                longest = part;
            }
        }
        return longest;
    }

    private static boolean isValid(List<String> parts, String longestPart) {
        for (String part : parts) {
            if (!longestPart.startsWith(part) && !longestPart.endsWith(part)) {
                return false;
            }
        }
        return true;
    }
}