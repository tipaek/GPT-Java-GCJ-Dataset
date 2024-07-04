import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Vestigium {
    public static int[][] MATRIX;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            MATRIX = new int[N][N];
            for (int y = 0; y < N; y++) {
                String[] parts = br.readLine().split(" ");
                for (int x = 0; x < N; x++) {
                    MATRIX[y][x] = Integer.parseInt(parts[x]);
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace() + " " + rowsRepeat() + " " + colsRepeat());
        }
        br.close();
    }

    public static long trace() {
        long sum = 0;
        for (int y = 0; y < N; y++) {
            sum += MATRIX[y][y];
        }
        return sum;
    }

    public static long rowsRepeat() {
        long count = 0;
        for (int y = 0; y < N; y++) {
            boolean[] seen = new boolean[N + 10];
            for (int x = 0; x < N; x++) {
                int num = MATRIX[y][x];
                if (seen[num]) {
                    count++;
                    break;
                }
                seen[num] = true;
            }
        }
        return count;
    }

    public static long colsRepeat() {
        long count = 0;
        for (int y = 0; y < N; y++) {
            boolean[] seen = new boolean[N + 10];
            for (int x = 0; x < N; x++) {
                int num = MATRIX[x][y];
                if (seen[num]) {
                    count++;
                    break;
                }
                seen[num] = true;
            }
        }
        return count;
    }
}
