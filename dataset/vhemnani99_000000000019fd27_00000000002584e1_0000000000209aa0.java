import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

            for (int TItr = 1; TItr <=T; TItr++) 
        {
            int n = sc.nextInt();

            int a[][]=new int[n][2];

            for (int i = 0; i < n; i++) 
            {
                for(int j = 0; j < 2; j++)
                {
                    a[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<2;j++)
                {
                    if(a[i][2]==6)
                    System.out.println("Case #1: POSSIBLE");
                    else
                    System.out.println("Case #2: IMPOSSIBLE");
                }
            }
            
        }
    }
}