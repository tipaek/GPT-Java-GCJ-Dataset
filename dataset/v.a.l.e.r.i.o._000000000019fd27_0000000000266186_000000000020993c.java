import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {


    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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
            Vestigium v = new Vestigium(N, matrix);
            System.out.println("Case #" + t + ": " + v.compute());

        }

        in.close();
    }


    int N;
    int[][] matrix;
    StringBuilder result;

    public Vestigium(int N, int[][] matrix) {
        this.N = N;
        this.matrix = matrix;
        result = new StringBuilder();
    }


    public String compute() {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace = trace +
                    matrix[i][i];
        }
        result.append(trace);
        result.append(" ");

        int repeatedRows = 0;
        int repeatedColumns = 0;
        Set<Integer> setR = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        for (int i = 0; i < N; i++) {
            setR.clear();
            setC.clear();
            for (int j = 0; j < N; j++) {
                setR.add(matrix[i][j]);
                setC.add(matrix[j][i]);
            }
            if (setC.size() != N) {
                repeatedColumns++;
            }
            if (setR.size() != N) {
                repeatedRows++;
            }
        }

        result.append(repeatedRows);
        result.append(" ");
        result.append(repeatedColumns);
        result.append(" ");
        return result.toString();
    }


}