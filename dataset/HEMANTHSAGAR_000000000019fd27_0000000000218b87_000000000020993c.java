import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i1=1;i1<=t;i1++)
        {
            int n=sc.nextInt();
            int[][] arr=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            int r1=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> arr1=new HashSet<Integer>();
                int f1=0;
                for(int j=0;j<n;j++)
                {
                    if(arr1.contains(arr[i][j]))
                    {
                        f1=1;
                        break;
                    }
                    else
                    arr1.add(arr[i][j]);
                }
                if(f1==1)
                ++r1;
            }
            int c1=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> arr1=new HashSet<Integer>();
                int f1=0;
                for(int j=0;j<n;j++)
                {
                    if(arr1.contains(arr[j][i]))
                    {
                        f1=1;
                        break;
                    }
                    else
                    arr1.add(arr[j][i]);
                }
                if(f1==1)
                ++c1;
            }
            int t1=0;
            for(int i=0;i<n;i++)
                t1=t1+arr[i][i];
            System.out.println("Case #"+i1+": "+t1+" "+r1+" "+c1);
        }
    }
}