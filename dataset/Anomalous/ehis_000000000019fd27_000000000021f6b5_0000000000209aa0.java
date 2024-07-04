import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int matrixSize = scanner.nextInt();
            int traceValue = scanner.nextInt();

            System.out.println(determineMatrixPossibility(matrixSize, traceValue, i));
        }
    }

    static String determineMatrixPossibility(int size, int trace, int caseNumber) {
        if (trace % size == 0) {
            return "Case #" + caseNumber + ": POSSIBLE";
        } else {
            return "Case #" + caseNumber + ": IMPOSSIBLE";
        }
    }
}