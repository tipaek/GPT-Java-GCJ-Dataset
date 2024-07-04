import java.util.Scanner;
public class Solution
{
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();int k,r,c;
        int n;int ar[][];int freq[];
        for(int t1=0;t1<t;t1++)
        {
            n=sc.nextInt();ar=new int[n][n];
            freq=new int[n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++) 
                    ar[i][j]=sc.nextInt();
            k=0;r=0;c=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++) freq[j]=0;
                for(int j=0;j<n;j++)
                {
                    freq[ar[i][j]-1]++;
                    if(freq[ar[i][j]-1]>1)
                    {r++;break;}
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++) freq[j]=0;
                for(int j=0;j<n;j++)
                {
                    freq[ar[j][i]-1]++;
                    if(freq[ar[j][i]-1]>1)
                    {c++;break;}
                }
            }
            for(int i=0;i<n;i++) k+=ar[i][i];
            System.out.println("Case #"+(t1+1)+": "+k+" "+r+" "+c);
        }
    }
}