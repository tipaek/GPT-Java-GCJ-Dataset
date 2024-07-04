import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String inputString = scanner.nextLine();
            String result = processString(inputString);
            System.out.printf("Case #%d %s\n", caseIndex, result);
        }
    }

    public static String processString(String input) {
        if (input.equals("1")) {
            return "(1)";
        }
        if (input.length() <= 1) {
            return input;
        }
        
        if (input.startsWith("1")) {
            int firstChangeIndex = findFirstChangeIndex(input);
            return "(" + input.substring(0, firstChangeIndex) + ")" + processString(input.substring(firstChangeIndex));
        } else {
            int firstChangeIndex = findFirstChangeIndex(input);
            return input.substring(0, firstChangeIndex) + processString(input.substring(firstChangeIndex));
        }
    }

    public static int findFirstChangeIndex(String input) {
        for (int index = 0; index < input.length() - 1; index++) {
            if (input.charAt(index) != input.charAt(index + 1)) {
                return index + 1;
            }
        }
        return input.length();
    }
}