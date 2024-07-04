import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner x =  new Scanner(System.in);
        int t = x.nextInt();
        int trace=0 ; int e ;
        for(int i=0;i<t;i++)
        {
            int n = x.nextInt();
            int arr[][]=new int[n][n];
            for(int a=0;a<n;a++)
            {
                for(int b=0;b<n;b++)
                {
                    e=x.nextInt();
                    arr[a][b]=e;
                    if (a==b)
                    trace+=e;
                }
            }
            
            for(int c=0;c<n;c++)
            {
                for(int d=0;d<n;d++)
                {
                    System.out.print(arr[c][d]);
                }
                System.out.println();
            }
            System.out.println("Case #"+(i+1)+": "+trace);
        }
    }
    
}
