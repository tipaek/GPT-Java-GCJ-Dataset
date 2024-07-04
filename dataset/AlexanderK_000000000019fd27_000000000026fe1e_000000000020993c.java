/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author alexk
 */
public class Vestigium {
    public static void main(String[] args) throws IOException {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            process(r);
        }
    }
    
    public static void process(BufferedReader r) throws IOException {
        int c = Integer.parseInt(r.readLine());
        for (int i = 0; i < c; i++) {
            int n = Integer.parseInt(r.readLine());
            int[][] m = new int[n][];
            for (int j = 0; j < n; j++) {
                m[j] = Stream.of(r.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            processMatrix(i + 1, m);
        }
    }
    
    private static void processMatrix(int x, int[][] m) {
        int n = m.length;
        int k = 0, r = 0, c = 0;
        Set[] rowVals = new Set[n];
        Set[] colVals = new Set[n];
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < n; i++) {
            k += m[i][i];
            rowVals[i] = new HashSet();
            colVals[i] = new HashSet();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rows[i]) {
                    if (!rowVals[i].add(m[i][j])) {
                        rows[i] = true;
                        r++;
                    }
                }
                if (!cols[j]) {
                    if (!colVals[j].add(m[i][j])) {
                        cols[j] = true;
                        c++;
                    }
                }
            }
        }
        System.out.println("Case #" + x + " " + k + " " + r + " " + c);        
    }
}
