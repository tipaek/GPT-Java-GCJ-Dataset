/*  
 *  created on : Sat May 02 2020
 */

import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        int c = 1;
        while(t-->0){
            int X = in.nextInt();
            int Y = in.nextInt();
            String dir = in.next();

            
            boolean clicked = false;
            int time = 0;
            if(X == 0 && Y == 0){
                clicked = true;    
            }
            else{
                for(char d: dir.toCharArray()){
                    if(d == 'N'){
                        Y += 1;
                    }
                    else if(d == 'S'){
                        Y -= 1;
                    }
                    else if(d == 'W'){
                        X -= 1;
                    }
                    else{
                        X += 1;
                    }
                    time++;
                    int dist = Math.abs(X) + Math.abs(Y);
                    //System.out.println(time+ ", dist: " + dist);
                    if(dist <= time){
                        clicked = true;
                        break;
                    }
                }
            }

            if(clicked){
                println("Case #"+c+": "+time);
            }
            else{
                println("Case #"+c+": IMPOSSIBLE");
            }
            c++;
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
    
    static void debug(Object ... O) { 
    	for(Object obj: O){
    		System.out.print(obj + " ");
    	}
    	System.out.println();
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