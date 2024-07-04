import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String inputLine = scanner.nextLine();
            processInput(inputLine, i);
        }
    }

    public static void processInput(String input, int caseNumber) {
        char[] characters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        if (characters[0] == '1') {
            result.append("(1");
            openParentheses++;
        } else {
            result.append("0");
        }

        for (int i = 1; i < characters.length; i++) {
            if (characters[i] == '1') {
                if (openParentheses == 0) {
                    result.append("(");
                    openParentheses++;
                }
                result.append("1");
            } else {
                if (openParentheses == 1) {
                    result.append(")");
                    openParentheses--;
                }
                result.append("0");
            }
        }

        if (characters[characters.length - 1] == '1') {
            result.append(")");
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}