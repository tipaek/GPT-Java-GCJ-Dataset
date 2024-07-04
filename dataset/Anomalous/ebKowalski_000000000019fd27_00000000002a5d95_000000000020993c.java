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
                init();
                System.out.print("Case #" + i + ": ");
                solve();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        in.close();
    }

    static void init() {
        N = Integer.parseInt(in.nextLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = in.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
    }

    static void solve() {
        int k = 0, r = 0, c = 0;

        // Calculate trace
        for (int i = 0; i < N; i++) {
            k += matrix[i][i];
        }

        // Check rows for duplicates
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                r++;
            }
        }

        // Check columns for duplicates
        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                c++;
            }
        }

        System.out.println(k + " " + r + " " + c);
    }

    static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}