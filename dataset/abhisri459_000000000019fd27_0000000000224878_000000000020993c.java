import java.util.*;
public class Trace
{
    public static void main(String[]args)
    {
        int i,t1;
        Scanner ob=new Scanner(System.in);
        t1=ob.nextInt();
        for(i=0;i<t1;i++)
        {
            int sum=0,j,k,r=0,c=0,n=ob.nextInt();
            int arr[][]=new int[n][n];
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                {
                    arr[j][k]=ob.nextInt();
                    if(j==k)
                        sum=sum+arr[j][k];
                }
            }
            for(int t=0;t<n;t++)
            {
                int k1=0;
                for(j=0;j<n;j++)
                {
                    for(k=j+1;k<n;k++)
                    {
                        if(arr[t][j]==arr[t][k])
                        {
                            r++;
                            k1=1;
                            break;
                        }
                    }
                    if(k1==1)
                    {
                        break;
                    }
                }
            }
            for(int t=0;t<n;t++)
            {
                int k1=0;
                for(j=0;j<n;j++)
                {
                    for(k=j+1;k<n;k++)
                    {
                        if(arr[j][t]==arr[k][t])
                        {
                            c++;
                            k1=1;
                            break;
                        }
                    }
                    if(k1==1)
                    {
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
    }
}