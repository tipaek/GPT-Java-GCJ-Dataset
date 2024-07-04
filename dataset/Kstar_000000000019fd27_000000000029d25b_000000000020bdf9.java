import java.util.*;
import java.io.*;

public class Solution 
{
  public static void main (String [] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(in.readLine());
    for(int i=1; i <= testCases; i++)
    {
      int [] overlaps = new int [24*60+1];
      int num = Integer.parseInt(in.readLine());
      int [][] tasks = new int [num][2];
      for(int x =0; x< num; x++)
      {
        String [] temp = in.readLine().split(" ");
        tasks[x][0] = Integer.parseInt(temp[0]);
        tasks[x][1] = Integer.parseInt(temp[1]);
        overlaps[tasks[x][0]] += 1;
        overlaps[tasks[x][1]] -=1;
      }
      for(int x =1; x<= (24*60); x++)
      {
        overlaps[x] += overlaps[x-1];
      }
      boolean doable = true;
      for(int x =0; x<= (24*60); x++)
      {
        if(overlaps[x] >2)
        {
          doable = false;
        }
      }
      System.out.print("Case #" + i + ": ");
      if(doable)
      {
        PriorityQueue<Node> order = new PriorityQueue<Node>();
        int j=0;
        for(int x =0;x< num; x++)
        {
          order.add(new Node(tasks[x][0], tasks[x][1], x));
        }
        char [] arr = new char[num];
        for (int x =0; x< num; x++)
        {
          Node n = order.poll();
          if(j <= n.start)
          {
            j = n.end;
            arr[n.task] = 'J';
          }
          else
          {
            arr[n.task] = 'C';
          }
        }
        for(int x =0; x< num; x++)
        {
          System.out.print((char)arr[x]);
        }
      }
      else
      {
        System.out.print("IMPOSSIBLE");
      }
      System.out.println();
    }
  }
}

class Node implements Comparable<Node> 
  {
    public int start;
    public int end;
    public int task;
    public Node (int s, int e, int t)
    {
        start = s;
        end = e;
        task = t;
    }
    public int compareTo (Node other)
    {
        return start - other.start;
    }
  }
