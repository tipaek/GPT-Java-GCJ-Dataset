import java.util.*;
import java.io.*;

public class Vestigium {

    static Scanner in;
    static PrintWriter out;

    static int T, N;
    static int[][] matrix;
    
    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("vestigium.in"));
        
        T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; i++) {
            try {
                initialize();
                System.out.print("Case #" + i + ": ");
                solve();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        in.close();
    }

    static void initialize() {
        N = Integer.parseInt(in.nextLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    static void solve() {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Calculate trace
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        // Check for row duplicates
        for (int i = 0; i < N; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowRepeats++;
                    break;
                }
            }
        }

        // Check for column duplicates
        for (int j = 0; j < N; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (!colSet.add(matrix[i][j])) {
                    colRepeats++;
                    break;
                }
            }
        }

        System.out.println(trace + " " + rowRepeats + " " + colRepeats);
    }
}