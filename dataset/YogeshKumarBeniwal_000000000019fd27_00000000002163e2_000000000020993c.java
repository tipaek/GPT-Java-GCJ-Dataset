import java.util.*;

public class Solution 
{
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for(int ii=0; ii<t; ii++)
        {
            int n = in.nextInt();
            int arr[][] = new int[n][n];
            int trace = 0;
            int rr=0;
            int cc=0;
            boolean rf[] = new boolean[n];
            for(int i=0; i<n; i++)
            {
                boolean cf = true;
                for(int j=0; j<n; j++)
                {
                    int no = in.nextInt();
                    if(cf && ContainC(i, no, arr))
                    {
                        cf=false;
                        cc++;
                    }
                    if(!rf[j] && ContainR(j, no, arr))
                    {
                        rf[j]=true;
                        rr++;
                    }
                    arr[i][j] = no;
                    if(i==j)
                    {
                        trace += no;
                    }
                }
            }
            System.out.println("Case #"+(ii+1)+": "+trace+" "+cc+" "+rr);
        }
    }
    public static boolean ContainC(int j, int x, int arr[][])
    {
        int i=0;
        while(i<arr.length && arr[j][i]!=0)
        {
            if(arr[j][i]==x)
            {
                return true;
            }
            i++;
        }
        return false;
    }
    public static boolean ContainR(int j, int x, int arr[][])
    {
        int i=0;
        while(i<arr.length && arr[i][j]!=0)
        {
            if(arr[i][j]==x)
            {
                return true;
            }
            i++;
        }
        return false;
    }
}