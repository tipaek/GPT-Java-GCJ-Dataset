import java.util.*;
class Solution{
    public static void main(String []args)
    {
        HashSet<Integer> h=new HashSet<>();
        Scanner sc=new Scanner(System.in);
        int T,N;
        T=sc.nextInt();
        for(int i=0;i<T;i++)
        {
            
            N=sc.nextInt();
            int arr[][]=new int[N][N];
             int row_count=0,col_count=0,trace=0;
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                {
                    arr[j][k]=sc.nextInt();
                    if(j==k)
                    trace+=arr[j][j];
                }
                
                
            }
            
           
            //For calculating the rows with duplicates
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
               {
                   if(h.contains(arr[j][k]))
                   {
                       row_count++;
                       break;
                       
                   }
                   h.add(arr[j][k]);
               }
               h.clear();
                
            }
            h.clear();
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
               {
                   if(h.contains(arr[k][j]))
                   {
                       col_count++;
                       break;
                       
                   }
                   h.add(arr[k][j]);
               }
               h.clear();
                
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+row_count+" "+col_count);
            
        }
    }
}