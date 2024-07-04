import java.io.*;
import java.util.*;

public class Solution {

    static int[] order;
    static ArrayList<Integer[]> permutations;

    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                Integer[] elements = new Integer[n];
                Integer[] tempElements = new Integer[n];
                for (int i = 0; i < n; i++) elements[i] = i;
                permutations = new ArrayList<>();
                generatePermutations(elements, permutations, tempElements, 0, false);

                String result = "IMPOSSIBLE";

                if (n <= 6) {
                    order = new int[n];
                    int[][] matrix = findMatrix(0, n, k);
                    if (matrix != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("POSSIBLE\n");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                sb.append(matrix[i][j]);
                                if (j < n - 1) sb.append(" ");
                                else if (i < n - 1) sb.append("\n");
                            }
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

    static int[][] findMatrix(int level, int n, int k) {
        int[][] matrix = null;
        if (level < n) {
            for (int i = 0; i < n; i++) {
                boolean used = false;
                for (int j = 0; j < level; j++) {
                    if (order[j] == i) {
                        used = true;
                        break;
                    }
                }
                if (!used) {
                    order[level] = i;
                    matrix = findMatrix(level + 1, n, k);
                    if (matrix != null) break;
                }
            }
        } else {
            for (Integer[] permutation : permutations) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += permutation[(n - order[i] + i) % n] + 1;
                }

                if (sum == k) {
                    matrix = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            matrix[i][j] = permutation[(n - order[i] + j) % n] + 1;
                        }
                    }
                }
            }
        }

        return matrix;
    }

    static <T> void generatePermutations(T[] elements, List<T[]> permutations, T[] permutation, int level, boolean noDuplicates) {
        Set<T> usedElements = noDuplicates ? new HashSet<>() : null;
        if (level < permutation.length) {
            for (int i = 0; i < elements.length; i++) {
                T element = elements[i];
                if (element != null) {
                    if (usedElements != null && usedElements.contains(element)) continue;
                    if (usedElements != null) usedElements.add(element);

                    T[] newPermutation = permutation.clone();
                    newPermutation[level] = element;
                    elements[i] = null;
                    generatePermutations(elements, permutations, newPermutation, level + 1, noDuplicates);
                    elements[i] = element;
                }
            }
        } else {
            permutations.add(permutation);
        }
    }
}