import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            ArrayList<Integer> digits = new ArrayList<>();
            for (char ch : input.toCharArray()) {
                digits.add(Character.getNumericValue(ch));
            }
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            for (int digit : digits) {
                if (digit > previousDigit) {
                    for (int j = 0; j < digit - previousDigit; j++) {
                        result.append('(');
                    }
                } else if (digit < previousDigit) {
                    for (int j = 0; j < previousDigit - digit; j++) {
                        result.append(')');
                    }
                }
                result.append(digit);
                previousDigit = digit;
            }
            for (int j = 0; j < previousDigit; j++) {
                result.append(')');
            }
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}