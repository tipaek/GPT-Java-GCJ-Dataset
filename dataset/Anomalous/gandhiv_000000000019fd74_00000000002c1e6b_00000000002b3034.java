import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            List<String> patterns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String pattern = scanner.next().substring(1);
                patterns.add(pattern);
            }

            TreeSet<String> sortedPatterns = new TreeSet<>(patterns);
            patterns = new ArrayList<>(sortedPatterns);

            String[] patternArray = new String[patterns.size()];
            int index = 0;
            for (String pattern : patterns) {
                patternArray[index++] = pattern;
            }

            for (int i = 1; i < patternArray.length; i++) {
                String key = patternArray[i];
                int j = i - 1;
                while (j >= 0 && key.length() < patternArray[j].length()) {
                    patternArray[j + 1] = patternArray[j];
                    j--;
                }
                patternArray[j + 1] = key;
            }

            boolean isMatch = true;
            for (int i = 1; i < patternArray.length && isMatch; i++) {
                if (!isPatternMatch("*" + patternArray[i - 1], patternArray[i])) {
                    isMatch = false;
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (isMatch) {
                System.out.println(patternArray[patternArray.length - 1]);
            } else {
                System.out.println("*");
            }
        }
        scanner.close();
    }

    public static boolean isPatternMatch(String first, String second) {
        if (first.isEmpty() && second.isEmpty()) {
            return true;
        }
        if (first.length() > 1 && first.charAt(0) == '*' && second.isEmpty()) {
            return false;
        }
        if (!first.isEmpty() && !second.isEmpty() && first.charAt(0) == second.charAt(0)) {
            return isPatternMatch(first.substring(1), second.substring(1));
        }
        if (!first.isEmpty() && first.charAt(0) == '*') {
            return isPatternMatch(first.substring(1), second) || isPatternMatch(first, second.substring(1));
        }
        return false;
    }
}