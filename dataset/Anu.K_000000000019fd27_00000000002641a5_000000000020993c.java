import java.util.*;
import java.io.*;
class Codejam1
{
    public int trace(int[][] m,int n )
    {
       int sum=0;
       for(int i=0;i<n;i++ )
       {
           sum+=m[i][i];

       }
       return sum;
    }
    public int rowrepeat(int [][]m,int n)
    {
       int r=0; 
       for(int i=0;i<n;i++)
        {
             int flag=0;
            for(int j=0;j<n;j++)
            {
                int el=m[i][j];
                int k=j+1;
                while(k<n)
                {
                    if(el==m[i][k])
                    {
                        flag++;
                    }
                    k++;
                }

            }
            if(flag!=0)
             r++;
        }
        return r;
    }
    public int colrepeat(int[][] m,int n)
    {
         int c=0; 
       for(int i=0;i<n;i++)
        {
             int flag=0;
            for(int j=0;j<n;j++)
            {
                int el=m[j][i];
                int k=j+1;
                
                while(k<n)
                {
                    if(el==m[k][i])
                    {
                        flag++;
                        //System.out.println("Value of "+el +"at"+k);
                    }
                    k++;
                }
               
            }
            if(flag!=0)
                  c++;
            
        }
        return c;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Codejam1 c1=new Codejam1();
        int t= sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    m[j][k]=sc.nextInt();
                }
                
            }
            int dia=c1.trace(m,n);
            int rr=c1.rowrepeat(m,n);
            int cr=c1.colrepeat(m,n);
            System.out.println("Case #"+i+": "+dia+" "+rr+" "+cr);
        }
    }
}