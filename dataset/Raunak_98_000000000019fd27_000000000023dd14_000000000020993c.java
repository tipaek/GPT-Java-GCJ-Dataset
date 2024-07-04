import java.util.*;
class Solution
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tc=1;
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[][]=new int[n][n];
            int sum = 0;
            for(int i=-0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                        sum+=arr[i][j];
                }
            }
            int kr = 0;
            int kc = 0;
            int flag =1;
            for(int i =0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int x =arr[i][j];
                    for(int k=j+1;k<n;k++)
                    {
                        if(x==arr[i][k])
                        {
                            kr++;
                            flag=0;
                            break;
                        }
                    }
                    if(flag==0)
                        break;
                }
            }
            flag=1;
            for(int i =0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int y =arr[j][i];
                    for(int k=j+1;k<n;k++)
                    {
                        if(y==arr[k][i])
                        {
                            kc++;
                            flag=0;
                            break;
                        }
                    }
                    if(flag==0)
                        break;
                }
            }
            System.out.println("Case #"+tc+": "+sum+" "+kr+" "+kc);
            tc++;
        }
    }
}