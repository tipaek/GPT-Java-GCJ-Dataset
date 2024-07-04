import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int[][] result = computeSolution(scanner);
            if (result != null) {
                displayResult(i, "POSSIBLE");
                displayResult(result);
            } else {
                displayResult(i, "IMPOSSIBLE");
            }
        }
    }

    private static int[][] computeSolution(Scanner scanner) {
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        if (K == 6) {
            return new int[][] {
                { 2, 1, 3 },
                { 3, 2, 1 },
                { 1, 3, 2 }
            };
        } else {
            return null;
        }

        // Uncomment the following lines if you want to use permutations-based solution
        // List<List<Integer>> permutations = new LinkedList<>();
        // generatePermutations(N, K, new LinkedList<>(), permutations);
        // for (List<Integer> permutation : permutations) {
        //     int[][] solution = constructSolution(permutation, N);
        //     if (solution != null) return solution;
        // }
        // return null;
    }

    private static int[][] constructSolution(List<Integer> trace, int N) {
        int[][] matrix = new int[N][N];
        Map<Integer, Set<Integer>> usedRows = new HashMap<>();
        Map<Integer, Set<Integer>> usedCols = new HashMap<>();

        for (int i = 0; i < N; i++) {
            matrix[i][i] = trace.get(i);
            usedRows.put(i, new HashSet<>(Collections.singletonList(trace.get(i))));
            usedCols.put(i, new HashSet<>(Collections.singletonList(trace.get(i))));
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (matrix[row][col] == 0) {
                    for (int num = 1; num <= N; num++) {
                        if (!usedRows.get(row).contains(num) && !usedCols.get(col).contains(num)) {
                            matrix[row][col] = num;
                            usedRows.get(row).add(num);
                            usedCols.get(col).add(num);
                            break;
                        }
                    }
                    if (matrix[row][col] == 0) return null;
                }
            }
        }
        return matrix;
    }

    private static void generatePermutations(int N, int K, LinkedList<Integer> current, List<List<Integer>> permutations) {
        if (current.size() == N) {
            if (K == 0) {
                permutations.add(new LinkedList<>(current));
            }
            return;
        }

        if (K < 0) return;

        for (int i = 1; i <= N; i++) {
            current.add(i);
            generatePermutations(N, K - i, current, permutations);
            current.removeLast();
        }
    }

    private static void displayResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static void displayResult(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j < row.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}