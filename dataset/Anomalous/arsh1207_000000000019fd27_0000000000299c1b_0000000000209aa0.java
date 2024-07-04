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

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = i + 1;
                }

                boolean found = false;
                Solution obj = new Solution();
                List<List<Integer>> permutations = obj.permute(arr);

                int[][] matrix = new int[n][n];
                for (List<Integer> perm : permutations) {
                    matrix = obj.constructLatinSquare(permutations, n);

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
                        for (int num : row) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int[][] constructLatinSquare(List<List<Integer>> permutations, int n) {
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (List<Integer> perm : permutations) {
                boolean isValid = true;

                for (int j = 0; j < i; j++) {
                    for (int p = 0; p < n; p++) {
                        if (matrix[j][p] == perm.get(p)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                }

                if (isValid) {
                    for (int p = 0; p < n; p++) {
                        matrix[i][p] = perm.get(p);
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

            for (List<Integer> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    List<Integer> temp = new ArrayList<>(l);
                    temp.add(j, num);
                    current.add(temp);
                }
            }
            result = current;
        }

        return result;
    }
}