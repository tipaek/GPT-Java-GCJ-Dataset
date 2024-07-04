import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int itest=0;itest<test;itest++)
        {
            int trace=0,col=0,row=0;
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                int flag1=0;
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    {
                        trace+=a[i][j];
                    }
                    if(flag1==0)
                    {
                        for(int k=j-1;k>=0;k--)
                        {
                            if(a[i][j]==a[i][k])
                            {
                                row++;
                                flag1=1;
                                break;
                            }
                        }
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                int flag2=0;
                for(int j=0;j<n;j++)
                {
                    if(flag2==1)
                    {
                        break;
                    }
                    for(int k=j+1;k<n;k++)
                    {
                        if(a[j][i]==a[k][i])
                        {
                            col++;
                            flag2=1;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #"+(itest+1)+": "+" "+trace+" "+row+" "+col);
        }
    }
}