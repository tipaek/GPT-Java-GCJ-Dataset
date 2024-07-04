import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
      int n;
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      String output[]=new String[n+1];
      String stm;
      for(int i=1;i<=n;i++)
      {
        int task;  
        int s[];
        int e[];
        stm="";
        task=sc.nextInt();
        s=new int[task];
        e=new int[task];
        int c[][]=new int[task][2];
        int j[][]=new int[task][2];
        int c1=0,j1=0;
        for(int t=0;t<task;t++)
        {
            s[t]=sc.nextInt();
            e[t]=sc.nextInt();
            int f=0;
            if(!stm.equals("IMPOSSIBLE"))
            {
                
             for(int k=0;k<c1;k++)
             {
               if((s[t]==c[k][0])||(s[t]<=c[k][0] && e[t]>=c[k][1])||(s[t]>=c[k][0] && s[t]<c[k][1]) ||( e[t]>=c[k][0] & e[t]<=c[k][1]))
                 {
                     f=1;
                 }
             }
             if(f==0)
             {
                 c[c1][0]=s[t];
                 c[c1][1]=e[t];
                 c1++;
                 stm=stm+"C";
             }else{
                f=0;
              for(int k=0;k<j1;k++)
              {
                 if((s[t]==j[k][0])||(s[t]<=j[k][0] && e[t]>=j[k][1])||(s[t]>=j[k][0] && s[t]<j[k][1]) ||( e[t]>=j[k][0] & e[t]<=j[k][1]))
                 {
                     f=1;
                 }
              }
              if(f==0)
              {
                 j[j1][0]=s[t];
                 j[j1][1]=e[t];
                 j1++;
                 stm=stm+"J";
              }else
              {
               stm="IMPOSSIBLE";
              }
            
            }
           }
        }
        output[i]=stm;
      }
      
      for(int i=1;i<=n;i++)
      {
      System.out.println(" Case #"+i+": "+output[i]);        
      }
    }
}