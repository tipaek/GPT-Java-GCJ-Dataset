import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 0; t < testCases; t++) {
                String[] line = br.readLine().split(" ");
                int n = Integer.parseInt(line[0]);
                int k = Integer.parseInt(line[1]);
                int[][] matrix = new int[n][n];
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }
                boolean found = false;
                Solution obj = new Solution();
                List<List<Integer>> permutations = obj.permute(arr);
                List<List<List<Integer>>> combinations = new ArrayList<>();
                obj.combinationUtil(permutations, n, new ArrayList<>(), combinations);

                for (List<List<Integer>> combination : combinations) {
                    int[][] tempMatrix = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            tempMatrix[i][j] = combination.get(i).get(j);
                        }
                    }
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

                System.out.println("Case #" + (t + 1) + ": " + (found ? "POSSIBLE" : "IMPOSSIBLE"));
                if (found) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void combinationUtil(List<List<Integer>> permutations, int n, List<List<Integer>> current, List<List<List<Integer>>> result) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (List<Integer> permutation : permutations) {
            current.add(permutation);
            combinationUtil(permutations, n, current, result);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> current = new ArrayList<>();
            for (List<Integer> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(j, num);
                    current.add(temp);
                }
            }
            result = current;
        }
        return result;
    }
}