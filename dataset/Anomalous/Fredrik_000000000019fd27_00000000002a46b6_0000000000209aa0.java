import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int[][] solution = findSolution(scanner);
            if (solution != null) {
                printResult(i, "POSSIBLE");
                printMatrix(solution);
            } else {
                printResult(i, "IMPOSSIBLE");
            }
        }
    }

    private static int[][] findSolution(Scanner scanner) {
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        List<List<Integer>> permutations = new LinkedList<>();
        generatePermutations(N, K, new LinkedList<>(), permutations);

        for (List<Integer> permutation : permutations) {
            int[][] solution = constructSolution(permutation, N);
            if (solution != null) return solution;
        }
        return null;
    }

    private static int[][] constructSolution(List<Integer> trace, int N) {
        int[][] matrix = new int[N][N];
        Map<Integer, Set<Integer>> rowUsage = new HashMap<>();
        Map<Integer, Set<Integer>> colUsage = new HashMap<>();

        for (int i = 0; i < N; i++) {
            matrix[i][i] = trace.get(i);
            rowUsage.put(i, new HashSet<>(Collections.singleton(trace.get(i))));
            colUsage.put(i, new HashSet<>(Collections.singleton(trace.get(i))));
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (matrix[row][col] != 0) continue;

                for (int num = 1; num <= N; num++) {
                    if (!rowUsage.get(row).contains(num) && !colUsage.get(col).contains(num)) {
                        matrix[row][col] = num;
                        rowUsage.get(row).add(num);
                        colUsage.get(col).add(num);
                        break;
                    }
                }

                if (matrix[row][col] == 0) return null;
            }
        }

        return matrix;
    }

    private static void generatePermutations(int N, int K, LinkedList<Integer> current, List<List<Integer>> permutations) {
        if (current.size() == N) {
            if (K == 0) permutations.add(new LinkedList<>(current));
            return;
        }

        if (K < 0) return;

        for (int i = 1; i <= N; i++) {
            current.add(i);
            generatePermutations(N, K - i, current, permutations);
            current.removeLast();
        }
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                sb.append(row[i]);
                if (i < row.length - 1) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}