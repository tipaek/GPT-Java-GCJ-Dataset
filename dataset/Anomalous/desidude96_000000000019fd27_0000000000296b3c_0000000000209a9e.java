import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while (true) {
            int numberOfCases = scanner.nextInt();
            int arraySize = scanner.nextInt();
            int[] array = new int[arraySize];
            boolean shouldTerminate = false;

            for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
                populateArray(array, scanner);
                StringBuilder result = new StringBuilder();

                for (int element : array) {
                    result.append(element);
                }
                System.out.println(result);

                if (scanner.next().equals("N")) {
                    shouldTerminate = true;
                    break;
                }
            }

            if (shouldTerminate) {
                break;
            }
        }
    }

    private static void populateArray(int[] array, Scanner scanner) {
        for (int index = 0; index < array.length; index++) {
            System.out.println(index + 1);
            array[index] = scanner.nextInt();
        }
    }
}