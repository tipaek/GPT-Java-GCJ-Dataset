import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String inputLine = scanner.nextLine();
            char[] characters = inputLine.toCharArray();
            int[] numbers = new int[characters.length];
            int[] sortedNumbers = new int[characters.length];
            List<String> answer = new ArrayList<>();

            for (int i = 0; i < characters.length; i++) {
                int number = Character.getNumericValue(characters[i]);
                numbers[i] = number;
                sortedNumbers[i] = number;
                answer.add(String.valueOf(number));
            }

            Arrays.sort(sortedNumbers);
            for (int i = sortedNumbers.length - 1; i >= 0; i--) {
                int currentNumber = sortedNumbers[i];
                int index = findIndex(numbers, currentNumber);

                for (int j = 1; j <= currentNumber; j++) {
                    int leftLimit = findLeftLimit(numbers, index, j);
                    int rightLimit = findRightLimit(numbers, index, j);

                    numbers[index] = -1; // Mark as processed
                    answer.add(leftLimit, "(");
                    answer.add(rightLimit + 1, ")");
                }
            }

            String finalAnswer = String.join("", answer);
            System.out.println("Case #" + caseNumber + ": " + finalAnswer);
        }
    }

    private static int findIndex(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int findLeftLimit(int[] numbers, int startIndex, int target) {
        for (int i = startIndex - 1; i >= 0; i--) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return 0;
    }

    private static int findRightLimit(int[] numbers, int startIndex, int target) {
        for (int i = startIndex + 1; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return numbers.length - 1;
    }
}