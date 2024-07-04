import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            String[] input = new String[n];
            for (int j = 0; j < n; j++) {
                input[j] = sc.next();
            }
            System.out.println("Case #" + k + ": " + findMatchingPattern(input));
        }
    }

    public static String findMatchingPattern(String[] patterns) {
        String answer = patterns[0];
        for (int i = 1; i < patterns.length; i++) {
            boolean matches;
            if (answer.length() < patterns[i].length()) {
                matches = Pattern.matches(answer.replace('*', '.'), patterns[i].replace('*', '.'));
            } else {
                matches = Pattern.matches(patterns[i].replace('*', '.'), answer.replace('*', '.'));
            }
            if (matches) {
                if (patterns[i].length() > answer.length()) {
                    answer = patterns[i];
                }
            } else {
                return "*";
            }
        }

        if (answer.contains("*")) {
            return answer.replace("*", "");
        }

        return answer;
    }
}