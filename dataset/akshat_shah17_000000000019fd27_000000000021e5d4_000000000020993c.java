import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int k=0,r=0,c=0;
            int[][] arr=new int[n][n];
            for(int j=0;j<n;j++)
            {
                Set<Integer> s=new HashSet<>();
                for(int l=0;l<n;l++)
                {
                    arr[j][l]=sc.nextInt();
                    if(j==l)
                        k+=arr[j][l];
                    s.add(arr[j][l]);
                }
                if(s.size()!=n)
                    r++;
            }
            for(int j=0;j<n;j++)
            {
                Set<Integer> s=new HashSet<>();
                for(int l=0;l<n;l++)
                {
                    s.add(arr[l][j]);
                }
                if(s.size()!=n)
                    c++;
            }
            System.out.println("Case #"+i+": "+k+" "+r+" "+c);
        }
    }
}