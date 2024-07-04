import java.util.*;
public class Solution
{
    public static void main(String arg[])
    {
        Scanner obj=new Scanner(System.in);
        int test=obj.nextInt();
        for(int t=1;t<=test;t++)
        {
            int n=obj.nextInt();
            int [][]arr=new int[n][n];
            int k=0;
            int r=0,c=0;
            for(int i=0;i<n;i++)
            {
                int []freq=new int[n+1];
                int flag=0;
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=obj.nextInt();
                    if(flag==0 && freq[arr[i][j]]>=1)
                    {
                        flag=1;
                    }
                    else
                        freq[arr[i][j]]++;
                    if(i==j)
                    {
                        k+=arr[i][j];
                    }
                }
                if(flag==1)
                    r++;
            }
            
            for(int j=0;j<n;j++)
            {
                int []freq=new int[n+1];
                int flag=0;
                for(int i=0;i<n;i++)
                {
                    if(flag==0 && freq[arr[i][j]]>=1)
                    {
                        flag=1;
                    }
                    else
                        freq[arr[i][j]]++;
                }
                if(flag==1)
                    c++;
            }
            
            System.out.println("Case #"+t+": "+k+" "+r+" "+c);
        }
        
    }
}