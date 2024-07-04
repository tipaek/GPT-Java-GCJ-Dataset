import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();int kk= 1;
        while(t-->0)
        {
            int k=0,r=0,c=0,s=0,ss=0,rr;
            int mat[][]=new int[10000][10000];
            int n=in.nextInt();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j]=in.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                    ss+=mat[i][j];
                    rr=mat[i][j];
                    for(k=(j+1);k<n;k++)
                    {
                        if(mat[i][k]==rr)
                        {
                            s=10;
                            break;
                        }
                    }
                    if(s==10)
                    {
                        r++;
                        s=0;
                    }
                    rr=mat[j][i];
                    for(k=(i+1);k<n;k++)
                    {
                        if(mat[j][k]==rr)
                        {
                            s=10;
                            break;
                        }
                    }
                    if(s==10)
                    {
                        c++;
                        s=0;
                    }
                }
            }
            System.out.println("Case #"+kk+": "+ss+" "+r+" "+c);
            
        }
        
    }
}