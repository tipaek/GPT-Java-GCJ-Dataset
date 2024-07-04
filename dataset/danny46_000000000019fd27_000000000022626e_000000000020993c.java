import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int x = 1; x <= t; ++x) {
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int[] res = solve(N, matrix);
            System.out.println("Case #" + x + ": " + res[0] + " " + res[1] + " " + res[2] );
        }
    }

    public static int[] solve(int N, int[][] matrix) {
        int k = 0, r = 0, c = 0;

        for(int x = 0; x < N; x++) {
            k += matrix[x][x];
        }

        for(int i = 0; i < N; i++) {
            int[] row = new int[N];
            for(int j = 0; j < N; j++) {
                row[j] = matrix[i][j];
            }
            if(hasDup(row)) {
                r += 1;
            }
        }

        for(int i = 0; i < N; i++) {
            int[] col = new int[N];
            for(int j = 0; j < N; j++) {
                col[j] = matrix[j][i];
            }
            if(hasDup(col)) {
                c += 1;
            }
        }

        return new int[]{k, r, c};
    }

    public static boolean hasDup(int[] arr) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int x = 0; x < arr.length; x++) {
            if(counter.containsKey(arr[x])) {
                counter.put(arr[x], counter.get(arr[x]) + 1);
            } else {
                counter.put(arr[x], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if(entry.getValue() > 1) {
                return true;
            }
        }
        
        return false;
    }
}