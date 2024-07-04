import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    private static int[] order;
    private static final List<Integer[]> permutations = new ArrayList<>();

    public static void main(String[] args) {
        try (BufferedReader ibr = new BufferedReader(new InputStreamReader(System.in));
             Scanner sc = new Scanner(ibr)) {

            sc.useLocale(Locale.US);
            int testCaseCount = sc.nextInt();

            for (int t = 1; t <= testCaseCount; t++) {
                int n = sc.nextInt();
                int k = sc.nextInt();

                Integer[] elements = new Integer[n];
                for (int i = 0; i < n; i++) elements[i] = i;
                generatePermutations(elements, new Integer[n], 0);

                String result = "IMPOSSIBLE";

                if (n <= 5) {
                    order = new int[n];
                    int[][] matrix = findMatrix(0, n, k);
                    if (matrix != null) {
                        StringBuilder sb = new StringBuilder("POSSIBLE\n");
                        for (int[] row : matrix) {
                            for (int j = 0; j < n; j++) {
                                sb.append(row[j]);
                                if (j < n - 1) sb.append(" ");
                            }
                            sb.append("\n");
                        }
                        result = sb.toString();
                    }
                }

                System.out.printf("Case #%d: %s%n", t, result);
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exception
        }
    }

    private static int[][] findMatrix(int level, int n, int k) {
        if (level < n) {
            for (int i = 0; i < n; i++) {
                if (isUsed(i, level)) continue;
                order[level] = i;
                int[][] matrix = findMatrix(level + 1, n, k);
                if (matrix != null) return matrix;
            }
        } else {
            for (Integer[] permutation : permutations) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += permutation[(n - order[i] + i) % n] + 1;
                }
                if (sum == k) {
                    return createMatrix(n, permutation);
                }
            }
        }
        return null;
    }

    private static boolean isUsed(int value, int level) {
        for (int j = 0; j < level; j++) {
            if (order[j] == value) return true;
        }
        return false;
    }

    private static int[][] createMatrix(int n, Integer[] permutation) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = permutation[(n - order[i] + j) % n] + 1;
            }
        }
        return matrix;
    }

    private static <T> void generatePermutations(T[] elements, T[] currentPermutation, int level) {
        if (level == currentPermutation.length) {
            permutations.add(currentPermutation.clone());
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                T element = elements[i];
                elements[i] = null;
                currentPermutation[level] = element;
                generatePermutations(elements, currentPermutation, level + 1);
                elements[i] = element;
            }
        }
    }
}