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
        Map <Character, Integer> map = new HashMap <>();
        Map <Character, Integer> counter = new HashMap <>();
        Set <Character> possible = new HashSet <>();
        List <String> integers = new ArrayList <>();
        List <String> strings = new ArrayList <>();
        int N = in.nextInt();

        for (int i = 0; i < 10000; i++) {
            integers.add(in.next());
            strings.add(in.next());

            if (integers.get(i).length() == strings.get(i).length() || integers.get(i).equals("-1")) {
                int digit = integers.get(i).charAt(0) - '0';
                String current = strings.get(i);
                map.put(current.charAt(0), Math.min(map.getOrDefault(current.charAt(0), 10), digit));
                counter.put(current.charAt(0), counter.getOrDefault(current.charAt(0), 0) + 1);
                for (int j = 0; j < current.length(); j++) {
                    possible.add(current.charAt(j));
                }
            }
        }


        List <Integer> freq = new ArrayList <>();
        for (Character t : counter.keySet())
            freq.add(counter.get(t));

        Collections.sort(freq);

        List <Character> result = new ArrayList <>();

        for (int i = 0; i < 9; i++) {
            for (Character t : counter.keySet()) {
                if (counter.get(t) == freq.get(i))
                    result.add(t);
            }
        }

        for (Character s : possible)
            if (!counter.keySet().contains(s))
                result.add(s);
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (Character ch : result) {
            sb.append(ch);
        }
        out.println(sb.toString());

        return;

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
