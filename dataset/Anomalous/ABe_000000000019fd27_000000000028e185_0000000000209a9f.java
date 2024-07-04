import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            String input = scanner.next();
            char[] inputArray = input.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentOpen = 0;

            for (int i = 0; i < inputArray.length; ) {
                int index = i;
                while (index + 1 < inputArray.length && inputArray[index] == inputArray[index + 1]) {
                    index++;
                }

                int number = Character.getNumericValue(inputArray[i]);
                int difference = number - currentOpen;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else {
                    result.append(")".repeat(-difference));
                }

                for (int j = i; j <= index; j++) {
                    result.append(inputArray[j]);
                }

                currentOpen = number;
                i = index + 1;
            }

            result.append(")".repeat(currentOpen));

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}