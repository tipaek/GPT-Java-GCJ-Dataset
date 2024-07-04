import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            char[] inputArray = input.toCharArray();
            StringBuilder resultBuilder = new StringBuilder();
            int currentOpen = 0;

            for (int k = 0; k < input.length(); k++) {
                int index = k;

                while (index + 1 < inputArray.length && inputArray[k] == inputArray[index + 1]) {
                    index++;
                }

                int number = Character.getNumericValue(inputArray[k]);
                int difference = number - currentOpen;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        resultBuilder.append('(');
                    }
                } else {
                    for (int j = 0; j < -difference; j++) {
                        resultBuilder.append(')');
                    }
                }

                resultBuilder.append(inputArray, k, index - k + 1);
                currentOpen = number;
                k = index;
            }

            while (currentOpen > 0) {
                resultBuilder.append(')');
                currentOpen--;
            }

            System.out.println("Case #" + i + ": " + resultBuilder.toString());
        }
    }
}