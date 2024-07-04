import java.util.*;
public class Solution
{
    static int a[][],c[][],j[][],l,k,t;
    static boolean checkc()
    {
        for(int x=0;x<=t;x++)
        {
            if(a[l][0]>=c[x][0] && a[l][0]<=c[x][1] || a[l][1]>=c[x][0] && a[l][1]<=c[x][1])
                return false;
            else
                return true; 
        }
        return true;
    }
    static boolean checkj()
    {
        for(int x=0;x<=k;x++)
        {
            if(a[l][0]>=j[x][0] && a[l][0]<=j[x][1] || a[l][1]>=j[x][0] && a[l][1]<=j[x][1])
                return false;
            else
                return true; 
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int ttt,tt,n;
        StringBuilder str=new StringBuilder("");
        tt=sc.nextInt();
        for(ttt=1;ttt<=tt;ttt++)
        {   
            n=sc.nextInt();
            a=new int[n][2];
            c=new int[n][2];
            j=new int[n][2];
            for(l=0;l<n;l++)
            {
                for(int ll=0;ll<2;ll++)
                    a[l][ll]=sc.nextInt();
            }
            t=0;
            k=0;
            for(l=0;l<n;l++)
            {
                if(t==0)
                {
                    c[t][0]=a[l][0];
                    c[t][1]=a[l][1];
                    t++;
                    str.append("C");
                }
                else if(checkc())
                {
                    c[t][0]=a[l][0];
                    c[t][1]=a[l][1];
                    t++;
                    str.append("C");
                }
                else if(k==0)
                {
                    j[k][0]=a[l][0];
                    j[k][1]=a[l][1];
                    k++;
                    str.append("J");
                }
                else if(checkj())
                {
                    j[k][0]=a[l][0];
                    j[k][1]=a[l][1];
                    k++;
                    str.append("J");
                }
                else
                {
                    str=str.delete(0,str.length());
                    str.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println("Case #"+ttt+": "+str);
            str=str.delete(0,str.length());
        }
    }
}