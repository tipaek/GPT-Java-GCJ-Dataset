import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n,a[][],sum,flag,r,c;
        for(int i=0;i<t;i++)
        {
            n = sc.nextInt();
            a = new int[n][n];
            sum = 0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k] = sc.nextInt();
                    if(j==k)
                    {
                        sum = sum+a[j][k];
                    }
                }
            }
            //for number of rows
            r = 0;
            flag = 0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(a[j][k]==a[j][l])
                        {
                            r++;
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                }
            }
            //for number of coloumns
            c = 0;
            flag = 0;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    for(int l=k+1;l<n;l++)
                    {
                        if(a[k][j]==a[l][j])
                        {
                            c++;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
    }
}