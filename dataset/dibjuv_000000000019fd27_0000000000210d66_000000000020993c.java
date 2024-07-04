/*
 * Created by cravuri on 4/3/20
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] mat = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += mat[i][i];
            }
            int row = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> contains = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (contains.contains(mat[i][j])) {
                        row++;
                        break;
                    }
                    contains.add(mat[i][j]);
                }
            }
            int col = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> contains = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    if (contains.contains(mat[j][i])) {
                        col++;
                        break;
                    }
                    contains.add(mat[j][i]);
                }
            }
            System.out.println("Case #" + t + ": " + trace + " " + row + " " + col);
        }
    }

}
