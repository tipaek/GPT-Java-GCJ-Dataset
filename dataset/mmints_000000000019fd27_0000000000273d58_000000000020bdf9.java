import java.io.*;
import java.util.*;



public class Solution
{

   public static void main(String[] args) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(input.readLine());
      loop:
      for(int t = 1; t <= T; t++)
      {
         int N = Integer.parseInt(input.readLine());
         Node[] nodes = new Node[N];
         for(int i = 0; i < N; i++)
         {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(start, end);
         }
         for(int i = 0; i < N; i++)
         {
            for(int j = 0; j < N; j++)
            {
               if(i != j && nodes[i].overlaps(nodes[j])) nodes[i].connect(nodes[j]);
            }
         }
         System.out.printf("Case #%d: ", t);
         for(Node n : nodes)
         {
            if(n.value == null)
            {
               if(!floodFill(n, true))
               {
                  System.out.println("IMPOSSIBLE");
                  continue loop;
               }
            }
         }
         for(int i = 0; i < N; i++)
         {
            if(nodes[i].value) System.out.print("C");
            else System.out.print("J");
         }
         System.out.println();
      }
   }
   
   public static boolean floodFill(Node n, Boolean val)
   {
      if(n.value != null)
      {
         if(n.value == val) return true;
         return false;
      }
      n.value = val;
      for(Node m : n.neighbors)
      {
         if(!floodFill(m, !val)) return false;
      }
      return true;
   }

}

class Node
{
   
   public int start;
   public int end;
   public ArrayList<Node> neighbors;
   public Boolean value;
   
   public Node(int s, int e)
   {
      start = s;
      end = e;
      neighbors = new ArrayList<Node>();
      value = null;
   }
   
   public boolean overlaps(Node other)
   {
      return start < other.end && end > other.start;
   }
   
   public void connect(Node other)
   {
      neighbors.add(other);
      other.neighbors.add(this);
   }
   
}