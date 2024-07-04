package qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public String solve(Scanner in) {
        int n = in.nextInt();
        int mat[][] = new int[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                mat[i][j] = in.nextInt();
            }
        }
        int r = 0, c = 0, k = 0;

        for(int i = 0; i < n; ++i) {
            k += mat[i][i];
        }

        for(int i = 0; i < n; ++i) {
            Set<Integer> dist = new HashSet<>();
            for(int j = 0; j < n; ++j) {
                dist.add(mat[i][j]);
            }
            if (dist.size() < n) {
                r++;
            }
        }

        for(int j = 0; j < n; ++j) {
            Set<Integer> dist = new HashSet<>();
            for(int i = 0; i < n; ++i) {
                dist.add(mat[i][j]);
            }
            if (dist.size() < n) {
                c++;
            }
        }
        return k + " " + r + " " + c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Vestigium sol = new Vestigium();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}

