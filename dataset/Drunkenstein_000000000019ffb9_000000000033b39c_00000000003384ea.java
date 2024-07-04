//package com.google.jam;


import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.System.exit;


public class Solution {

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

    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {

        long l = Long.parse(in.next());
        long r = Long.parse(in.next());

        long diff = Math.abs(l - r);

        long i = (long) (Math.sqrt(2.0 * diff) + 0.00000000001);

        if (r >= l)
            r -= i * (i + 1) / 2;
        else
            l -= i * (i + 1) / 2;

        long target = Math.max(l, r);
        long n = (-i + (int) (Math.sqrt(i * i + 4 * target) + 0.00000000001)) / 2;
        long total = i + 2 * n;

        if (l >= r) {
            l -= (n + i) * n;
            r -= (n + i + 1) * n;
            if (r < 0) {
                r += i + 2 * n;
                total--;
            }
        } else {
            r -= (n + i) * n;
            l -= (n + i + 1) * n;
            if (l < 0) {
                l += i + 2 * n;
                total--;
            }
        }
        out.println(total + " " + l + " " + r);
    }

    static void arrTransform() {
    }

    static class Node {
        Node(int arr[], int size, int moves) {
            this.arr = new int[size];
            for (int i = 0; i < size; i++) {
                this.arr[i] = arr[i];
            }
            hash = calcHash(this.arr, size);
            this.size = size;
            this.moves = moves;
        }

        int[] arr;
        int size;
        BigInteger hash;
        int moves = 0;
        StringBuilder solution = new StringBuilder();
    }

    static BigInteger calcHash(int[] arr, int size) {
        BigInteger hash = BigInteger.ZERO;
        for (int i = 0; i < size; i++) {
            hash = hash.multiply(BigInteger.TEN).add(BigInteger.valueOf(arr[i]));
        }
        return hash;
    }


    static void printCase() {
        out.print("Case #" + test + ": ");
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
