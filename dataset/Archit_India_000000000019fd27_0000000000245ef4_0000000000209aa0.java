import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
    //    System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
          int N=sc.nextInt();int K=sc.nextInt();  
          int[][] M=new int[N][N];  
          for(int j=0;j<N;j++)
          {
              int c=j;
            for(int k=0;k<N;k++)
            {
            M[j][k]=c+1;  
            c=(c+1)%N;            
            }            
            }
         int trace=0;
         for(int j=0;j<N;j++)   
            {
            for(int k=0;k<N;k++)
            {
            //System.out.print(M[j][k]+" ");
            if(j==k)
            trace+=M[j][j];
            }
            //System.out.println();
            }
         String ans="IMPOSSIBLE";
         for(int j=0;j<N-1;j++)
         {
             int k;
            for(k=j+1;k<N;k++)
            {
            int tr=trace-M[j][j]-M[k][k]+M[j][k]+M[k][j];
            if(tr==K)
            {ans="POSSIBLE";break;}
            } 
            if(k<N)
            break;
            
            }
            
         System.out.println("Case #"+i+": "+ans);   
        }
    }
}