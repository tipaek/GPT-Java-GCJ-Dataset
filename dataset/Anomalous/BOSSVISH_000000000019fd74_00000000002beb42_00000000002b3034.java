import java.util.Scanner;

public class Solution {

    public static String mergePatterns(String pattern1, String pattern2) {
        int firstAsterisk1 = pattern1.indexOf('*');
        int firstAsterisk2 = pattern2.indexOf('*');

        int lastAsterisk1 = pattern1.lastIndexOf('*');
        int lastAsterisk2 = pattern2.lastIndexOf('*');

        String prefix = pattern1.substring(0, firstAsterisk1).compareTo(pattern2.substring(0, firstAsterisk2)) > 0 ? 
                        pattern1.substring(0, firstAsterisk1) : pattern2.substring(0, firstAsterisk2);
        
        String suffix = pattern1.substring(lastAsterisk1 + 1).compareTo(pattern2.substring(lastAsterisk2 + 1)) > 0 ? 
                        pattern1.substring(lastAsterisk1 + 1) : pattern2.substring(lastAsterisk2 + 1);

        String middle = pattern1.substring(firstAsterisk1, lastAsterisk1 + 1).replace("*", "") + 
                        pattern2.substring(firstAsterisk2, lastAsterisk2 + 1).replace("*", "");

        return prefix + middle + suffix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            for (int j = 0; j < n; j++) {
                patterns[j] = scanner.next();
            }

            String result = patterns[0];
            boolean isPossible = true;

            for (int j = 1; j < n && isPossible; j++) {
                String currentPattern = patterns[j];
                int minLength = Math.min(result.length(), currentPattern.length());

                for (int k = 0; k < minLength; k++) {
                    if (result.charAt(k) != '*' && currentPattern.charAt(k) != '*' && result.charAt(k) != currentPattern.charAt(k)) {
                        isPossible = false;
                        break;
                    }
                }

                for (int k = 0; k < minLength; k++) {
                    if (result.charAt(result.length() - 1 - k) != '*' && currentPattern.charAt(currentPattern.length() - 1 - k) != '*' 
                            && result.charAt(result.length() - 1 - k) != currentPattern.charAt(currentPattern.length() - 1 - k)) {
                        isPossible = false;
                        break;
                    }
                }

                if (!isPossible) {
                    result = "*";
                    break;
                }

                result = mergePatterns(result, currentPattern);
            }

            if (!result.equals("*")) {
                result = result.replace("*", "");
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}