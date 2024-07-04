import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt(); // Number of cases

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = scanner.nextInt(); // Matrix size
            System.out.println(matrixSize);

            int[] matrix = new int[matrixSize * matrixSize];
            for (int elementIndex = 0; elementIndex < matrix.length; elementIndex++) {
                int elementValue = scanner.nextInt();
                System.out.println(elementIndex + "," + elementValue);
                matrix[elementIndex] = elementValue;
                System.out.println(matrix[elementIndex]);
            }
            System.out.println(matrixSize + "," + Arrays.toString(matrix));
        }
    }
}