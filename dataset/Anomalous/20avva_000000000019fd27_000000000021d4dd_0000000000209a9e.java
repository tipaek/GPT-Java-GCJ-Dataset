import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int[] array = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                System.out.println(i);
                array[i] = scanner.nextInt();
            }

            StringBuilder result = new StringBuilder();
            for (int element : array) {
                result.append(element);
            }

            System.out.println(result.toString());

            String response = scanner.next();

            if (!response.equalsIgnoreCase("Y")) {
                System.exit(0);
            }
        }
    }
}