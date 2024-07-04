
import java.util.*;
import java.io.*;

public class Solution {

    public static Map<String, int[][]> solutions = new HashMap<>();
    public static Map<Integer, Boolean> nAnalized = new HashMap<>();
    public static Map<Integer, ArrayList<ArrayList<Integer>>> permutationsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[] line = new int[N];
            for (int i = 1; i <= N; i++) {
                line[i - 1] = i;
            }
            ArrayList<ArrayList<Integer>> permutations;
            if (permutationsMap.containsKey(N)) {
                permutations = permutationsMap.get(N);
            } else {
                permutations = permute(line);
                permutationsMap.put(N, permutations);
            }
            int result[][] = null;
            if (!nAnalized.containsKey(N)) {
                testEveryCombinationFor(N, permutations, 0, new int[N][N]);
                nAnalized.put(N, true);
            }
            if (solutions.containsKey(N + "_" + K)) {
                result = solutions.get(N + "_" + K);
            }
            if (result != null) {
                System.out.println("Case #" + c + ": POSSIBLE");
                printMatrix(result);
            } else {
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            }
        }
    }

    public static int[][] testEveryCombinationFor(int N, ArrayList<ArrayList<Integer>> permutations, int position, int acumulative[][]) {
        int[][] copy = copy(acumulative);
        for (ArrayList<Integer> permutation : permutations) {
            if (position < N - 1) {
                copy[position] = toLine(permutation);
                if (isLatinMatrix(transpose(copy))) {
                    testEveryCombinationFor(N, permutations, position + 1, copy);
                }
            } else {
                copy[position] = toLine(permutation);
                if (isLatinMatrix(transpose(copy))) {
                    saveSolution(copy, N);
                }
            }
        }
        return null;
    }

    private static boolean isLatinMatrix(int[][] acumulative) {
        for (int i = 0; i < acumulative.length; i++) {
            Map<Integer, Boolean> numbers = new HashMap<>();
            for (int j = 0; j < acumulative.length; j++) {
                Integer number = acumulative[i][j];
                if (numbers.containsKey(number)) {
                    return false;
                }
                if (number != 0) {
                    numbers.put(number, Boolean.TRUE);
                }
            }
        }
        return true;
    }

    private static int[] toLine(ArrayList<Integer> permutation) {
        int result[] = new int[permutation.size()];
        for (int i = 0; i < permutation.size(); i++) {
            result[i] = permutation.get(i);
        }
        return result;
    }

    private static void saveSolution(int[][] solution, int N) {
        int sum = 0;
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                if (i == j) {
                    sum += solution[i][j];
                }
            }
        }
        String key = N + "_" + sum;
        solutions.put(key, copy(solution));
    }

    private static int[][] copy(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String line = "";
            for (int j = 0; j < matrix[i].length; j++) {
                line += matrix[i][j] + " ";
            }
            System.out.println(line.trim());
        }
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, num[i]);
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }

}
