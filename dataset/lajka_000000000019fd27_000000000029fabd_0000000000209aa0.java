import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String line = in.nextLine();
            String matrixData[] = line.split(" ");
            Integer matrixSize = Integer.parseInt(matrixData[0]);
            Integer matrixTrace = Integer.parseInt(matrixData[1]);

            List<Integer> range = IntStream.rangeClosed(1, matrixSize).mapToObj(num -> Integer.valueOf(num)).collect(Collectors.toList());
            Integer maxSum = range.stream()
                    .reduce(0, (a, b) -> a + b);

            if (maxSum < matrixTrace) {
                System.out.println("Case #" + testCase + ": " + "IMPOSSIBLE");
            } else {
                Integer[][] matrix = new Integer[matrixSize][matrixSize];
                Integer calculatedTrace = 0;
                for (int row = 0; row < matrixSize; row++) {
                    for (int col = 0; col < matrixSize; col++) {
                        if (row == 0) {
                            // set biggest number on the beginning and arrange others from min to max
                            if (col == 0) {
                                matrix[row][col] = matrixSize;
                            } else {
                                matrix[row][col] = range.get(col - 1);
                            }
                        } else {
                            // for the remaining rows, move the first element to last column and arrange others
                            if (col < matrixSize - 1) {
                                matrix[row][col] = matrix[row - 1][col + 1];
                            } else {
                                matrix[row][col] = matrix[row - 1][0];
                            }
                        }

                        // calculate trace
                        if (row == col) {
                            calculatedTrace += matrix[row][col];
                        }
                    }
                }

                if (calculatedTrace.equals(matrixTrace)) {
                    System.out.println("Case #" + testCase + ": " + "POSSIBLE");
                    for (int row = 0; row < matrixSize; row++) {
                        for (int col = 0; col < matrixSize; col++) {
                            if (col < matrixSize - 1) {
                                System.out.print(matrix[row][col] + " ");
                            } else {
                                System.out.print(matrix[row][col]);
                            }
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Case #" + testCase + ": " + "IMPOSSIBLE");
                }
            }
        }
    }
}
