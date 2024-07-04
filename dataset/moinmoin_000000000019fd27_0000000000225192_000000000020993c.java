import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int noOfTestCases = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testCaseNumber = 0; testCaseNumber < noOfTestCases; testCaseNumber++) {
            int arraySize = scanner.nextInt();

            int[][] inputArray = new int[arraySize][arraySize];

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    inputArray[i][j] = scanner.nextInt();
                }
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            }
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            System.out.println("Case #" + (testCaseNumber+1) + ": "+ solve(arraySize, inputArray));
        }

        scanner.close();
    }

    public static String solve(int arraySize, int[][] inputArray) {
        int sum = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < arraySize; i++) {
            sum+=inputArray[i][i];
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j=0; j < arraySize; j++) {
                rowSet.add(inputArray[i][j]);
                colSet.add(inputArray[j][i]);
            }
            if (rowSet.size() != arraySize) {
                row++;
            }
            if (colSet.size() != arraySize) {
                col++;
            }
        }
        return sum + " " + row + " " + col;
    }

}
