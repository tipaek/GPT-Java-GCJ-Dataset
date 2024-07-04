import java.util.*;
class Solution
{

private static class Node
{
public int Si,Ei,index;
Node(int s,int e,int j)
{
Si=s;Ei=e;index=j;
}
}
private static int[] C,S;
private static int N;
private static PriorityQueue<Node> pq;
private static StringBuilder ans; 
   public static void main(String[] args)
    {
        //System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
         N=sc.nextInt();
         
         pq=new PriorityQueue<Node>(N,new Comparator<Node>(){
            public int compare(Node n1,Node n2)
            {
               if(n1.Si>n2.Si)
               return 1;
               else
               return -1;
            }
            });
          C=new int[1440];S=new int[1440];
          
          
         for(int j=0;j<N;j++)
         {
             int s=sc.nextInt();int e=sc.nextInt();
            Node n=new Node(s,e,j);
            pq.add(n);            
         }                          
         
         Node start=pq.poll();
         for(int k=start.Si;k<start.Ei;k++)
         {C[k]=1;
            }
         ans=new StringBuilder(N);ans.setLength(N);        
         ans.setCharAt(start.index,'C');
         
         BinarySearch(2);
         String as="";
         for(int j=0;j<ans.length();j++)
         {
            if(ans.charAt(j)!='\0')
            as+=ans.charAt(j);
            }
         
         if(as.length()!=N)
         as="IMPOSSIBLE";
         else
         { String sol="";
            for(int j=0;j<N;j++)
            sol+=ans.charAt(j);
            as=sol;
            }
     
         System.out.println("Case #"+i+": "+as);
        }
    }
    
    private static void  BinarySearch(int i)
    {
        if(i==N+1)
        return;
        int cfree,sfree;
        Node n=pq.poll();
       
        
        
         for(cfree=n.Si;cfree<n.Ei;cfree++)
           { if(C[cfree]==1)break;}
         for(sfree=n.Si;sfree<n.Ei;sfree++)
           { if(S[sfree]==1)break;}
         
        if(cfree<n.Ei&&sfree<n.Ei)    
        {//both are busy
        pq.add(n);return ;
        }
        else if(cfree<n.Ei)    
        {//Only C is busy
           for(int k=n.Si;k<n.Ei;k++)
           { S[k]=1;}
           ans.setCharAt(n.index,'J');  
           BinarySearch(i+1);
        }
        else if(sfree<n.Ei)
        {//Only J is busy
           for(int k=n.Si;k<n.Ei;k++)
           { C[k]=1;}
           ans.setCharAt(n.index,'C'); 
           BinarySearch(i+1);
        }
        //Both are Free
        else
        {        
        for(int k=n.Si;k<n.Ei;k++)
           { C[k]=1;}
           ans.setCharAt(n.index,'C'); 
        BinarySearch(i+1);
        for(int k=n.Si;k<n.Ei;k++)
           { C[k]=0;S[k]=1;}           
           ans.setCharAt(n.index,'J');
        BinarySearch(i+1); 
    }
    }
}