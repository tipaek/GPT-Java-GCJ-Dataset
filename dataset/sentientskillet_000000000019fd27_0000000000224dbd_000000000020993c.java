import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Vestigium {
    public static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(f.readLine());
        for(int i =0; i<T; i++) {
            int[][] matrix = readMatrix();
            out.printf("Case #%d: %d %d %d%n", i+1, trace(matrix), rowErrs(matrix), colErrs(matrix));
        }
        out.close();
    }
    public static int[][] readMatrix() throws IOException {
        int N = Integer.parseInt(f.readLine());
        int[][] matrix = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return matrix;
    }
    public static int trace(int[][] matrix) {
        int N = matrix.length;
        int trace = 0;
        for(int i =0; i<N; i++) trace += matrix[i][i];
        return trace;
    }
    public static int rowErrs(int[][] matrix) {
        int N = matrix.length;
        int errs = 0;
        for(int i=0; i<N; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=0; j<N; j++){
                set.add(matrix[i][j]);
            }
            errs += set.size() == N ? 0 : 1;
        }
        return errs;
    }
    public static int colErrs(int[][] matrix) {
        int N = matrix.length;
        int errs = 0;
        for(int i=0; i<N; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=0; j<N; j++){
                set.add(matrix[j][i]);
            }
            errs += set.size() == N ? 0 : 1;
        }
        return errs;
    }

}
