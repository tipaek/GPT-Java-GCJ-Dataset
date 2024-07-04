import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
//        System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
         int N=sc.nextInt();   
         int[][] M=new int[N][N];int trace=0;   
         for(int j=0;j<N;j++)   
            {
               for(int k=0;k<N;k++)
               {
                M[j][k]=sc.nextInt();
                if(j==k)
                trace+=M[j][j];
                }                       
            }
            
            int rc=0;
         for(int j=0;j<N;j++)
         {
            int[] freq=new int[N];    
            for(int k=0;k<N;k++)
            {
              freq[M[j][k]-1]+=1;
              if(freq[M[j][k]-1]>1)
              {rc++;break;}
            }                     
            }
          int cc=0;
             for(int j=0;j<N;j++)
            {
            int[] freq=new int[N];    
            for(int k=0;k<N;k++)
            {
              freq[M[k][j]-1]+=1;
              if(freq[M[k][j]-1]>1)
              {cc++;break;}
            }                     
            }
            
         System.out.println("Case #"+i+": "+trace+" "+rc+" "+cc);   
            
            
        }
    }
}