import java.util.*;
import java.io.*;

class Node{
    int st;
    int en;
    int ind;
    
    Node(int a,int b,int c){
        st=a;
        en=b;
        ind=c;
    }
    
    
}

class N implements Comparator<Node>{
    public int compare(Node a,Node b)
    {
        return a.st-b.st;
    }
}

public class Solution{
    public static void main(String[] args)
    {
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        for(int g=1;g<=t;g++)
        {
            int n=sc.nextInt();
            
            Node[] ar=new Node[n];
            for(int i=0;i<n;i++)
            {
                
                int a=sc.nextInt();
                int b=sc.nextInt();
                
                
                ar[i]=new Node(a,b,i);
            }
        
        
        Arrays.sort(ar,new N());
        
        Stack<Node> j1=new Stack<>();
        
        Stack<Node> c1=new Stack<>();
        
        j1.push(ar[0]);
        
        String ans="";
        for(int i=1;i<n;i++)
        {
            if(ar[i].st<j1.peek().en)
            {
                if(c1.size()!=0 && ar[i].st<c1.peek().en)
                {
                    ans="IM";
                    break;
                }
                
                else
                {
                    c1.push(ar[i]);
                }
            }
            
            else
            {
                j1.push(ar[i]);
            }
        }
        
        
        if(ans.equals("IM"))
           System.out.println("Case #"+g+":"+" "+"IMPOSSIBLE");
           
         else
         {
             TreeMap<Integer,String> tm=new TreeMap<>();
             
            for(Node x: j1)
            {
                tm.put(x.ind,"J");
            }
            
            for(Node x: c1)
            {
                tm.put(x.ind,"C");
            }
            
            ans="";
            
            for(int xx: tm.keySet())
              ans=ans+tm.get(xx);
              
              
              System.out.println("Case #"+g+":"+" "+ans);
         }
        
        } 
        
    }
    
    
}