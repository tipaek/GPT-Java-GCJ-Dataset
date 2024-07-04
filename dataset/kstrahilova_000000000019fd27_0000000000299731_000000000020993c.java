import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int trace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public int rows(int[][] matrix) {
        int n = matrix.length;
        List<Integer> numbersRow;
        int count = 0;
        int[] sequence = IntStream.range(1, n+1).toArray();

        for (int i = 0; i < n; i++) {
            numbersRow = Arrays.stream(sequence).boxed().collect(Collectors.toList());
            for (int j = 0; j < n; j++){
                if (numbersRow.contains(Integer.valueOf(matrix[i][j]))) {
                    numbersRow.remove(Integer.valueOf(matrix[i][j]));
                } else {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

    public int columns(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        List<Integer> numbersCol;
        int[] sequence = IntStream.range(1, n+1).toArray();

        for (int i = 0; i < n; i++) {
            numbersCol = Arrays.stream(sequence).boxed().collect(Collectors.toList());
            for (int j = 0; j < n; j++){
                if (numbersCol.contains(Integer.valueOf(matrix[j][i]))) {
                    numbersCol.remove(Integer.valueOf(matrix[j][i]));
                } else {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Solution instance = new Solution();
        int k;
        int r;
        int c;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // #test cases Scanner has functions to read ints, longs, strings, chars, etc.
        //for each test case do
        for (int s = 0; s < t; s++) {
            int n = in.nextInt(); //size of first input matrix
            int[][] input = new int[n][n];
            //fill in matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = in.nextInt();
                    input[i][j] = num;
                }
            }
            k = instance.trace(input);
            r = instance.rows(input);
            c = instance.columns(input);
            System.out.println("Case #" + s + ": " + k + " " + r + " " + c);
        }


    }
}
