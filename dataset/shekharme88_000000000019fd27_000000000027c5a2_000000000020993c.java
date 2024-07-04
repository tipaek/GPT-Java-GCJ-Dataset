import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            int r=0,c=0,j=0,k=0,z=0,trace=0;
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                mat[j][k]=sc.nextInt();
            }
            for(j=0;j<n;j++)
            {
                trace+=mat[j][j];
                
                for(k=0;k<n;k++)
                {
                    for(z=k+1;z<n;z++)
                    {
                        if(mat[j][k]==mat[j][z])
                        {
                            r++;break;
                        }
                    }
                    if(z<n)
                    break;
                }
                for(k=0;k<n;k++)
                {
                    for(z=k+1;z<n;z++)
                    {
                        if(mat[k][j]==mat[z][j])
                        {
                            c++;break;
                        }
                    }
                    if(z<n)
                    break;
                }
            }
            System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
        
        } 
    }
}