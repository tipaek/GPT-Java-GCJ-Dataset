import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static int r = 0;

    public static String addParentheses(String s) {
        return "(" + s + ")";
    }

    public static String solve(String s, int depth, int limit) {
        if (s.isEmpty()) {
            return "";
        }

        int firstGreaterIndex = -1;
        boolean foundGreater = false;
        StringBuilder result = new StringBuilder();
        int smallestDigit = 10;
        int currentDigit = Character.getNumericValue(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            currentDigit = Character.getNumericValue(s.charAt(i));
            if (currentDigit < smallestDigit) {
                smallestDigit = currentDigit;
            }
            if (currentDigit > depth && !foundGreater) {
                firstGreaterIndex = i;
                foundGreater = true;
            } else if (currentDigit == depth) {
                if (firstGreaterIndex != -1 && foundGreater) {
                    result.append(solve(s.substring(firstGreaterIndex, i), depth + 1, depth))
                          .append(s.charAt(i));
                    foundGreater = false;
                    firstGreaterIndex = -1;
                } else {
                    result.append(s.charAt(i));
                }
            }

            if (i == s.length() - 1 && currentDigit > depth) {
                if (firstGreaterIndex != -1 && foundGreater) {
                    result.append(solve(s.substring(firstGreaterIndex, i + 1), depth + 1, depth));
                }
            }
        }

        int parenthesesCount = depth - limit;
        while (parenthesesCount > 0) {
            result = new StringBuilder(addParentheses(result.toString()));
            parenthesesCount--;
            r++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 1; t <= testCases; t++) {
                String inputString = br.readLine();
                String result = solve(inputString, 0, 0);
                System.out.println("Case #" + t + ": " + result);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}