import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            String s="";
            int n=sc.nextInt();
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<2;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<2;j++)
                {
                    //s=s+'C';
                }
                s=s+'C';
            }
            System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
            
        }
    }
}