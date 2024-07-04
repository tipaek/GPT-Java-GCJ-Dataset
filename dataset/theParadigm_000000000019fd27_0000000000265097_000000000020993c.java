import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int matrix [][];
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            matrix = new int[n][n];
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    int m = in.nextInt();
                    matrix[r][c] = m;
                }
            }
            final ArrayList<Integer> process = process(matrix, n);
            System.out.println("Case #"+i+": "+process.get(2)+" "+process.get(0)+" "+process.get(1));
        }
    }
     private static ArrayList<Integer> process(int[][] matrix, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        //check row;
        int countRows= 0;
        for(int r = 0; r < matrix.length; r++){
            int [] a = matrix[r];
            countRows += calculate(a, n);
        }
        result.add(countRows);
        int countCol= 0;
        for(int r = 0; r < matrix.length; r++){
            int [] a = new int[matrix[r].length];
            for (int i = 0; i < matrix[r].length; i++) {
                a[i] = matrix[i][r];
            }

            countCol += calculate(a, n);
        }
        result.add(countCol);

        //calc diagonal
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        result.add(sum);

        return result;
    }

    private static int calculate(int[] a, int n) {
        int sum = 0;
        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        if(set.size() != n)
            return 1;
        return 0;
    }
}
