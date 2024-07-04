import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
      int n;
      Scanner sc=new Scanner(System.in);
      n=sc.nextInt();
      String output[]=new String[n];
      for(int i=0;i<n;i++)
      {
        int task;  
        int s[];
        int e[];
        output[i]="";
        task=sc.nextInt();
        s=new int[task];
        e=new int[task];
        int c[][]=new int[task][task];
        int j[][]=new int[task][task];
        int c1=0,j1=0;
        for(int t=0;t<task;t++)
        {
            s[t]=sc.nextInt();
            e[t]=sc.nextInt();
            int f=0;
            if(output[i]!="IMPOSSIBLE ")
            {
            for(int k=0;k<c1;k++)
            {
                if((s[t]>c[k][0] && s[t]<c[k][1]) ||( e[t]>c[k][0] & e[t]<c[k][1]))
                {
                    f=1;
                }
            }
            if(f==0)
            {
                c[c1][0]=s[t];
                c[c1][1]=e[t];
                c1++;
                output[i]=output[i]+"J";
            }else{
               f=0;
            for(int k=0;k<j1;k++)
            {
                if(s[t]>j[k][0] && s[t]<j[k][1])
                {
                    f=1;
                }
            }
            if(f==0)
            {
                j[j1][0]=s[t];
                j[j1][1]=e[t];
                j1++;
                output[i]=output[i]+"C";
            }else
            {
                output[i]="IMPOSSIBLE ";
            }
            
            }
           }
        }
      }
      
      for(int i=0;i<n;i++)
      {
      System.out.println(" Case #"+(i+1)+": "+output[i]);        
      }
    }
}