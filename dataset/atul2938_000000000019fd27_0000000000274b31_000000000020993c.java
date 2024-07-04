import java.io.*;
import java.util.*;

class Solution{

    public static void main(String[] args) throws IOException {
        int T = in.nextInt();
        int t = 1;
        while(t <= T){
            int N = in.nextInt();
            int M[][] = new int[N][N];
            for(int i = 0; i < N; i++){
                read(M[i], N);
            }
            
            int trace = 0;
            for(int i = 0; i < N; i++){
                trace += M[i][i];
            }
            
            int row = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < N; i++){
                set.clear();
                for(int j = 0; j < N; j++){
                    set.add(M[i][j]);
                }
                
                if(set.size() != N){
                    row++;
                }
            }
            
            int col = 0;
            for(int j = 0; j < N; j++){
                set.clear();
                for(int i = 0; i < N; i++){
                    set.add(M[i][j]);
                }
                
                if(set.size() != N){
                    col++;
                }
            }
            
            println("#"+t+": " + trace+" "+row+" "+col);
            t++;
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