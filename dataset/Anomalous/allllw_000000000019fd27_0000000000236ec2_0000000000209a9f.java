import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.next());
        List<String> results = new ArrayList<>();

        for (int i = 0; i < numCases; i++) {
            results.add(processCase(scanner.next()));
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static String processCase(String input) {
        StringBuilder output = new StringBuilder();
        int openParentheses = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';

            while (openParentheses < currentDigit) {
                output.append('(');
                openParentheses++;
            }
            while (openParentheses > currentDigit) {
                output.append(')');
                openParentheses--;
            }

            output.append(input.charAt(i));
        }

        while (openParentheses > 0) {
            output.append(')');
            openParentheses--;
        }

        return output.toString();
    }
}