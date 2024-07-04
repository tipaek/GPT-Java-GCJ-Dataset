import java.util.*;
class Solution
{
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    
    int T=sc.nextInt();
    
    for(int x=1;x<=T;x++)
    {
        int N=sc.nextInt();
        int A[][]=new int[N][N];
        int B[][]=new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                A[i][j]=sc.nextInt();
                B[j][i]=A[i][j];
            }
        }
        int r=0; int c=0;long k=0;
        
        for(int i=0;i<N;i++)
        k+=A[i][i];
        
        for(int i=0;i<N;i++)
        {
            Arrays.sort(A[i]);
            for(int j=1;j<N-1;j++)
            {
                if(A[i][j]==A[i][j-1] || A[i][j]==A[i][j+1])
                {r++;break;}
            }
            
        }
        
        for(int i=0;i<N;i++)
        {
            Arrays.sort(B[i]);
            for(int j=1;j<N-1;j++)
            {
                if(B[i][j]==B[i][j-1] || B[i][j]==B[i][j+1])
                {c++;break;}
            }
            
        }
        
        
            System.out.println("Case #"+x+": "+k+" "+r+" "+c);
        
        
    
        
        
        
    }
}}