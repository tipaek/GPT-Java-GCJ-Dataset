import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * Created by HelenHan on 3/6/20.
 */
public class Solution {

    public static int[] solve(int[][] matrix, int N) {
        if (matrix == null || N < 2 || matrix.length != N || matrix[0].length != N)
            return new int[]{0, 0, 0};
        //time  N2  and space N2..... this is brute force...?
        int k = 0;
        int r = 0;
        int c = 0;
        int sum = (1 + N) * N / 2;
        LinkedList<HashSet<Integer>> Row = new LinkedList<>();
        LinkedList<HashSet<Integer>> Col = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(i);
        }
        for (int i = 0; i < N; i++) {
            Row.add((HashSet<Integer>) set.clone());
            Col.add((HashSet<Integer>) set.clone());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) k += matrix[i][j];
                if (Row.get(i).contains(matrix[i][j]))
                    Row.get(i).remove(matrix[i][j]);
                if (Col.get(j).contains(matrix[i][j]))
                    Col.get(j).remove(matrix[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            if (!Row.get(i).isEmpty()) r++;
            if (!Col.get(i).isEmpty()) c++;
        }
        return new int[]{k, r, c};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] t = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int T = Integer.parseInt(t[0]);

        for (int j = 1; j <= T; j++) {
            String[] n = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int N = Integer.parseInt(n[0]);

            int[][] matrix = new int[N][N];
            for (int r = 0; r < N; r++) {
                String[] Items = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                for (int c = 0; c < N; c++) {
                    int temp = Integer.parseInt(Items[c]);
                    matrix[r][c] = temp;
                }
            }

            int[] res = solve(matrix, N);
            System.out.println("Case #" + j + ": " + res[0] + " " + res[1] + " " + res[2]);
        }

        bufferedReader.close();
    }
}