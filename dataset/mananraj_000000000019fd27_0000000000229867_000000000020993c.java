import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();int kk= 1;
        while(t-->0)
        {
            int k=0,r=0,c=0,s=0,rr;long ss=0;
            int mat[][]=new int[1000][1000];
            int mat1[][]=new int[1000][1000];
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
                    mat1[i][j]=mat[j][i];
                }
            }
            for (int i = 0; i < n; i++) 
            {             
                for (int j = 0; j < n; j++) 
                { 
                    for (k = 0; k < n - j - 1; k++) 
                    { 
                        if (mat[i][k] > mat[i][k + 1]) 
                        { 
                            rr = mat[i][k]; 
                            mat[i][k] = mat[i][k + 1]; 
                            mat[i][k + 1] = rr; 
                        } 
                        if (mat1[i][k] > mat1[i][k + 1]) 
                        {  
                            rr = mat1[i][k]; 
                            mat1[i][k] = mat1[i][k + 1]; 
                            mat1[i][k + 1] = rr; 
                        } 
                    } 
                } 
            }
            for(int i=0;i<n;i++)
            {
                rr=0;k=0;
                for(int j=0;j<(n-1);j++)
                {
                    if(mat[i][j]==mat[i][j+1])
                    rr++;
                    if(mat1[i][j]==mat1[i][j+1])
                    k++;
                }
                if(rr>0)
                r++;
                if(k>0)
                c++;
            }
            System.out.println("Case #"+kk+": "+ss+" "+r+" "+c);
            kk++;
        }
        
    }
}