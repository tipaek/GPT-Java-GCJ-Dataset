import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 0; t < testCases; t++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                int[][] matrix = new int[n][n];
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }
                boolean found = false;
                Solution obj = new Solution();
                List<List<Integer>> permutations = obj.permute(arr);
                List<List<List<Integer>>> combinations = obj.getCombinations(permutations, n);

                for (List<List<Integer>> combination : combinations) {
                    int[][] tempMatrix = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            tempMatrix[i][j] = combination.get(i).get(j);
                        }
                    }
                    if (!obj.isLatinSquare(tempMatrix, n)) {
                        int trace = 0;
                        for (int i = 0; i < n; i++) {
                            trace += tempMatrix[i][i];
                        }
                        if (trace == k) {
                            matrix = tempMatrix;
                            found = true;
                            break;
                        }
                    }
                }

                if (found) {
                    System.out.println("Case #" + (t + 1) + ": POSSIBLE");
                    for (int[] row : matrix) {
                        for (int value : row) {
                            System.out.print(value + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<List<List<Integer>>> getCombinations(List<List<Integer>> arr, int r) {
        List<List<List<Integer>>> result = new ArrayList<>();
        combinationUtil(arr, arr.size(), r, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private void combinationUtil(List<List<Integer>> arr, int n, int r, int index, 
                                 List<List<Integer>> data, int i, List<List<List<Integer>>> result) {
        if (index == r) {
            result.add(new ArrayList<>(data));
            return;
        }

        if (i >= n) return;

        data.add(index, arr.get(i));
        combinationUtil(arr, n, r, index + 1, data, i + 1, result);
        combinationUtil(arr, n, r, index, data, i + 1, result);
    }

    public boolean isLatinSquare(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j]) || !colSet.add(matrix[j][i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> temp = new ArrayList<>(l);
                    temp.add(j, num[i]);
                    current.add(temp);
                }
            }
            result = current;
        }

        return result;
    }
}