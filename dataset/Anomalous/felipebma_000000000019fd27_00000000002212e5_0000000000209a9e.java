import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            processCase(caseIndex, arraySize);
            scanner.next();  // Read the string input
        }
    }

    private static void processCase(int caseIndex, int size) {
        int[] results = new int[size];

        for (int i = 0; i < 10; i++) {
            results[i] = queryPosition(i);
        }

        StringBuilder resultString = new StringBuilder();
        for (int value : results) {
            resultString.append(value);
        }
        System.out.println(resultString.toString());
    }

    private static int queryPosition(int position) {
        System.out.println(position + 1);
        return scanner.nextInt();
    }
}