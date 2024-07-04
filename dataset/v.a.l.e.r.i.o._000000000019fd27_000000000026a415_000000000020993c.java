
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {


    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)));
        //Scanner in = new Scanner(new java.io.FileInputStream("vestigium.in"));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt(); // size matrix
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            System.out.println("Case #" + t + ": " + compute(N, matrix));
        }
        in.close();
    }


    public static String compute(int N,
                                 int[][] matrix) {
        String res = "";
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;
        Set<Integer> setR = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        for (int i = 0; i < N; i++) {
            trace = trace +
                    matrix[i][i];
            setR.clear();
            setC.clear();
            for (int j = 0; j < N; j++) {
                setC.add(matrix[j][i]);
                if (setC.size() != j + 1) {
                    repeatedColumns++;
                    break;
                }
            }

            for (int j = 0; j < N; j++) {
                setR.add(matrix[i][j]);
                if (setR.size() != j + 1) {
                    repeatedRows++;
                    break;
                }
            }

        }
        return trace + " " + repeatedRows + " " + repeatedColumns;
    }
}
