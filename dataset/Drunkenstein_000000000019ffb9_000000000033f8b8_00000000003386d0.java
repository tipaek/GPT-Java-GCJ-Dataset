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

        int n = in.nextInt();

        List <Node> holes = new ArrayList <>();

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(in.next());
            long y = Long.parseLong(in.next());

            Node node = new Node();
            node.x = BigInteger.valueOf(x);
            node.y = BigInteger.valueOf(y);
            holes.add(node);
        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                BigInteger x = holes.get(i).x.subtract(holes.get(j).x);
                BigInteger y = holes.get(i).y.subtract(holes.get(j).y);

                int num = 0;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < k; l++) {
                        if (k != i && k != j && l != i && l != j) {
                            BigInteger x1 = holes.get(k).x.subtract(holes.get(l).x);
                            BigInteger y1 = holes.get(k).y.subtract(holes.get(l).y);
                            if (isParallel(x, x1, y, y1))
                                num++;
                        }
                    }
                }
                ans = Math.max(ans,num);
            }
        }

        out.println(Math.min(n,2*(ans+1)+2));
    }

    static boolean isParallel(BigInteger x1, BigInteger x2, BigInteger y1, BigInteger y2) {
        return x1.multiply(y2).equals(x2.multiply(y1));
    }


    static class Node {
        public BigInteger x;
        public BigInteger y;
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
