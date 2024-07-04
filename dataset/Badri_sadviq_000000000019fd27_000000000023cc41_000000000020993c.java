import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        int i,j,k;
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(i=0;i<t;i++)
        {
            int sum=0;
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            }
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                {
                    if(j==k)
                    {
                        sum=sum+arr[j][k];
                    }
                }
            }
            System.out.print("Case #"+(i+1)+sum);
        }
    }
}