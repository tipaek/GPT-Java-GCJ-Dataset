import java.util.*;
class Solution
{ public static int solve(int n,int d, long[] a)
    {
        double[][] dp=new double[n][d];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<d;j++)
            {
                dp[i][j]=(double)a[i]/(double)(j+1);
                //System.out.print(dp[i][j]+" ");

            }
        }
        HashMap<Double,Integer> serves=new HashMap<>();
        HashMap<Double,Integer> slices=new HashMap<>();
        int min_slices=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<d;j++)
            {
                if (!serves.containsKey(dp[i][j]))
                {
                    serves.put(dp[i][j],j+1);
                    slices.put(dp[i][j],j);
                   // System.out.print(j+"lol");

                }
                else{
                    serves.put(dp[i][j],serves.get(dp[i][j])+j+1);
                    slices.put(dp[i][j],slices.get(dp[i][j])+j);
                   // System.out.print(j+"lul");

                    
                }

            if(serves.get(dp[i][j])>=d)
            {
                if (slices.get(dp[i][j])<min_slices)
                {
                    min_slices=slices.get(dp[i][j]);
                }
            }
            }
        }
        return min_slices;

    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int temp=1;
        while(temp<=t)
        {
            int n=s.nextInt();
            int d=s.nextInt();
            long a[]=new long[n];
            for(int i=0;i<n;i++)
            {
                a[i]=s.nextLong();
            }
        Arrays.sort(a);
            int ans=solve(n,d,a);
       
       
         System.out.println("Case #"+temp+": "+ans);
        
        temp++;
        }
    }

}