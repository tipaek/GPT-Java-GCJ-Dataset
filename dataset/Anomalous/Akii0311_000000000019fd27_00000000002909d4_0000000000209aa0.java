import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int matrixSize = scanner.nextInt();
            int traceValue = scanner.nextInt();
            boolean isPossible = false;

            for (int i = 1; i <= matrixSize; i++) {
                int calculatedTrace = i * matrixSize;
                if (calculatedTrace == traceValue) {
                    System.out.println("Case #" + caseNumber + ": POSSIBLE");
                    isPossible = true;
                    generateLatinSquare(matrixSize, i + 1);
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
    }

    public static void generateLatinSquare(int size, int start) {
        for (int i = 1; i <= size; i++) {
            int temp = start;
            while (temp <= size) {
                System.out.print(temp + " ");
                temp++;
            }
            for (int j = 1; j < start; j++) {
                System.out.print(j + " ");
            }
            start--;
            if (start == 0) {
                start = size;
            }
            System.out.println();
        }
    }
}