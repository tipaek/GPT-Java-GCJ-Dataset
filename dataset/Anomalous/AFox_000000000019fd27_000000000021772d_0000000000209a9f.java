import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String inputString = scanner.nextLine();
            String resultString = processString(inputString);
            System.out.printf("Cases #%d %s\n", caseNumber, resultString);
        }
    }

    public static String processString(String s) {
        if ("1".equals(s)) {
            return "(1)";
        }
        if (s.length() <= 1) {
            return s;
        }
        int firstChangeIndex = findFirstChangeIndex(s);
        if (s.charAt(0) == '1') {
            return "(" + s.substring(0, firstChangeIndex) + ")" + processString(s.substring(firstChangeIndex));
        } else {
            return s.substring(0, firstChangeIndex) + processString(s.substring(firstChangeIndex));
        }
    }

    public static int findFirstChangeIndex(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return i + 1;
            }
        }
        return s.length();
    }
}