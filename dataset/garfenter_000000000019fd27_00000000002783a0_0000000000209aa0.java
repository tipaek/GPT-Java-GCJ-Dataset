
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int c = 1; c <= cases; ++c) {
            int N = in.nextInt();
            int K = in.nextInt();
            boolean solved = false;
            int[] line = new int[N];
            for (int i = 1; i <= N; i++) {
                line[i - 1] = i;
            }
            ArrayList<ArrayList<Integer>> permutation = permute(line);
            for (ArrayList<Integer> array : permutation) {
                int[][] result = solveFor(array, N);
                for (ArrayList<Integer> everyRow : permutation) {
                    int[][] newResult = new int[N][N];
                    for (int i = 0; i < N; i++) {
                        newResult[i] = result[everyRow.get(i) - 1];
                    }
                    if (verify(newResult, K)) {
                        solved = true;
                        System.out.println("Case #" + c + ": POSSIBLE");
                        printMatrix(newResult);
                        break;
                    }
                }
                if (solved) {
                    solved = true;
                    break;
                }
            }
            if (!solved) {
                System.out.println("Case #" + c + ": IMPOSSIBLE");
            }

        }
    }

    public static boolean verify(int[][] solution, int K) {
        int sum = 0;
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[i].length; j++) {
                if (i == j) {
                    sum += solution[i][j];
                }
            }
        }
        return sum == K;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String line = "";
            for (int j = 0; j < matrix[i].length; j++) {
                line += matrix[i][j] + " ";
            }
            System.out.println(line.trim());
        }
    }

    public static int[][] solveFor(ArrayList<Integer> values, int N) {
        int[][] result = new int[N][N];
        int number = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = values.get(number);
                number++;
                number = number >= N ? 0 : number;
            }
            number--;
            number = number <= 0 ? N - 1 : number;
        }
        return result;
    }

    public static void combinations2(int[] arr, int len, int startPosition, int[] result) {
        for (int i = startPosition; i <= arr.length - len; i++) {
            result[result.length - len] = arr[i];
            combinations2(arr, len - 1, i + 1, result);
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
