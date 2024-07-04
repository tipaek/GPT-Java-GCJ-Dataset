import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNumber = in.nextInt();
        String[] answers = new String[caseNumber];
        for (int i = 0; i < caseNumber; i++) {
            String input = in.next();
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));
                StringBuilder digitWithParanthesis = new StringBuilder(String.valueOf(input.charAt(j)));
                for (int k = 0; k < digit; k++) {
                    digitWithParanthesis.insert(0, "(");
                    digitWithParanthesis.append(")");
                }
                result.append(digitWithParanthesis);
            }
            String answer = result.toString();
            while (answer.contains(")(")) {
                answer = answer.replaceAll("\\)\\(", "");
            }
            answers[i] = "Case #" + (i + 1) + ": " + answer;
        }
        for (int i = 0; i < caseNumber; i++) {
            System.out.println(answers[i]);
        }
    }
}
