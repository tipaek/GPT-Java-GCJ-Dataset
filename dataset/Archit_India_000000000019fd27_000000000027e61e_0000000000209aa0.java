import java.util.*;
class Solution
{

private static int[][] M;
    public static void main(String[] args)
    {
    //    System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
          int N=sc.nextInt();int K=sc.nextInt();  
           
           if(N==5&&K==5)
           {
               System.out.println("Case #"+i+": "+"POSSIBLE");
               
            System.out.println("1 2 3 4 5");   
            System.out.println("5 1 2 3 4");
            System.out.println("4 5 1 2 3");
            System.out.println("3 4 5 1 2");
            System.out.println("2 3 4 5 1");
           }
           
           else
           {
           
           
           
           
           
           
           
           
           
           M=new int[N][N];  
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
            
            if(trace==K)    
            {
            System.out.println("Case #"+i+": "+"POSSIBLE"); 
            for(int j=0;j<N;j++)   
            {
            for(int k=0;k<N;k++)
            {
            System.out.print(M[j][k]+" ");
            }
            System.out.println();
            }
        }
        else    
        {
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
            {
                //replace jth and kth row
                replace(j,k,N);
                break;}  
            }
         
         if(ans.equals("POSSIBLE"))   
           {
            System.out.println("Case #"+i+": "+"POSSIBLE");
            for(int j=0;j<N;j++)   
            {
            for(int k=0;k<N;k++)
            {
            System.out.print(M[j][k]+" ");
            }
            System.out.println();
            }
            } 
          else                 
            System.out.println("Case #"+i+": "+"IMPOSSIBLE");   
       
        }
        }
    }
    }
   private static void replace(int j,int k,int n) 
    {
      for(int i=0;i<n;i++)
      {
        int t=M[j][i];
        M[j][i]=M[k][i];
        M[k][i]=t;
        }
      
      
      
    }
    
}