import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = IntStream.range(0, size)
                                .map(i -> matrix[i][i])
                                .sum();

            int rowRepeats = (int) IntStream.range(0, size)
                                            .filter(i -> Arrays.stream(matrix[i]).distinct().count() < size)
                                            .count();

            int colRepeats = (int) IntStream.range(0, size)
                                            .filter(j -> IntStream.range(0, size).map(i -> matrix[i][j]).distinct().count() < size)
                                            .count();

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}