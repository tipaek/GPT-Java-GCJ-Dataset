import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            String str = sc.next();
            ArrayList<Character> ch = new ArrayList<>();

            if (str.length() == 1) {
                processSingleCharacterString(str, ch);
            } else {
                processMultiCharacterString(str, ch);
            }

            printResult(t, ch);
        }
    }

    private static void processSingleCharacterString(String str, ArrayList<Character> ch) {
        int v = Character.getNumericValue(str.charAt(0));
        if (v > 0) {
            addBracketsAndNumber(ch, v);
        } else {
            ch.add((char) (v + '0'));
        }
    }

    private static void processMultiCharacterString(String str, ArrayList<Character> ch) {
        int length = str.length();

        for (int i = 0; i < length; i++) {
            int currentValue = Character.getNumericValue(str.charAt(i));

            if (i == 0) {
                addBracketsAndNumber(ch, currentValue);
                continue;
            }

            int previousValue = Character.getNumericValue(str.charAt(i - 1));
            int nextValue = (i == length - 1) ? currentValue : Character.getNumericValue(str.charAt(i + 1));

            if (i == length - 1) {
                addClosingBrackets(ch, currentValue, previousValue);
            } else {
                adjustBrackets(ch, currentValue, previousValue, nextValue);
            }
        }
    }

    private static void addBracketsAndNumber(ArrayList<Character> ch, int value) {
        for (int j = 0; j < value; j++) {
            ch.add('(');
        }
        ch.add((char) (value + '0'));
    }

    private static void adjustBrackets(ArrayList<Character> ch, int currentValue, int previousValue, int nextValue) {
        if (currentValue > previousValue) {
            addBrackets(ch, currentValue - previousValue, '(');
        } else if (currentValue < previousValue) {
            addBrackets(ch, previousValue - currentValue, ')');
        }
        ch.add((char) (currentValue + '0'));
    }

    private static void addClosingBrackets(ArrayList<Character> ch, int currentValue, int previousValue) {
        if (currentValue > previousValue) {
            addBrackets(ch, currentValue - previousValue, '(');
        } else if (currentValue < previousValue) {
            addBrackets(ch, previousValue - currentValue, ')');
        }
        ch.add((char) (currentValue + '0'));
        addBrackets(ch, currentValue, ')');
    }

    private static void addBrackets(ArrayList<Character> ch, int count, char bracket) {
        for (int j = 0; j < count; j++) {
            ch.add(bracket);
        }
    }

    private static void printResult(int caseNumber, ArrayList<Character> ch) {
        System.out.print("Case #" + caseNumber + ": ");
        for (char c : ch) {
            System.out.print(c);
        }
        System.out.println();
    }
}