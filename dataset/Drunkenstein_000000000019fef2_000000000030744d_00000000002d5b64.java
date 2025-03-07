//package com.google.jam;

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
        int R = in.nextInt();
        int S = in.nextInt();


        int[] arr = new int[R * S];
        int[] arrOk = new int[R * S];
        for (int i = 0; i < R * S; i++) {
            arr[i] = i % S;
            arrOk[i] = i / R;
        }

        BigInteger resultHash = calcHash(arrOk, R * S);

        Node start = new Node(arr, R * S, 0);

        Queue <Node> bfs = new ArrayDeque <>();
        bfs.add(start);

        while (bfs.size() != 0) {
            Node next = bfs.poll();
            arr = next.arr;
            if (next.hash.equals(resultHash)) {
                printResult(next);
                return;
            }

            int i = R * S - 1;
            while (arr[i] == arrOk[i])
                i--;

            int digit = arr[i + 1];

            for (int s = 0; s <= i; s++) {
                if (arr[s] == digit) {
                    int[] swap = arrTransform(next.arr, s , i, R * S);
                    Node toAdd = new Node(swap, R * S, next.moves + 1);
                    toAdd.solution = next.solution.append(s + 1).append(" ").append(i + 1).append('\n');
                    bfs.add(toAdd);
                }
            }
        }

    }

    static int[] arrTransform(int[] arr, int i, int j, int size) {
        int[] result = new int[size];
        for (int k = j+1; k < size; k++) {
            result[k] = arr[k];
        }
        for (int k = 0; k < j - i; k++) {
            result[k] = arr[i + k+1];
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
