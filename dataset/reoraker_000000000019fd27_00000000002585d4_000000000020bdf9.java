import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    static int n;   
    static LinkedList<Integer> adj[]; //Adjacency Lists 
    static int[] color;
    static boolean flag=true;
    static boolean[] visited;
    static void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
        adj[w].add(v);
    } 
  
    // prints BFS traversal from a given source s 
    static void BFS(int s) 
    { 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        visited[s]=true; 
        color[s]=1;
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            s = queue.poll(); 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if(color[s]==color[n])
                {
                    flag=false;
                    break;
                }
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    color[n]=(color[s]==1)?2:1;
                    queue.add(n); 
                } 
            } 
        } 
    }

    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            n=in.nextInt();
            flag=true;
            adj = new LinkedList[n]; 
            for (int i=0; i<n; ++i) 
                adj[i] = new LinkedList(); 

            color=new int[n];
            visited=new boolean[n];
            int[] s=new int[n];
            int[] e=new int[n];
            for(int i=0;i<n;i++)
            {
                s[i]=in.nextInt();
                e[i]=in.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(e[i]>s[j] && s[i]<e[j])
                        addEdge(i,j);
                }
            }
            while(true)
            {
                int start=0;
                boolean f=false;
                for(int i=0;i<n;i++)
                {
                    if(visited[i]==false)
                    {
                        start=i;
                        f=true;
                        break;
                    }
                }
                if(f==false)
                    break;
                //System.out.println(start);
                BFS(start);
            }
            if(flag==false)
                System.out.println("IMPOSSIBLE");
            else
            {
                for(int i=0;i<n;i++)
                {
                    if(color[i]==1)
                        System.out.print("J");
                    else if(color[i]==2)
                        System.out.print("C");
                }
                System.out.println();
            }
        }
    }

}
