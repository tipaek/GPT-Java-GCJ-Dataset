/*  
 *  created on : Sun Apr 19 2020
 */

import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws IOException {
        int T = in.nextInt();
        ArrayList<Long> power = new ArrayList<>();
        long pow = 1;
        while(pow <= Long.MAX_VALUE && pow > 0){
            power.add(pow);
            pow = pow * 2;
        }

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        for(int t = 1; t <= T; t++){
            long x = in.nextLong();
            long y = in.nextLong();

            Queue<Node> q = new LinkedList<>();
            HashSet<String> visited = new HashSet<>();
            q.add(new Node(0, 0, -1));
            int cnt = 0;
            Node ans = null;
            while(!q.isEmpty() && cnt < 10000){
                Node node = q.poll();
                //println(node.x +", "+node.y);
                cnt++;
                if(node.x == x && node.y == y){
                    ans = node;
                    break;
                }

                if(node.i == power.size() - 1){
                    continue;
                }

                for(int k = 0; k < 4; k++){
                    long newx = node.x + power.get(node.i+1) * dx[k];
                    long newy = node.y + power.get(node.i+1) * dy[k];

                    String key = newx +" "+newy;
                    if(!visited.contains(key)){
                        visited.add(key);
                        StringBuilder sb = new StringBuilder(node.route.toString());
                        
                        if(k == 0){
                            sb.append('N');
                        }
                        else if(k == 1){
                            sb.append('S');
                        }
                        else if(k == 2){
                            sb.append('E');
                        }
                        else{
                            sb.append('W');
                        }
                        Node newNode = new Node(newx, newy, node.i + 1);
                        newNode.route = sb;
                        q.add(newNode);
                    }
                }
            }

            StringBuilder route = new StringBuilder();
            if(ans == null){
                route.append("IMPOSSIBLE");
            }
            else{
                route.append(ans.route);
            }
            out.printf("Case #%d: %s \n", t, route.toString());
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

class Node{
    long x;
    long y;
    int i;
    StringBuilder route;

    Node(long x, long y, int i){
        this.x = x;
        this.y = y;
        this.i = i;
        route = new StringBuilder();
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