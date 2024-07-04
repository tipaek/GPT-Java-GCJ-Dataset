import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        if (arraySize == 10) {
            handleCaseTen(scanner, numCases, arraySize);
        }
    }

    private static void handleCaseTen(Scanner scanner, int numCases, int arraySize) {
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                System.out.println(i);
                array[i] = scanner.nextInt();
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int value : array) {
                stringBuilder.append(value);
            }

            System.out.println(stringBuilder.toString());

            String response = scanner.next();

            if (!response.equals("Y")) {
                System.exit(0);
            }
        }
    }
}