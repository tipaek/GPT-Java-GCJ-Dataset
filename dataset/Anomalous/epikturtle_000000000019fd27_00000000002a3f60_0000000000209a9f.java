import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= cases; i++) {
            String input = scanner.nextLine();
            ArrayList<Character> outputList = new ArrayList<>();
            char[] digits = input.toCharArray();
            int offset = 0;

            for (char digit : digits) {
                outputList.add(digit);
            }

            for (int j = 0; j < digits.length; j++) {
                int currentDigitValue = Character.getNumericValue(digits[j]);
                int nestedDepth = calculateNestedDepth(outputList, j + offset);

                while (currentDigitValue > nestedDepth) {
                    outputList.add(j + offset, '(');
                    offset++;
                    nestedDepth++;
                }

                while (currentDigitValue < nestedDepth) {
                    outputList.add(j + offset, ')');
                    offset++;
                    nestedDepth--;
                }
            }

            StringBuilder output = new StringBuilder();
            for (char character : outputList) {
                output.append(character);
            }

            System.out.println("Case #" + i + ": " + output);
        }

        scanner.close();
    }

    public static int calculateNestedDepth(ArrayList<Character> list, int index) {
        int depth = 0;
        for (int i = 0; i < index; i++) {
            if (list.get(i) == '(') {
                depth++;
            } else if (list.get(i) == ')') {
                depth--;
            }
        }
        return depth;
    }
}