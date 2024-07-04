import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        try {
            int testCases = scanner.nextInt();
            ArrayList<ArrayList<Integer>> cases = new ArrayList<>();
            for (int i = 0; i < testCases; i++) {
                String testString = scanner.next();
                ArrayList<Integer> testCase = new ArrayList<>();
                for(int j = 0; j < testString.length(); j++){
                    char c = testString.charAt(j);
                    testCase.add(Character.getNumericValue(c));
                }
                cases.add(testCase);
            }
            for (int i = 0; i < testCases; i++) {
                solve(cases.get(i), i + 1);
            }
        } catch (Exception e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        } finally {
            scanner.close();
        }
    }

    private static void solve(ArrayList<Integer> digits, int caseNumber) {

        StringBuilder sb = new StringBuilder();
        int previousDigit = 0;
        int numberOfDigits = digits.size();
        for(int i = 0; i <= numberOfDigits; i++){
            int digit = i == numberOfDigits ? 0 : digits.get(i);
            int difference = previousDigit - digit;
            if (difference < 0) {
                for (int j = 0; j > difference; j--) {
                    sb.append('(');
                }
            }
            if (difference > 0) {
                for (int j = 0; j < difference; j++) {
                    sb.append(')');
                }
            }

            if(i < numberOfDigits){
                sb.append(digit);
            }
            previousDigit = digit;
        }

        System.out.printf("Case #%d: %s\n", caseNumber, sb.toString());
    }
}
