import java.util.*;
import java.io.*;

public class Solution {

    public static boolean hasDuplicate(int[] array, int length) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!seen.add(array[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicate(List<Integer> list, int size) {
        Set<Integer> seen = new HashSet<>(list);
        return seen.size() != size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        try {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int trace = 0;
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                int rowDuplicates = 0, colDuplicates = 0;

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                for (int[] row : matrix) {
                    if (hasDuplicate(row, size)) {
                        rowDuplicates++;
                    }
                }

                for (int col = 0; col < size; col++) {
                    List<Integer> column = new ArrayList<>();
                    for (int row = 0; row < size; row++) {
                        column.add(matrix[row][col]);
                    }
                    if (hasDuplicate(column, size)) {
                        colDuplicates++;
                    }
                }

                System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}