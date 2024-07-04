import java.util.*;
class Solution
{

private static class Node
{
public int Si,Ei;
Node(int s,int e)
{
Si=s;Ei=e;
}
}

    public static void main(String[] args)
    {
        //System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
         int N=sc.nextInt();
         PriorityQueue<Node> pq=new PriorityQueue<Node>(N,new Comparator<Node>(){
            public int compare(Node n1,Node n2)
            {
               if(n1.Si>n2.Si)
               return 1;
               else
               return -1;
            }
            });
            int[] C=new int[1445];int[] S=new int[1445];
         for(int j=0;j<N;j++)
         {
             int s=sc.nextInt();int e=sc.nextInt();
            Node n=new Node(s,e);
            pq.add(n);
            
         }                          
         String ans="";
         while(pq.peek()!=null)
         { 
         Node n=pq.poll();int cfree=1;int sfree=1;   
         //System.out.println(n.Si+" , "+n.Ei);
            for(int k=n.Si;k<n.Ei;k++)
            {
                if(C[k]==1)
                {cfree=0;break;}
            }
            for(int k=n.Si;k<n.Ei;k++)
            {
                if(S[k]==1)
                {sfree=0;break;}
            }
            
         if(cfree==0&&sfree==0)   
            {ans="IMPOSSIBLE";break;}
         else if(cfree==1)
         {
            for(int k=n.Si;k<n.Ei;k++)
            C[k]=1;
            ans+='C';
            }
         else
         {
            for(int k=n.Si;k<n.Ei;k++)
            S[k]=1;
            ans+='J';
            }
         }
         
         
         System.out.println("Case #"+i+": "+ans);
        }
    }
}