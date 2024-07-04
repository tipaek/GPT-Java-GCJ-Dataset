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
        long m = in.nextInt();

        int[] d = new int[n];

        StringBuilder result = new StringBuilder();

        List <Node> known = new ArrayList <>();
        List <Node> unknown = new ArrayList <>();

        List <Node> all = new ArrayList <>();

        Comparator <Node> byDistance = (o1, o2) -> o1.num.compareTo(o2.num);
        Comparator <Node> byOrder = (o1, o2) -> o1.order.compareTo(o2.order);

        Map <Integer, Node> map = new HashMap <>();

        for (int i = 1; i < n; i++)
            d[i] = in.nextInt();


        for (int i = 0; i < n; i++) {
            if (d[i] >= 0) {
                Node node = new Node(i);
                node.distance = d[i];
                known.add(node);
                all.add(node);
                map.put(i,node);
            } else {
                Node node = new Node(i);
                node.order = -d[i];
                unknown.add(node);
                all.add(node);
                map.put(i,node);
            }
        }

        Collections.sort(known, byDistance);
        Collections.sort(unknown, byOrder);


        int currentOrder = 0;
        int knownPointer = 0;

        int s = 0;
        while (s < unknown.size()) {
            if (unknown.get(s).order > currentOrder) {
                known.get(knownPointer).order = currentOrder;
                knownPointer++;
            } else {
                s++;
            }
            currentOrder++;
        }

        for (int i = knownPointer; i < known.size(); i++) {
            known.get(i).order = currentOrder;
            currentOrder++;
        }

        Collections.sort(all, byOrder);

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).distance == Integer.MAX_VALUE) {
                if (i >= 1 && all.get(i).order == all.get(i - 1).order) {
                    all.get(i).distance = all.get(i - 1).distance;
                } else {
                    all.get(i).distance = all.get(i - 1).distance + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int k = in.nextInt() - 1;
            int l = in.nextInt() - 1;

            int distance = Math.abs(map.get(k).distance - map.get(l).distance);
            if (distance == 0)
                distance = 1000;

            result.append(distance + " ");
        }

        out.println(result);
    }


    static class Node {
        public Integer num;
        public Integer order = Integer.MAX_VALUE;
        public Integer distance = Integer.MAX_VALUE;

        Node(int n) {
            num = n;
        }
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
