import java.util.*;
class solution{
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        int p=1;

        while(t!=0)
        {
            int n=ob.nextInt();
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=ob.nextInt();
                }
            }
            int flag=0,r=0; 
            int diagonal=0 ;
            
            for(int i=0;i<n;i++)
            {
                flag=0;  
                int[] dp=new int[n]; 
                for(int j=0;j<n;j++)
                {
                    if(i==j)
                        diagonal+=arr[i][j];
                    if(dp[arr[i][j]-1]==1)
                        flag=1;
                    else
                       dp[arr[i][j]-1]=1;
                   
                }
                if(flag==1)
                    r+=1;
            }
            int c=0;
           
            for(int i=0;i<n;i++)
            {   
                flag=0;
                int[] dp1=new int[n];
                for(int j=0;j<n;j++)
                {
                    if(dp1[arr[j][i]-1]==0)
                   {
                       dp1[arr[j][i]-1]=1;
                   }else
                   {
                       flag=1;
                   } 
                }
                if(flag==1)
                    c+=1;
            }
            
            System.out.println("Case #"+p+": "+diagonal+" "+r+" "+c);
            t--;
            p++;
        }
    }
}


