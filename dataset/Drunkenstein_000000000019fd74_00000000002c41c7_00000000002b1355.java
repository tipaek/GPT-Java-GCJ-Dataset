//package com.google.jam;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;


public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {

        int R = in.nextInt();
        int C = in.nextInt();

        int[] arr = new int[R * C];
        long interest = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i * C + j] = in.nextInt();
            }
        }

        int[] next = Arrays.copyOf(arr, R * C);

        int eluminated;
        interest += calsInterest(arr, R * C);
        do {
            eluminated = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i * C + j] != Integer.MAX_VALUE) {
                        int totalClass = 0;
                        int totalNeighbor = 0;

                        int t = 1;
                        while (i - t >= 0 && arr[(i - t) * C + j] == Integer.MAX_VALUE)
                            t++;
                        if (i - t >= 0) {
                            totalClass += arr[(i - t) * C + j];
                            totalNeighbor += 1;
                        }

                        t = 1;
                        while (i + t < R && arr[(i + t) * C + j] == Integer.MAX_VALUE)
                            t++;
                        if (i + t < R) {
                            totalClass += arr[(i + t) * C + j];
                            totalNeighbor += 1;
                        }

                        t = 1;
                        while (j - t >= 0 && arr[i * C + j - t] == Integer.MAX_VALUE)
                            t++;
                        if (j - t >= 0) {
                            totalClass += arr[i * C + j - t];
                            totalNeighbor += 1;
                        }

                        t = 1;
                        while (j + t < C && arr[i * C + j + t] == Integer.MAX_VALUE)
                            t++;
                        if (j + t < C) {
                            totalClass += arr[i * C + j + t];
                            totalNeighbor += 1;
                        }

                        if (totalNeighbor > 0 && arr[i * C + j] * totalNeighbor < totalClass) {
                            next[i * C + j] = Integer.MAX_VALUE;
                            eluminated++;
                        }
                    }
                }
            }
            arr = Arrays.copyOf(next, R * C);
            if (eluminated > 0) {
                interest += calsInterest(arr, R * C);
            }

        } while (eluminated > 0);
        out.println(interest);
    }

    static long calsInterest(int[] array, int len) {
        long interest = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] != Integer.MAX_VALUE)
                interest += array[i];
        }
        return interest;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            //inputStream = new FileInputStream(new File("./src/test.txt"));
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) throws FileNotFoundException {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String str = reader.readLine();
                    if (str == null)
                        return "";
                    else
                        tokenizer = new StringTokenizer(str);
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
