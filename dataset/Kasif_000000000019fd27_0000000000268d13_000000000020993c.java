import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner( System.in);
        int T=sc.nextInt();
        
        
        for(int i=1;i<=T;i++)
        {
            int N=sc.nextInt();
            int A[][]=new int[N][N];
            int sum=0;
            for(int j=0;j<N;j++)
            {
                
                for(int k=0;k<N;k++)
                {
                    A[j][k]=sc.nextInt();   
                    if(j==k)
                    sum+=A[j][k];
                }    
            }
            int r=0,j,k;
            boolean visited[]=new boolean[N+1];
            for(j=0;j<N;j++)
            {
                Arrays.fill(visited,false);
                for(k=0;k<N;k++)
                    {
                        if(!visited[A[j][k]])
                        visited[A[j][k]]=true;
                        else{
                        r++;
                        break;}
                    }
                }
            int c=0;
            Arrays.fill(visited,false);
            for(j=0;j<N;j++)
            {
                Arrays.fill(visited,false);
                for(k=0;k<N;k++)
                    {
                        if(!visited[A[k][j]])
                        visited[A[k][j]]=true;
                        else{
                        c++;
                        break;}
                    }
            }
            System.out.println("Case #"+i+": "+sum+" "+r+" "+c);
            
        }
    }
}