
import java.util.Arrays;
import java.util.Scanner;

class node implements Comparable<node>{
	int s;
	int e;
	node(int s , int e)
	{
		this.s = s;
		this.e = e;
	}
	public int compareTo(node a)
	{
		if (this.s==a.s)
			return this.e-a.e;
		else
			return this.s-a.s;
	}
}
public class Solution {
	public static String helper(node[] arr)
	{
		Arrays.sort(arr);
		for (node a:arr)
		{
			System.out.println(a.s+" "+a.e);
		}
		int cb = -1;
		int jb = -1;
		StringBuilder res = new StringBuilder("");
		for (int i=0;i<arr.length;i++)
		{
			if (cb==-1)
			{
				cb = arr[i].e;
				res.append("C");
			}
			else if (jb==-1)
			{
				jb = arr[i].e;
				res.append("J");
			}
			else if (arr[i].s<cb && arr[i].s<jb)
			{
				return "IMPOSSIBLE";
			}
			else if (arr[i].s<cb)
			{
				res.append("J");
				jb = arr[i].e;
			}
			else
			{
				res.append("C");
				cb = arr[i].e;
			}
		}
		return String.valueOf(res);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int z=1;
        while(z<=t)
        {
            	int n = s.nextInt();
            	node[] arr = new node[n];
            	for (int i=0;i<n;i++)
            		arr[i] = new node(s.nextInt() , s.nextInt());
            	String ans="Case #"+z+": "+helper(arr);
                
                System.out.println(ans);
            z++;
        }

	}

}
