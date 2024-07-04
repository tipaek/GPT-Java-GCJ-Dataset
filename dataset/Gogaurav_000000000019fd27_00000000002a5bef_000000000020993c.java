import java.util.*;
public class Solution
{ 
    static int[] a; 
    static void init(int n)
    {
        for(int t=0;t<n;t++)
        {
            a[t]=-8703;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        int t,tt,i,n,j,m[][],r,c,k,l=0;
        boolean there=false;
        t=sc.nextInt();
        for(tt=1;tt<=t;tt++)
        {   
            n=sc.nextInt();
            m=new int[n][n];
            a=new int[n];
            k=0;
            c=0;
            r=0;
            for(i=0;i<n;i++,there=false,l=0)
            {   
                init(n);
                for(j=0;j<n;j++)
                {
                    m[i][j]=sc.nextInt();
                    if(!there)
                    {
                        for(int ele :a)
                        {
                            if(m[i][j]==ele)
                            {
                                r++;
                                there=true;
                                break;
                            }
                        }
                        if(!there)
                        {   
                            a[l]=m[i][j];
                            l++;
                        }
                    }
                    if(i==j)
                    k+=m[i][j];
                }
                
            }
            for(j=0,there=false;j<n;j++,l=0,there=false)
            {
                init(n);
                for(i=0;i<n;i++)
                {
                    for(int ele :a)
                    {
                        if(m[i][j]==ele)
                        {
                            c++;
                            there=true;
                            break;
                        }
                    }
                    if(!there)
                    {   
                        a[l]=m[i][j];
                        l++;
                    }
                    else
                    break;
                }
            }
            System.out.println("Case #"+tt+": "+k+" "+r+" "+c);
        }
    }
}