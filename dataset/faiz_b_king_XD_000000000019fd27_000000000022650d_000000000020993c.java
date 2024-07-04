import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int cas=1;
        while(t>0)
        {
            t--;
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            HashSet<Integer> s=new HashSet<Integer>();
            int trace=0;
            int r=0;
            int f=0;
            for(int i=0;i<n;i++)
            {
                f=0;
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    if(i==j)
                    {
                        trace=trace+arr[i][j];
                    }
                    if((s.contains(arr[i][j]))&&(f==0))
                    {
                        r++;
                        f=1;
                    }
                    else
                    {
                        s.add(arr[i][j]);
                    }
                }
                s.clear();
            }
            int c=0;
            f=0;
            for(int j=0;j<n;j++)
            {
                f=0;
                for(int i=0;i<n;i++)
                {
                    if((s.contains(arr[i][j]))&&(f==0))
                    {
                        c++;
                        f=1;
                    }
                    else
                    {
                        s.add(arr[i][j]);
                    }
                }
                s.clear();
            }
            System.out.println("Case #"+cas+": "+trace+" "+r+" "+c);
            cas++;
        }
    }
}