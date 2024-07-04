import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            String result = solve(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(String input) {
        char[] charArray = input.toCharArray();
        List<Character> result = new ArrayList<Character>();
        int currentNumber;
        int previousNumber;
        int nextNumber;

        for (int j = 0; j < charArray.length; ++j) {
            currentNumber = Character.getNumericValue(charArray[j]);
            if (j > 0) {
                previousNumber = Character.getNumericValue(charArray[j - 1]);
                if (previousNumber > currentNumber) {
                    addParanthesis(false, result, previousNumber - currentNumber);
                }

                if (previousNumber < currentNumber) {
                    addParanthesis(true, result, currentNumber - previousNumber);
                }
            } else {
                addParanthesis(true, result, currentNumber);
            }

            result.add(charArray[j]);

            if (j >= charArray.length - 1) {
                addParanthesis(false, result, currentNumber);
            }
        }

        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static void addParanthesis(Boolean openParam, List<Character> result, int numOfParanthesis) {
        for (int k = 0; k < numOfParanthesis; ++k) {
            if (openParam) {
                result.add('(');
            } else {
                result.add(')');
            }
        }
    }
}
