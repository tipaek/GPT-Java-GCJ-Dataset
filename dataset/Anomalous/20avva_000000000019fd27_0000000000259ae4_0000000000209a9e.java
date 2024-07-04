import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                System.out.println(i + 1);
                array[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            for (int value : array) {
                result.append(value);
            }

            System.out.println(result);

            String response = scanner.next();

            if (!response.equals("Y")) {
                System.exit(0);
            }
        }
    }
}