import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; ++i) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int targetSum = Integer.parseInt(input[1]);
            results = new ArrayList<>();
            findSolutions(n, targetSum);
            if (results.isEmpty()) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                StringBuilder output = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        output.append(results.get(j).get(k));
                        if (k < n - 1) {
                            output.append(" ");
                        } else {
                            output.append("\n");
                        }
                    }
                }
                System.out.print(output.toString());
            }
        }
    }

    private static void findSolutions(int n, int targetSum) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(n, new int[n], new ArrayList<>(), permutations);
        List<List<Integer>> currentResult = new ArrayList<>();
        searchResults(new int[permutations.size()], n, targetSum, permutations, currentResult);
    }

    private static void generatePermutations(int n, int[] visited, List<Integer> current, List<List<Integer>> permutations) {
        if (current.size() == n) {
            permutations.add(new ArrayList<>(current));
        } else {
            for (int i = 1; i <= n; i++) {
                if (visited[i - 1] == 0) {
                    visited[i - 1] = 1;
                    current.add(i);
                    generatePermutations(n, visited, current, permutations);
                    visited[i - 1] = 0;
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    private static void searchResults(int[] visited, int n, int targetSum, List<List<Integer>> permutations, List<List<Integer>> currentResult) {
        if (currentResult.size() == n) {
            if (isValidSolution(currentResult, n, targetSum)) {
                results.addAll(currentResult);
            }
        } else {
            for (int i = 0; i < permutations.size() && results.isEmpty(); i++) {
                if (visited[i] == 0) {
                    currentResult.add(permutations.get(i));
                    visited[i] = 1;
                    searchResults(visited, n, targetSum, permutations, currentResult);
                    currentResult.remove(currentResult.size() - 1);
                    visited[i] = 0;
                }
            }
        }
    }

    private static boolean isValidSolution(List<List<Integer>> currentResult, int n, int targetSum) {
        int[][] columnCheck = new int[n][n];
        int sumDiagonal = 0;
        for (int i = 0; i < currentResult.size(); i++) {
            for (int j = 0; j < currentResult.get(i).size(); j++) {
                if (i == j) {
                    sumDiagonal += currentResult.get(i).get(j);
                }
                if (columnCheck[j][currentResult.get(i).get(j) - 1] == 1) {
                    return false;
                }
                columnCheck[j][currentResult.get(i).get(j) - 1] = 1;
            }
        }
        return targetSum == sumDiagonal;
    }
}