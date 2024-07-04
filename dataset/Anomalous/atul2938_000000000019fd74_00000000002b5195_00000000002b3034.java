/*
 *  author : Atul Anand   
 *  created on : Sat Apr 11 2020
 */

import java.io.*;
import java.util.*;

public class A {

    public static void main(String[] args) throws IOException {
        int testCaseCount = in.nextInt();
        for (int currentCase = 1; currentCase <= testCaseCount; currentCase++) {
            int n = in.nextInt();
            String[] patterns = new String[n];
            int maxLengthIndex = 0;
            for (int i = 0; i < n; i++) {
                patterns[i] = in.next();
                if (patterns[i].length() > patterns[maxLengthIndex].length()) {
                    maxLengthIndex = i;
                }
            }
            StringBuilder result = new StringBuilder();
            result.append(patterns[maxLengthIndex].substring(1));
            boolean isValid = true;
            for (String pattern : patterns) {
                if (!result.toString().contains(pattern.substring(1))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                println("Case #" + currentCase + " " + result.toString());
            } else {
                println("Case #" + currentCase + " *");
            }
        }
        
        in.close();
        out.close();
    }

    static final int MIN = Integer.MIN_VALUE;
    static final int MAX = Integer.MAX_VALUE;
    static final Reader in = new Reader();
    static final PrintWriter out = new PrintWriter(System.out);

    static void read(int[] arr, int N) throws IOException { 
        for (int i = 0; i < N; i++) { 
            arr[i] = in.nextInt(); 
        } 
    }
    
    static void read(long[] arr, int N) throws IOException { 
        for (int i = 0; i < N; i++) { 
            arr[i] = in.nextLong(); 
        } 
    }
    
    static void read(String[] arr, int N) throws IOException { 
        for (int i = 0; i < N; i++) { 
            arr[i] = in.next(); 
        } 
    }
    
    static void print(Object obj) {  
        out.print(obj); 
    }
    
    static void println(Object obj) { 
        out.println(obj); 
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