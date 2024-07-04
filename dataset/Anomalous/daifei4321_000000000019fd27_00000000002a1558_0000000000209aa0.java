import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] rows = generateRows(n);
            int[] validCombination = findValidCombination(rows, k - n);
            
            if (validCombination != null) {
                System.out.println("CASE #" + (t + 1) + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    int[] row = rows[validCombination[i]];
                    for (int j = 0; j < n; j++) {
                        if (j > 0) {
                            System.out.print(' ');
                        }
                        System.out.print(row[j] + 1);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("CASE #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    private static int[] findValidCombination(int[][] rows, int k) {
        int n = rows[0].length;
        return findCombination(rows, k, 0, new int[n], new boolean[rows.length]);
    }

    private static int[] findCombination(int[][] rows, int k, int index, int[] combination, boolean[] used) {
        int n = rows[0].length;
        for (int i = 0; i < rows.length; i++) {
            if (used[i]) continue;
            combination[index] = i;
            if (index == n - 1) {
                if (isValidCombination(combination, rows, k)) {
                    return combination;
                }
                continue;
            }
            used[i] = true;
            int[] result = findCombination(rows, k, index + 1, combination, used);
            if (result != null) {
                return result;
            }
            used[i] = false;
        }
        return null;
    }

    private static boolean isValidCombination(int[] combination, int[][] rows, int k) {
        int n = combination.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += rows[combination[i]][i];
        }
        if (sum != k) {
            return false;
        }
        
        boolean[] used = new boolean[n];
        for (int col = 0; col < n; col++) {
            Arrays.fill(used, false);
            for (int row = 0; row < n; row++) {
                int value = rows[combination[row]][col];
                if (used[value]) {
                    return false;
                }
                used[value] = true;
            }
        }
        return true;
    }

    private static int[][] generateRows(int n) {
        List<int[]> rows = new ArrayList<>(factorial(n));
        generatePermutations(n, rows, new int[n], new boolean[n], 0);
        return rows.toArray(new int[0][]);
    }

    private static void generatePermutations(int n, List<int[]> rows, int[] buffer, boolean[] used, int index) {
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            buffer[index] = i;
            if (index + 1 < n) {
                used[i] = true;
                generatePermutations(n, rows, buffer, used, index + 1);
                used[i] = false;
            } else {
                rows.add(Arrays.copyOf(buffer, n));
            }
        }
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}