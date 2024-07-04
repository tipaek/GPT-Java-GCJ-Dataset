import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] input = new String[t];
        
        for (int i = 0; i < t; i++) {
            input[i] = sc.next();
        }

        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].replace('*', '_');
        }

        for (int k = 1; k <= t; k++) {
            System.out.println("Case #" + k + ": " + nameAnswer(input));
        }
    }

    public static String nameAnswer(String[] patterns) {
        for (int i = 0; i < patterns.length; i++) {
            patterns[i] = patterns[i].replace("_", ".*");
        }

        String answer = patterns[0];
        for (int i = 1; i < patterns.length; i++) {
            boolean result;
            if (answer.length() < patterns[i].length()) {
                result = Pattern.matches(answer, patterns[i]);
            } else {
                result = Pattern.matches(patterns[i], answer);
            }

            if (result) {
                if (patterns[i].length() > answer.length()) {
                    answer = patterns[i];
                }
            } else {
                return "*";
            }
        }

        if (answer.contains("*")) {
            answer = answer.replace('*', ' ').replaceAll(". ", "");
        }

        return answer;
    }
}