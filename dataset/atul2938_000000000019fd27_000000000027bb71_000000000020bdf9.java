import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws IOException {
        int T = in.nextInt();
        for(int t = 1; t <= T; t++){
            int N = in.nextInt();
            Activity A[] = new Activity[N];  
            for(int i = 0; i < N; i++){
                A[i] = new Activity(in.nextInt(), in.nextInt(), i);
            }
            
            Arrays.sort(A, (a1, a2) -> a1.start == a2.start ? a1.end - a2.end : a1.start - a2.start);
        
            int Cend = 0;
            int Jend = 0;
            boolean flag = true;
            char c[] = new char[N];
            for(int i = 0; i < N; i++){
                Activity a = A[i];
                if(Cend <= a.start){
                    c[a.idx] = 'C';
                    Cend = a.end;
                }
                else if(Jend <= a.start){
                    c[a.idx] = 'J';
                    Jend = a.end;
                }
                else{
                    flag = false;
                    break;
                }
            }
            String ans;
            if(flag){
                ans = String.valueOf(c); 
            }
            else{
                ans = "IMPOSSIBLE";
            }
            System.out.printf("Case #%d: %s \n", t, ans);
        }
        
        in.close();
        out.close();
    }
    
    static class Activity{
        int start;
        int end;
        int idx;
        
        Activity(int s, int e, int i){
            start = s;
            end = e;
            idx = i;
        }
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