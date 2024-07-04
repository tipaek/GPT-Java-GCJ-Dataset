import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 1; t <= testCases; t++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                
                int[][] matrix = new int[n][n];
                int[] elements = new int[n];
                for (int i = 0; i < n; i++) {
                    elements[i] = i + 1;
                }
                
                boolean found = false;
                List<List<Integer>> permutations = generatePermutations(elements);
                
                for (List<Integer> perm : permutations) {
                    matrix = constructLatinSquare(permutations, n);
                    int trace = calculateTrace(matrix, n);
                    
                    if (trace == k) {
                        found = true;
                        break;
                    }
                    
                    Collections.rotate(permutations, 1);
                }
                
                System.out.println("Case #" + t + ": " + (found ? "POSSIBLE" : "IMPOSSIBLE"));
                if (found) {
                    printMatrix(matrix, n);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int[][] constructLatinSquare(List<List<Integer>> permutations, int n) {
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

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static List<List<Integer>> generatePermutations(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int value : num) {
            List<List<Integer>> current = new ArrayList<>();

            for (List<Integer> perm : result) {
                for (int j = 0; j <= perm.size(); j++) {
                    List<Integer> temp = new ArrayList<>(perm);
                    temp.add(j, value);
                    current.add(temp);
                }
            }
            result = current;
        }

        return result;
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}