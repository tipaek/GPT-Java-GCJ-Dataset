import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static String outputStr = "";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int cases = 1; cases <= testCases; cases++) {

            String input = scanner.nextLine();
            if(input.equals("")){
                cases--;
                continue;
            }
            outputStr = "";
            for (int i = 0; i < input.length(); i++) {

                int digit = Integer.parseInt(input.charAt(i) + "");
                addRequiredOpenBrackets(digit);
                removeAddRequiredCloseBrackets(digit);

            }
            System.out.println("Case #"+cases+": "+outputStr);
        }
    }

    private static int countOpenBrackets() {
        int count = 0;
        int indexOfLastZero = outputStr.lastIndexOf("0") == -1 ? 0 : outputStr.lastIndexOf("0");
        for (int i = indexOfLastZero; i < outputStr.length(); i++) {
            String character = outputStr.charAt(i) + "";
            if (character.equals("(")) {
                count++;
            }
        }
        return count;
    }

    private static int countCloseBrackets() {
        int count = 0;
        int indexOfLastZero = outputStr.lastIndexOf("0") == -1 ? 0 : outputStr.lastIndexOf("0");
        for (int i = indexOfLastZero; i < outputStr.length(); i++) {
            String character = outputStr.charAt(i) + "";
            if (character.equals(")")) {
                count++;
            }
        }
        return count;
    }

    private static void addRequiredOpenBrackets(int digit) {
        int alreadyPresentBrackets = countOpenBrackets();
        int requiredBrackets = Math.max(0,digit - alreadyPresentBrackets);
        StringBuilder builder = new StringBuilder(outputStr);
        for (int i = 0; i < requiredBrackets; i++) {
            if (digit != 0) {
                builder.append("(");
            }

        }
        builder.append(digit);
        outputStr = builder.toString();
    }

    private static void removeAddRequiredCloseBrackets(int digit) {
        int alreadyPresentCloseBrackets = countCloseBrackets();
        int bracketsToBeRemoved=digit;
        int indexOfLastZero = outputStr.lastIndexOf("0") == -1 ? 0 : outputStr.lastIndexOf("0");
        StringBuilder build = new StringBuilder(outputStr);
        for (int i = indexOfLastZero; i < build.length(); i++) {
            if (bracketsToBeRemoved > 0 && build.charAt(i) == ')') {
                build.deleteCharAt(i);
                i--;
                bracketsToBeRemoved--;
            }
        }
        for (int i = 0; i < digit; i++) {
            build.append(")");
        }
        outputStr = build.toString();
    }

}
