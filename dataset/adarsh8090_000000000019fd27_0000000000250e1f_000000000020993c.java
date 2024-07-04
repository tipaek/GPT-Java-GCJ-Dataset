import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
    Scanner in= new Scanner (System.in);
    int t=in.nextInt();
    for (int i=1;i<=t;i++)
    {   
        int n=in.nextInt();
        int a[][]=new int[n][n];
        int b[][]=new int[n][n];
        int sum=0,count1=0,count2=0;
        for (int j=0;j<n;j++)
        {
            for (int k=0;k<n;k++)
            {
                a[j][k]=in.nextInt();
                b[j][k]=a[j][k];
                if(j == k)
                {
                    sum=sum+a[j][k];
                    //System.out.println(a);
                }
            }
        }
        for (int g=0;g<n;g++)
        {
        for (int j=0;j<n;j++)
        {
            for (int k=1;k<n;k++)
            {
                if(g!=k)
                {
                if(b[j][g] == b[j][k] && b[j][k]>0)
                {
                    count1++;
                    for(int l=0;l<n;l++)
                    {
                        b[j][l]=-1;
                    }
                    break;
                }
                }
            }
        }
        }
        for (int g=0;g<n;g++)
        {
        for (int j=0;j<n;j++)
        {
            for (int k=1;k<n;k++)
            {
                if(g!=k)
                {
                if(a[g][j] == a[k][j] && a[k][j]>0)
                {
                    count2++;
                    for(int l=0;l<n;l++)
                    {
                        a[l][j]=-1;
                    }
                    break;
                }
                }
            }
        }
        }
        System.out.println("Case #"+i+":"+sum+" "+count1+" "+count2);
    }
    }
}