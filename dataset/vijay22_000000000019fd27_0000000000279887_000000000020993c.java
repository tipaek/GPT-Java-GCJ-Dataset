import java.util.*;
class test{
    public static void main(String[] arg)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int sum=0;
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            }
               for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(i==j)
                    sum=sum+arr[j][k];
                }
            }
            //  for(int j=0;j<n;j++)
            // {
            //     for(int k=0;k<n;k++)
            //     {
            //         if(arr[j][k]==arr)
            //         sum=sum+arr[j][k];
            //     }
            // }
            
            System.out.println(sum);
    
        }
    }
}