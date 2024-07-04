import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; ++i) {
            String number = scanner.nextLine();
            char[] digits = number.toCharArray();
            List<Character> result = new ArrayList<>();

            int balance = 0;
            for (char digit : digits) {
                int currentDigit = Character.getNumericValue(digit);
                while (balance < currentDigit) {
                    result.add('(');
                    balance++;
                }
                while (balance > currentDigit) {
                    result.add(')');
                    balance--;
                }
                result.add(digit);
            }

            while (balance > 0) {
                result.add(')');
                balance--;
            }

            StringBuilder output = new StringBuilder();
            for (char ch : result) {
                output.append(ch);
            }

            System.out.println("Case #" + i + ": " + output.toString());
        }
    }
}