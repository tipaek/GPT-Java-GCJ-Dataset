import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            String s = in.next();
            StringBuilder sNew = new StringBuilder();
            int counter = 1;
            int prevNumber = Character.getNumericValue(s.charAt(0));

            if (s.length() > 1) {
                for (int j = 1; j < s.length(); j++) {
                    int actualNumber = Character.getNumericValue(s.charAt(j));
                    if (prevNumber == actualNumber) {
                        counter++;
                    } else {
                        appendBrackets(sNew, prevNumber, counter);
                        counter = 1;
                    }
                    prevNumber = actualNumber;

                    if (j == s.length() - 1) {
                        appendBrackets(sNew, prevNumber, counter);
                    }
                }
            } else {
                appendBrackets(sNew, prevNumber, counter);
            }

            String result = fixBraces(sNew.toString());
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static void appendBrackets(StringBuilder sNew, int number, int count) {
        for (int k = 0; k < number; k++) {
            sNew.append("(");
        }
        for (int k = 0; k < count; k++) {
            sNew.append(number);
        }
        for (int k = 0; k < number; k++) {
            sNew.append(")");
        }
    }

    private static String fixBraces(String sNew) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sNew.length() - 1; i++) {
            if ((sNew.charAt(i) == '(' && sNew.charAt(i + 1) == ')') || (sNew.charAt(i) == ')' && sNew.charAt(i + 1) == '(')) {
                i++;
            } else {
                result.append(sNew.charAt(i));
            }
            if (i == sNew.length() - 2) {
                result.append(sNew.charAt(i + 1));
            }
        }
        return result.toString();
    }
}