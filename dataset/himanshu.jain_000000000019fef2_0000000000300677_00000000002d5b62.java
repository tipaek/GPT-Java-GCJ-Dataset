import java.util.Scanner;
import java.util.*;
import java.io.*;
 
public class Solution {
    static class Node {
        int x;
        int y;
        int d;
        String dir;
        Node parent;
        
        public Node(int x, int y, int d, Node parent, String dir) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.dir =dir;
            this.parent = parent;
        }
    }
    
     public static void main(String[] args) {
     
     Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
     int t = in.nextInt();
     for (int m = 1; m <= t; ++m) {
        int X = in.nextInt();
        int Y = in.nextInt();
        boolean isFound = false;
        boolean isPossible = Math.abs(X-Y)%2 == 0 ? false : true;
        Node parent = null;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((x, y)->(x.d - y.d));
        HashSet<String> visited = new HashSet();    
        pq.offer(new Node(0, 0, 0, null, ""));
        while(!pq.isEmpty() && !isFound && isPossible) {
            int size = pq.size();
            for(int i = 0; i < size; i++) {
                Node n = pq.poll();
                int d = n.d;
                int x = n.x;
                int y = n.y;
                int tx = x < 0 ? x*-1 : x;
                int ty = y < 0 ? y*-1 : y;
                if(tx != 0 && ty != 0 && Math.abs(tx-ty) == 0) {
                    isPossible = false;
                    break;
                }
                
                if(x == X && y == Y) {
                    parent = n;
                    isFound  = true;
                    break;
                }
                int nd = d == 0 ? d+1 : 2*d;
                
                String north = x+" "+(y + nd);
                String south = x+" "+(y - nd);
                String east =  (x + nd)+" "+ y;
                String west =  (x - nd)+" "+ y;
                
                if(!visited.contains(north)) {
                    Node nor = new Node(x, y+nd, nd, n, "N");
                    visited.add(north);
                    pq.offer(nor);
                }
                
                if(!visited.contains(south)) {
                    Node sou = new Node(x, y-nd, nd, n, "S");
                    visited.add(south);
                    pq.offer(sou);
                }
                
                if(!visited.contains(east)) {
                    Node eas = new Node(x+nd, y, nd, n, "E");
                    visited.add(east);
                    pq.offer(eas);
                }
                
                if(!visited.contains(west)) {
                    Node wes = new Node(x-nd, y, nd, n, "W");
                    visited.add(west);
                    pq.offer(wes);
                }
            }
        }
       
        if(isFound) {
            System.out.println("Case #"+m+": "+dfs(parent).trim());
        }
        else {
            System.out.println("Case #"+m+": IMPOSSIBLE");
        }
    }
  }
  
  private static String dfs(Node node) {
      if(node == null) return  "";
      String res = dfs(node.parent);
      return res + node.dir;
  }
}