//package com.google.jam;
//72

import java.io.*;
import java.math.BigInteger;
import java.util.*;

import static java.lang.System.exit;


public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {
        int X = in.nextInt();
        int Y = in.nextInt();
        String path = in.next();




        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'S')
                Y--;
            else if (path.charAt(i) == 'N')
                Y++;
            else if (path.charAt(i) == 'E')
                X++;
            else if (path.charAt(i) == 'W')
                X--;
            if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                out.println(i + 1);
                return;
            }

        }

        out.println("IMPOSSIBLE");
    }

    static int[] arrTransform(int[] arr, int i, int j, int size) {
        int[] result = new int[size];
        for (int k = j + 1; k < size; k++) {
            result[k] = arr[k];
        }
        for (int k = 0; k < j - i; k++) {
            result[k] = arr[i + k + 1];
        }

        for (int k = j - i; k <= j; k++) {
            result[k] = arr[k - j + i];
        }
        return result;
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

    static void printResult(Node n) {
        out.println(n.moves);
        out.println(n.solution);
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
