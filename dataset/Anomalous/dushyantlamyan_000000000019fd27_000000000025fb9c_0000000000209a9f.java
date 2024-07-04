import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            boolean isBinary = input.chars().allMatch(c -> c == '0' || c == '1');
            StringBuilder output = new StringBuilder();

            if (isBinary) {
                StringBuilder ones = new StringBuilder();
                for (int j = 0; j < input.length(); j++) {
                    char currentChar = input.charAt(j);
                    if (currentChar == '0') {
                        if (ones.length() > 0) {
                            output.append(ones).append(')');
                            ones.setLength(0);
                        }
                        output.append('0');
                    } else {
                        if (ones.length() == 0) {
                            output.append('(');
                        }
                        ones.append('1');
                        if (j == input.length() - 1) {
                            output.append(ones).append(')');
                        }
                    }
                }
            } else {
                String startBrackets = "((((((((((";
                String endBrackets = "))))))))))";
                int previousNum = 0;

                for (int j = 0; j < input.length(); j++) {
                    int currentNum = Character.getNumericValue(input.charAt(j));
                    if (j == 0) {
                        output.append(startBrackets, 0, currentNum).append(input.charAt(j));
                    } else {
                        if (previousNum > currentNum) {
                            output.append(endBrackets, 0, previousNum - currentNum).append(input.charAt(j));
                        } else {
                            output.append(startBrackets, 0, currentNum - previousNum).append(input.charAt(j));
                        }
                    }
                    previousNum = currentNum;
                }
                output.append(endBrackets, 0, previousNum);
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}