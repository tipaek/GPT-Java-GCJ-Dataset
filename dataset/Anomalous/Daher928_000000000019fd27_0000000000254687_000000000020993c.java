import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    static void vestigium(int[][] matrix, int size) {
        if (size <= 0 || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int trace = calculateTrace(matrix, size);
        int rowRepeats = countRowRepeats(matrix, size);
        int colRepeats = countColRepeats(matrix, size);

        System.out.println(trace + " " + rowRepeats + " " + colRepeats);
    }

    static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    static int countRowRepeats(int[][] matrix, int size) {
        int repeats = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!set.add(matrix[i][j])) {
                    repeats++;
                    break;
                }
            }
        }
        return repeats;
    }

    static int countColRepeats(int[][] matrix, int size) {
        int repeats = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!set.add(matrix[j][i])) {
                    repeats++;
                    break;
                }
            }
        }
        return repeats;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                String[] rowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(rowItems[j]);
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            vestigium(matrix, size);
        }

        scanner.close();
    }
}