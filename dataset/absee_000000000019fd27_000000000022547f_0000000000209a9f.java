import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine(); //skip first line
        for (int ti = 1; ti <= t; ++ti) {
            String s = in.nextLine();
            int[] digitArray = new int[s.length()];
            ArrayList<Number> numbers = new ArrayList<>();
            int preNumber = -1;
            Number currentNumber = null;
            for (char digitChar : s.toCharArray()) {
                int digit = digitChar - '0';

                if (preNumber == digit) {
                    currentNumber.repeatedValue += digit;
                } else {
                    preNumber = digit;
                    currentNumber = new Number(digit);
                    numbers.add(currentNumber);
                }
            }

            //
            StringBuilder sb = new StringBuilder();
            int currentLevel = 0;
            for (Number number : numbers) {
                if (number.digit > currentLevel) {
                    int openParenthesis = number.digit - currentLevel;
                    for (int i = 0; i < openParenthesis; i++) {
                        sb.append('(');
                    }
                } else {
                    int closeParenthesis = currentLevel - number.digit;
                    for (int i = 0; i < closeParenthesis; i++) {
                        sb.append(')');
                    }
                }
                currentLevel = number.digit;
                sb.append(number.repeatedValue);
            }

            while (currentLevel > 0) {
                sb.append(')');
                currentLevel--;
            }

            String result = sb.toString();

            System.out.println("Case #" + ti + ": " + result);
        }
    }

    public static class Number {
        public int digit;
        public String repeatedValue;

        public Number(int digit) {
            this.digit = digit;
            this.repeatedValue = "" + digit;
        }
    }
}