import java.util.*;
class Solution
{
    static Scanner sc=new Scanner(System.in);
    static int cou=0;
    public static void main(String args[])
    {
        if(sc.hasNext())
       {
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int n1=sc.nextInt();
            int[][] arr=new int[n1][n1];
            for(int j=0;j<n1;j++)
            {
                for(int k=0;k<n1;k++)
                {
                    arr[j][k]=sc.nextInt();
                }
            
            }
            check(arr);
            
        }
       }
    }
    public static void check(int[][] arr)
    {
        cou++;
        int sum=0;
        int r=0;
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i][i];
            HashSet<Integer> ro=new HashSet<Integer>();
            HashSet<Integer> co=new HashSet<Integer>();
            for(int j=0;j<arr.length;j++)
            {
                ro.add(arr[i][j]);
                co.add(arr[j][i]);
            }
            if(ro.size()!=arr.length)
            r++;
            if(co.size()!=arr.length)
            c++;
        }
        System.out.println("Case #"+cou+": "+sum+" "+r+" "+c);
    }
}