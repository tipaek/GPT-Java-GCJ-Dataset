/*
 *  author : Atul Anand   
 *  created on : Sat Apr 11 2020
 */

import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        for(int T = 1; T <= t; T++){
            int n = in.nextInt();
            String p[] = new String[n];
            int maxIdx = 0;
            for(int i = 0; i < n; i++){
                p[i] = in.next();
                if(p[i].length() > p[maxIdx].length()){
                    maxIdx = i;
                }
            }
            StringBuilder ans = new StringBuilder();
            ans.append(p[maxIdx].substring(1));
            boolean flag = true;
            for(int i = 0; i < n; i++){
                if(ans.indexOf(p[i].substring(1)) == -1){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                println("Case #"+T+" "+ ans.toString());
            }
            else{
                println("Case #"+T+" "+ "*");
            }
        }
        
        in.close();
        out.close();
    }

    static int MIN = Integer.MIN_VALUE;
    static int MAX = Integer.MAX_VALUE;
    static Reader in = new Reader();
    static PrintWriter out = new PrintWriter(System.out);

    static void read(int arr[], int N) throws IOException { 
    	for(int i = 0; i < N; i++){ 
    		arr[i] = in.nextInt(); 
    	} 
    }
    
    static void read(long arr[], int N) throws IOException { 
    	for(int i = 0; i < N; i++){ 
    		arr[i] = in.nextLong(); 
    	} 
    }
    
    static void read(String arr[], int N) throws IOException { 
    	for(int i = 0; i < N; i++){ 
    		arr[i] = in.next(); 
    	} 
    }
    
    static void print(Object O) {  
    	out.print(O); 
    }
    
    static void println(Object O) { 
    	out.println(O); 
    }
    
    static void println(int arr[]) { 
    	for(int i = 0; i < arr.length; i++){ 
    		print(arr[i]+" "); 
    	} 
    	println(""); 
    }

    static void println(int arr[][]) { 
    	for(int i = 0; i < arr.length; i++){ 
    		println(arr[i]); 
    	}
    }
    
    static void debug(Object O) { 
    	System.out.println(O); 
    }
}

class Reader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    Reader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    String next() throws IOException {
        while (!tokenizer.hasMoreTokens() ) { 
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