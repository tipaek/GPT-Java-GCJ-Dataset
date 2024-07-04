import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(sc.nextLine());
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                String[] input = sc.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.valueOf(input[k]);
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", i + 1, getTrace(matrix), repeatedRows(matrix), repeatedCols(matrix));
        }
    }

    public static int getTrace(int[][] matrix) {
        int N = matrix.length;
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int repeatedCols(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> nums = new HashSet<Integer>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (nums.contains(matrix[j][i])) {
                    result++;
                    break;
                } else {
                    nums.add(matrix[j][i]);
                }
            }
        }
        return result;
    }

    public static int repeatedRows(int[][] matrix) {
        int result = 0;
        for (int[] row : matrix) {
            Set<Integer> nums = new HashSet<Integer>();
            for (int el : row) {
                if (nums.contains(el)) {
                    result++;
                    break;
                } else {
                    nums.add(el);
                }
            }
        }
        return result;
    }
}
