import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int matSize;
        for (int i = 1; i <= T; i++) {
            matSize = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[matSize][matSize];
            for (int j = 0; j < matSize; j++) {
                String[] split = (br.readLine().trim()).split("\\ ");
                for (int k = 0; k < matSize; k++)
                    matrix[j][k] = Integer.parseInt(split[k]);
            }
            System.out.println("Case #" + i + ": " + trace(matSize, matrix) + " " + rows(matSize, matrix)+ " " + cols(matSize, matrix));
        }
    }

    public static int trace(int size, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int rows(int size, int[][] matrix) {
        Set<String> s1 = new HashSet<String>();
        int rows = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!s1.add(String.valueOf(matrix[i][j]))) {
                    rows++;
                    s1.clear();
                    break;
                }
            }
            s1.clear();
        }
        return rows;
    }

    public static int cols(int size, int[][] matrix) {
        Set<String> s1 = new HashSet<String>();
        int cols = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!s1.add(String.valueOf(matrix[j][i]))) {
                    cols++;
                    s1.clear();
                    break;
                }
            }
            s1.clear();
        }
        return cols;
    }
}