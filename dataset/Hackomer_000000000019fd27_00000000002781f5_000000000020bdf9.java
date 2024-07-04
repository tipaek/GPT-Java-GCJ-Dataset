import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])throws java.lang.Exception
    {
        Scanner in=new Scanner(System.in);
        try{
        String st="";int S[],E[],N,i,T,j;char p='C';boolean h=false;
        T=in.nextInt();
        if(T>=1&&T<=100)
        {
         for(j=1;j<=T;j++)
         {
              N=in.nextInt();
              h=false;
              st="";
              if(N>=2&&N<=1000)
              {
                  S=new int[N];
        E=new int[N];
        st+=p;
        for(i=0;i<N;)
        {
            S[i]=in.nextInt();
            E[i]=in.nextInt();
            if(S[i]>=0&&S[i]<E[i]&&E[i]<=1440)
            i++;
        }
        for(i=0;i<N-1;i++)
        {
            if(i+2<N&&E[i]>S[i+1]&&E[i+1]<=S[i+2])
            {
                if(p=='C')
                p='J';
                else
                p='C';
                st+=p;
            }
            else if(E[i]<=S[i+1])
            st+=p;
            else
            {
                h=true;
            }
        }
        if(h==true)
        System.out.println("Case #"+j+": IMPOSSIBLE");
        else
        System.out.println("Case #"+j+": "+st);
              }
         }
        }
        }catch(Exception e)
        {
            return;
        }
    }
}