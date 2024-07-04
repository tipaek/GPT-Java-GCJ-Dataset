//make sure to make new file!
import java.io.*;
import java.util.*;
//go for first partial
public class Solution{
   
   public static void main(String[] args)throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);
      
      int t = Integer.parseInt(f.readLine());
      
      for(int q = 1; q <= t; q++){
      
         StringTokenizer st = new StringTokenizer(f.readLine());
      
         int n = Integer.parseInt(st.nextToken());
         int m = Integer.parseInt(st.nextToken());
         
         int[] rank = new int[n+1];
         rank[1] = 0;
         st = new StringTokenizer(f.readLine());
         for(int k = 2; k <= n; k++){
            rank[k] = Integer.parseInt(st.nextToken())*-1;
         }
         
         ArrayList<ArrayList<Edge>> adj = new ArrayList<ArrayList<Edge>>(n+1);
         for(int k = 0; k <= n; k++) adj.add(new ArrayList<Edge>());
         
         for(int k = 0; k < m; k++){
            st = new StringTokenizer(f.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adj.get(a).add(new Edge(b,k));
            adj.get(b).add(new Edge(a,k));
         }
         
         PriorityQueue<Node> pq = new PriorityQueue<Node>();
         boolean[] seen = new boolean[n+1];
         pq.add(new Node(1,rank[1]));
         seen[1] = true;
         
         int[] answer = new int[m];
         while(!pq.isEmpty()){
            Node no = pq.poll();
            
            //find first edge to a taken node
            for(Edge e : adj.get(no.v)){
               if(!seen[e.to]) continue;
               answer[e.index] = rank[no.v]-rank[e.to];
               break;
            }
            
            for(Edge e : adj.get(no.v)){
               if(seen[e.to]) continue;
               seen[e.to] = true;
               pq.add(new Node(e.to,rank[e.to]));
            }
         }
               
         StringJoiner sj = new StringJoiner(" ");
         for(int k = 0; k < m; k++){
            if(answer[k] == 0) sj.add("1000000");
            else sj.add("" + answer[k]);
         }
         
         out.println("Case #" + q + ": " + sj.toString());  
         
         

      }
      
      
      
      
      out.close();
   }
   
   public static class Node implements Comparable<Node>{
      int v;
      int rank;
      
      public Node(int a, int b){
         v = a;
         rank = b;
      }
      public int compareTo(Node n){
         return rank-n.rank;
      }
   }
   
   public static class Edge{
      int to;
      int index;
      
      public Edge(int a, int b){
         to = a;
         index = b;
      }
   }
      
}