import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTestcases = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= numberOfTestcases; i++) {
            findSolution(i, in.nextLine());
        }
    }

    private static void findSolution(int index, String input) {
        String inputWithParenthesis = "";

        for(int i = 0; i < input.length(); i++) {
            inputWithParenthesis += wrap(input.charAt(i));
        }

        String output = removeObsoleteParenthesis(inputWithParenthesis);

        System.out.println(String.format("Case #%s: %s", index, output));
    }

    private static String wrap(char inputChar) {
        int multiplier = Integer.parseInt("" + inputChar);

        return new String(new char[multiplier]).replace("\0", "(") +
                inputChar +
                new String(new char[multiplier]).replace("\0", ")");
    }

    private static String removeObsoleteParenthesis(String inputWithParenthesis) {
        String oldString = inputWithParenthesis;
        String newString = reduce(oldString);

        while (oldString.length() != newString.length()) {
            oldString = newString;
            newString = reduce(oldString);
        }

        return newString;
    }

    private static String reduce(String input) {
        return input.replaceAll("[)][(]", "");
    }
}
