import java.util.*;
import java.io.*;
public class Solution
{
    public static boolean check(int start, int end, int[][] ar)
    {
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i][0]==0 && ar[i][1]==0)
            {
                break;
            }
            if(!(start>=ar[i][1] || ar[i][0]>=end))
            {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int k=1;k<t+1;k++)
		{
		    int n = sc.nextInt();
		    int[][] arr = new int[n][2];
		    for(int i=0;i<n;i++)
		    {
		        arr[i][0] = sc.nextInt();
		        arr[i][1] = sc.nextInt();
		    }
		    String s = "";
		    int[][] c = new int[n][2];
		    int[][] j = new int[n][2];
		    int cam=0;
		    int jam=0;
		    for(int i=0;i<n;i++)
		    {
		        if(check(arr[i][0],arr[i][1],c))
		        {
		            s+="C";
		            c[cam][0] = arr[i][0];
		            c[cam][1] = arr[i][1];
		            cam++;
		        }
		        else if(check(arr[i][0],arr[i][1],j))
		        {
		            s+="J";
		            j[jam][0] = arr[i][0];
		            j[jam][1] = arr[i][1];
		            jam++;
		        }
		        else
		        {
		            s="IMPOSSIBLE";
		            break;
		        }
		    }
		    System.out.println("Case #"+k+": "+s);
		}
	}
}
