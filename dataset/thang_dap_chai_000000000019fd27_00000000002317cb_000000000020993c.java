/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author thangbq
 */
public class Solution {

    public static class Index {

        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= nTestCase; ++i) {
            int n = in.nextInt(), val;
            int r = 0, c = 0, trace = 0;
            Set<Integer> dupCols = new HashSet<>();
            Set<Integer> dupRows = new HashSet<>();
            Map<Integer, Index> index = new HashMap<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    val = in.nextInt();
                    if (j == k) {
                        trace += val;
                    }
                    Index valIndex = index.get(val);
                    if (valIndex == null) {
                        valIndex = new Index();
                        index.put(val, valIndex);
                    }
                    if (valIndex.cols.contains(k)) {
                        dupCols.add(k);
                    }
                    if (valIndex.rows.contains(j)) {
                        dupRows.add(j);
                    }
                    valIndex.cols.add(k);
                    valIndex.rows.add(j);
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + (dupRows.size()) + " " + dupCols.size());
        }
    }
}

