import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws IOException {
        int T = in.nextInt();
        for(int t = 1; t <= T; t++){
            String S = in.next();
            // expand
            S = expand(S);
            
            // shrink
            Stack<Character> stack = new Stack<>();
            stack.push(S.charAt(0));
            for(int i = 1; i < S.length(); i++){
                if(stack.peek() == ')' && S.charAt(i) == '('){
                    stack.pop();
                }
                else{
                    stack.push(S.charAt(i));
                }
            }
            
            StringBuilder ans = new StringBuilder();
            while(!stack.isEmpty()){
                ans.append(stack.pop());
            }
            
            System.out.printf("Case #%d: %s \n", t, ans.reverse().toString());
        }
        
        in.close();
        out.close();
    }

    static String expand(String S){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            sb.append(surround(S.charAt(i)));
        }
        return sb.toString();
    }
    
    static String surround(char c){
        String s = ""+c;
        for(int i = 0; i < c-'0'; i++){
            s = "(" + s + ")";
        }
        
        return s;
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