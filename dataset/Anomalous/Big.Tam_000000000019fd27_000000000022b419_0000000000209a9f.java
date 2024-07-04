import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String inputString = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();

            int currentIndex = 0;
            while (currentIndex < inputString.length()) {
                char currentChar = inputString.charAt(currentIndex);

                if (currentChar == '0') {
                    resultBuilder.append(currentChar);
                } else if (currentChar == '1') {
                    int startIndex = currentIndex;
                    while (currentIndex < inputString.length() && inputString.charAt(currentIndex) == '1') {
                        currentIndex++;
                    }
                    resultBuilder.append("(").append(inputString, startIndex, currentIndex).append(")");
                    currentIndex--; // Adjust position after inner loop
                }
                currentIndex++;
            }

            System.out.println("Case #" + caseIndex + ": " + resultBuilder.toString());
        }
    }
}