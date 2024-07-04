import java.util.*;
public class Solution
{
    public static void main(String[] args)
    
    {
        Scanner sc = new Scanner(System.in);
        
        int test=sc.nextInt();
        for(int p=1;p<=test;p++)
        {
            int n=sc.nextInt();
            int[][] li=new int[n][2];
            int[][] li1=new int[n][2];
            
            for(int q=0;q<n;q++)
            {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                li[q][0]=v1;
                li[q][1]=v2;
                li1[q][0]=v1;
                
                li1[q][1]=v2;
            }
            for(int q=0;q<n-1;q++)
            {
            for(int r=0;r<n-q-1;r++)
                {
                    if(li[r][0]>li[r+1][0])
                    {
                       int t = li[r][0];
                       li[r][0] = li[r+1][0];
                       li[r+1][0] = t;
                       t = li[r][1];
                    li[r][1] = li[r+1][1];
                    li[r+1][1] = t;
                }
                    if(li[r][0]==li[r+1][0])
                    {
                        if(li[r][1]>li[r+1][1])
                       {
                           int t = li[r][1];
                        li[r][1] = li[r + 1][1];
                        li[r + 1][1] = t;
                       }
                  }
                }
            }
            char[] chr=new char[n];
            int lc=-1;
            int lf=-1;
            int f=0;
            for(int q=0;q<n;q++)
            {
                int v=-1;
                for(int r=0;r<n;r++)
                {
                    if(li[q][0]==li1[r][0] && li[q][1]==li1[r][1])
                    {
                        li1[r][0]=-1;
                        li1[r][1]=-1;
                        v=r;
                        break;
                    }
                }
                if(li[q][0]>=lc)
                {
                    chr[v]='C';
                    lc=li[q][1];
                }
                else if(li[q][0]>=lf)
                {
                    chr[v]='J';
                    lf=li[q][1];
                }
                else
                {
                    f=1;
                    break;
                }
            }
            String str= new String(chr);
            if(f==0)
                System.out.println("Case #"+p+": "+str);
            else
                System.out.println("Case #"+p+": IMPOSSIBLE");
        }
    }
}