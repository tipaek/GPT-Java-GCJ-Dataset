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

            StringBuilder string = new StringBuilder();
            for (int i : array) {
                string.append(i);
            }

            System.out.println(string);

            String response = scanner.next();

            if (response.equals("Y")) {
                continue;
            } else {
                System.exit(0);
            }
        }
    }
}
