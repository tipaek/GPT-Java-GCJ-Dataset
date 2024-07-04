import java.util.*;
public class Solution
{
    static int n;
    public static void main(String args[])
    {
        Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int c=1;
            n=sc.nextInt();
            int k=sc.nextInt();
            int a[][]=new int[n][n];
            int b[][]=new int[n][n];
            int f=0;
            for(int j=0;j<n;j++)
            {
                if(k==(j+1)*n)
                {
                    f=1;
                   System.out.println("Case #"+i+": "+"POSSIBLE");
                   break;
                }
                for(int m=0;m<n;m++)
                {
                    if(c>n) c=1;
                    a[j][m]=b[m][j]=c++;
                    
                }
                
                c=c-1;
            }
            
            if(f==0)
            {if(arrange(a,k)||arrange(b,k))
            System.out.println("Case #"+i+": "+"POSSIBLE");
            else
            System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            }
        }
    }
    static boolean check(int a[][],int k)
    {
        
        int c=0,t=0;
        for(int i=0;i<n;i++)
        {c=c+a[i][i];t+=a[i][n-i-1];
        }
        if(c==k||t==k)
        return true;
        return false;
    }
    static boolean arrange(int a[][],int k)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(j==i)
                {
                    if(check(a,k)||check2(a,k))
                return true;
                    continue;
                    }

                int d[]=a[i];
                a[i]=a[j];
                a[j]=d;
                if(check(a,k))
                return true;
               
                
                
                
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                interchange(a ,i,j);printMat(a);System.out.println();
                if(check(a,k)||check2(a,k))
                return true;
                
                
                
            }
        }
        
        return false;
    }
    static void printMat(int a[][])
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(a[i][j]+" ");
            System.out.println();
            
        }
    }
    static void interchange(int a[][],int i,int j)
    {
        for(int k=0;k<n;k++)
        {
            int t=a[k][i];
            a[k][i]=a[k][j];
            a[k][j]=t;
        }
    }
    static boolean check2(int a[][],int k)
    {
        int b=0,c=0;
        for(int i=2;i<n-n/2;i++)
        {
            int j=0;
            for( j=0;j<n-i;j++)
            {
                b=b+a[i][j]+a[j][i];
                c=c+a[n-1-i][j]+a[j][n-1-i];
            }
            c+=a[n-j][j];
            b=b+a[j][j];
            if((b==k||c==k))
            return true;
            c=0;b=0;
        }
        return false;
    }
}
