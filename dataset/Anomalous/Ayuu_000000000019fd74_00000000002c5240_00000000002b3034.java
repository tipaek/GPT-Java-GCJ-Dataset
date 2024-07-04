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

        // Replace '*' with '_' in each input string
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].replace('*', '_');
        }

        System.out.println(nameAnswer(input));
    }

    public static String nameAnswer(String[] patterns) {
        // Replace '_' with '.*' to create regex patterns
        for (int i = 0; i < patterns.length; i++) {
            patterns[i] = patterns[i].replaceAll("_", ".*");
        }

        String answer = patterns[0];
        boolean result;

        for (int i = 1; i < patterns.length; i++) {
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