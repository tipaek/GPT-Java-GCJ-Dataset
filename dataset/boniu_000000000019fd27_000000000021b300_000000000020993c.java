import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int k = 0, r = 0, c = 0;
            //trace of the matix
            for (int i = 0; i < N; i++) {
                k += matrix[i][i];
            }

            //num of rows that contain repeated elements
            for (int i = 0; i < N; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (set.contains(matrix[i][j])) {
                        r += 1;
                        break;
                    }else {
                        set.add(matrix[i][j]);
                    }
                }
            }

            //num of rows that contain repeated elements
            for (int j = 0; j < N; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (set.contains(matrix[i][j])) {
                        c += 1;
                        break;
                    }else {
                        set.add(matrix[i][j]);
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, k, r, c));
        }

    }
}
