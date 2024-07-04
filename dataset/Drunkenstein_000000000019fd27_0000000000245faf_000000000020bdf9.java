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

        int n = in.nextInt();

        List <Tree> trees = new ArrayList <>();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            trees.add(new Tree(start, end, i));
        }

        Collections.sort(trees);
        int[] arr = new int[n];
        arr[0] = 1;
        Tree jim = trees.get(0);
        Tree tim = null;

        for (int i = 1; i < n; i++) {
            if (trees.get(i).start >= jim.end) {
                jim = trees.get(i);
                arr[i] = 1;
            } else if (tim == null || trees.get(i).start >= tim.end) {
                tim = trees.get(i);
                arr[i] = 2;
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }

        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            result.append(" ");
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                result.setCharAt(trees.get(i).num, 'J');
            } else {
                result.setCharAt(trees.get(i).num, 'C');
            }
        }

        out.println(result);
    }

    static class Tree implements Comparable <Tree> {
        public int start;
        public int end;
        public int num;

        Tree(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

        @Override
        public int compareTo(Tree a) {
            if (start < a.start || (start == a.start && end < a.end))
                return -1;
            else if (start == a.start && end == a.end)
                return 0;
            else
                return 1;
        }
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
