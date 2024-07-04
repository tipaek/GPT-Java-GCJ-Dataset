import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            solveCase(i, arraySize);
        }
    }

    private static void solveCase(int caseNumber, int size) {
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