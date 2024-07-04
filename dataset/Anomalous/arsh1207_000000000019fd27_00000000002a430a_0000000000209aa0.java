import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 0; t < testCases; t++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }

                Solution solution = new Solution();
                List<List<Integer>> permutations = solution.permute(arr);

                List<List<List<Integer>>> combinations = solution.combinationUtil(permutations, n);

                boolean found = false;
                int[][] matrix = new int[n][n];
                for (List<List<Integer>> combination : combinations) {
                    matrix = solution.latinSquare(combination, n);
                    int trace = 0;
                    for (int i = 0; i < n; i++) {
                        trace += matrix[i][i];
                    }
                    if (trace == k) {
                        found = true;
                        break;
                    }
                }

                System.out.println("Case #" + (t + 1) + ": " + (found ? "POSSIBLE" : "IMPOSSIBLE"));
                if (found) {
                    for (int[] row : matrix) {
                        for (int element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<List<Integer>>> combinationUtil(List<List<Integer>> permutations, int n) {
        List<List<List<Integer>>> result = new ArrayList<>();
        combinationUtil(permutations, n, new ArrayList<>(), 0, result);
        return result;
    }

    private void combinationUtil(List<List<Integer>> permutations, int n, List<List<Integer>> current, int index, List<List<List<Integer>>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index >= permutations.size()) {
            return;
        }
        current.add(permutations.get(index));
        combinationUtil(permutations, n, current, index + 1, result);
        current.remove(current.size() - 1);
        combinationUtil(permutations, n, current, index + 1, result);
    }

    public int[][] latinSquare(List<List<Integer>> permutations, int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (List<Integer> permutation : permutations) {
                boolean valid = true;
                for (int j = 0; j < i; j++) {
                    for (int p = 0; p < n; p++) {
                        if (matrix[j][p] == permutation.get(p)) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) break;
                }
                if (valid) {
                    for (int p = 0; p < n; p++) {
                        matrix[i][p] = permutation.get(p);
                    }
                    break;
                }
            }
        }
        return matrix;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> permutation : result) {
                for (int j = 0; j <= permutation.size(); j++) {
                    List<Integer> temp = new ArrayList<>(permutation);
                    temp.add(j, num);
                    current.add(temp);
                }
            }
            result = current;
        }

        return result;
    }
}