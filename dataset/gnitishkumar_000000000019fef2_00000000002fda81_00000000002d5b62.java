import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution{
    static String st="";
    public static void find(long a,long b,long x,long y,long n,long eq,String g)
    { long pow=(1l<<(n-1));
        if(eq==0)
        return;
        if(a==x&&b==y)
        {   if(st.length()==0)
            st=g;
            else if(st.length()>g.length())
            st=g;
            //System.out.print(st.length()+" "+g.length()+" ");
           // st=g;
            return;
        }
        find(a+pow,b,x,y,n+1,eq-1,g+"E");
        find(a-pow,b,x,y,n+1,eq-1,g+"W");
        find(a,b+pow,x,y,n+1,eq-1,g+"N");
        find(a,b-pow,x,y,n+1,eq-1,g+"S");
        
    }
     public static void main(String []args){
         Scanner sc=new Scanner(System.in);
         int i,j,k,n,m,t,c=0;
         long x,y;
         t=sc.nextInt();
         for(i=0;i<t;i++)
         { x=sc.nextLong();
           y=sc.nextLong();
           st="";
           find(0,0,x,y,1,Math.abs(x)+Math.abs(y),"");
           System.out.print("Case #"+(i+1)+": ");
           if(st.equals(""))
           System.out.println("IMPOSSIBLE");
           else
           System.out.println(st);
         }
        
     }
}