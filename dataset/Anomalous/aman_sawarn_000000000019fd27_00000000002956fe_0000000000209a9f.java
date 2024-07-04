import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int previousNumber = 0;
            int openBraces = 0;

            for (char ch : input.toCharArray()) {
                int currentNumber = ch - '0';

                if (currentNumber > previousNumber) {
                    for (int i = 0; i < currentNumber - previousNumber; i++) {
                        output.append('(');
                        openBraces++;
                    }
                } else if (currentNumber < previousNumber) {
                    for (int i = 0; i < previousNumber - currentNumber; i++) {
                        output.append(')');
                        openBraces--;
                    }
                }

                output.append(ch);
                previousNumber = currentNumber;
            }

            while (openBraces > 0) {
                output.append(')');
                openBraces--;
            }

            result.append("Case #").append(t).append(": ").append(output).append("\n");
        }

        System.out.print(result);
    }
}