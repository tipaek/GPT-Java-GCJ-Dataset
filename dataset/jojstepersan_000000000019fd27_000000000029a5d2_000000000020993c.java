
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jojstepersan
 */
public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int traza, rC, rF;
    static boolean rf = false,rc=false;

    public static void main(String[] args) throws Exception {
        int t = Integer.valueOf(in.readLine().trim());
        for (int i = 0; i < t; i++) {
            traza = 0;
            rC = 0;
            rF = 0;
            int n = Integer.valueOf(in.readLine().trim());
            int mat[][] = new int[n][n];
            boolean r[] = new boolean[n + 1];
            Map<Integer, Integer> freq;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(in.readLine().trim());
                boolean fm = false;
                freq = new HashMap<>();
                for (int k = 0; k < n; k++) {
                    mat[j][k] = Integer.valueOf(st.nextToken());
                    if (freq.containsKey(mat[j][k])) {
                        freq.put(mat[j][k], freq.get(mat[j][k]) + 1);
                    } else {
                        freq.put(mat[j][k], 1);
                    }
                    if (j == k) {
                        traza += mat[j][k];
                    }
                }
                
                rf=false;
                freq.forEach((k, v) -> {
                    if (v > 1 && !rf) {
                        rF++;
                        rf = true;
                    }
                });

            }
            for (int j = 0; j < n; j++) {
                freq = new HashMap<>();
                for (int k = 0; k < n; k++) {
                   
                    if (freq.containsKey(mat[k][j])) {
                        freq.put(mat[k][j], freq.get(mat[k][j]) + 1);
                    } else {
                        freq.put(mat[k][j], 1);
                    }
                }
                
                rc=false;
                freq.forEach((k, v) -> {
                    if (v > 1 && !rc) {
                        rC++;
                        rc = true;
                    }
                });

            }

            System.out.printf("Case #%d: %d %d %d\n", i + 1, traza, rF, rC);
        }
    }
}
