import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=1; i<=t; i++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][2];
            
            for (int j=0; j<n; j++)
            {
                for (int k=0; k<2; k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            }
            
            String s="CJ";
            int cm=0;
            int jm=1;
            
            for (int j=2; j<n; j++)
            {
                if (arr[j][1]<=arr[cm][0] || arr[j][0]>=arr[cm][1])
                {
                    s=s+"C";
                    cm=j;
                }
                else if (arr[j][1]<=arr[jm][0] || arr[j][0]>=arr[jm][1])
                {
                    s=s+"J";
                    jm=j;
                }
                else
                {
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                    break;
                }
            }
            if (s.length()==n)
            {
                System.out.println("Case #"+i+": "+s);
            }
        }
    }
}