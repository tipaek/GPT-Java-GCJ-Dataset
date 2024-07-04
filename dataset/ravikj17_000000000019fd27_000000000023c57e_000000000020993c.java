import java.util.*;
public class Solution
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cs=1;
        while(t-->0)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            int n=sc.nextInt();
            int r=0,c=0;
            int arr[][]=new int[n][n];
            int trace=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int p=sc.nextInt();
                    arr[i][j]=p;
                    if(i==j)
                    {
                        trace=trace+arr[i][j];
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                l.add(arr[i][0]);
                for(int j=1;j<n;j++)
                {
                    if(l.contains(arr[i][j]))
                    {
                        r++;
                        break;
                    }
                    else
                        l.add(arr[i][j]);
                }
                l.clear();
            }
            for(int j=0;j<n;j++)
            {
                l.add(arr[0][j]);
                for(int i=1;i<n;i++)
                {
                    if(l.contains(arr[i][j]))
                    {
                        c++;
                        break;
                    }
                    else
                    l.add(arr[i][j]);
                }
                l.clear();
            }
            System.out.println("Case #" + cs + ": " + trace + " " + r + " " + c);
            cs++;
        }
    }
}
