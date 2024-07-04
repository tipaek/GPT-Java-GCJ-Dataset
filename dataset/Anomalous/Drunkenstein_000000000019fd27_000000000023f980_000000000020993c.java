package com.google.jam;

import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int testCount = in.nextInt();
            for (test = 1; test <= testCount; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void solve() throws Exception {
        int n = in.nextInt();
        int[][] rowCounts = new int[n][n];
        int[][] colCounts = new int[n][n];
        int trace = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = in.nextInt() - 1;
                rowCounts[i][value]++;
                colCounts[value][j]++;
                if (i == j) {
                    trace += value + 1;
                }
            }
        }

        int duplicateRows = 0;
        int duplicateCols = 0;

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(rowCounts[i])) {
                duplicateRows++;
            }
            if (hasDuplicates(colCounts[i])) {
                duplicateCols++;
            }
        }

        out.println(trace + " " + duplicateRows + " " + duplicateCols);
    }

    static boolean hasDuplicates(int[] countArray) {
        for (int count : countArray) {
            if (count != 1) {
                return true;
            }
        }
        return false;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}