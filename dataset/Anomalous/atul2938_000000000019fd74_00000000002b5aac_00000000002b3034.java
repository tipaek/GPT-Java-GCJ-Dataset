/*
 *  author : Atul Anand   
 *  created on : Sat Apr 11 2020
 */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        int t = input.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = input.nextInt();
            String[] patterns = new String[n];
            int longestPatternIndex = 0;
            for (int i = 0; i < n; i++) {
                patterns[i] = input.next();
                if (patterns[i].length() > patterns[longestPatternIndex].length()) {
                    longestPatternIndex = i;
                }
            }
            StringBuilder result = new StringBuilder();
            result.append(patterns[longestPatternIndex].substring(1));
            boolean isValid = true;
            for (String pattern : patterns) {
                if (result.indexOf(pattern.substring(1)) == -1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                println("Case #" + testCase + " " + result);
            } else {
                println("Case #" + testCase + " *");
            }
        }
        
        input.close();
        output.close();
    }

    static final int MIN = Integer.MIN_VALUE;
    static final int MAX = Integer.MAX_VALUE;
    static final Reader input = new Reader();
    static final PrintWriter output = new PrintWriter(System.out);

    static void read(int[] arr, int N) throws IOException {
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }
    }
    
    static void read(long[] arr, int N) throws IOException {
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextLong();
        }
    }
    
    static void read(String[] arr, int N) throws IOException {
        for (int i = 0; i < N; i++) {
            arr[i] = input.next();
        }
    }
    
    static void print(Object obj) {
        output.print(obj);
    }
    
    static void println(Object obj) {
        output.println(obj);
    }
    
    static void println(int[] arr) {
        for (int value : arr) {
            print(value + " ");
        }
        println("");
    }

    static void println(int[][] arr) {
        for (int[] row : arr) {
            println(row);
        }
    }
    
    static void debug(Object obj) {
        System.out.println(obj);
    }
}

class Reader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    Reader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    
    String nextLine() throws IOException {
        return reader.readLine();
    }
    
    void close() throws IOException {
        reader.close();
    }
}