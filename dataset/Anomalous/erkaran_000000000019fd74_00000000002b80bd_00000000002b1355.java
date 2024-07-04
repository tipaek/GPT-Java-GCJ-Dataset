import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int testCase = 1; testCase <= t; testCase++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();

            if (rows == 1 && cols == 1) {
                System.out.println("Case #" + testCase + ": " + sc.nextInt());
            } else if (rows == 1) {
                printSum(sc, cols, testCase);
            } else if (cols == 1) {
                printSum(sc, rows, testCase);
            } else {
                int[][] matrix = new int[rows][cols];
                int totalSum = 0;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = sc.nextInt();
                        totalSum += matrix[i][j];
                    }
                }

                int evenSum = 0;
                int oddSum = 0;
                int count = 1;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (count % 2 == 0) {
                            evenSum += matrix[i][j];
                        } else {
                            oddSum += matrix[i][j];
                        }
                        count++;
                    }
                }

                totalSum += Math.max(oddSum, evenSum);
                System.out.println("Case #" + testCase + ": " + totalSum);
            }
        }
    }

    public static void printSum(Scanner sc, int size, int testCase) {
        int[] array = new int[size];
        int totalSum = 0;

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
            totalSum += array[i];
        }

        Arrays.sort(array);

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j++) {
                totalSum += array[j];
            }
        }

        System.out.println("Case #" + testCase + ": " + totalSum);
    }
}