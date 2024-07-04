import java.util.*;
import java.io.*;

public class Solution {

	public static int n;
	public static int d;
	public static int k;
	public static double[] arr;
	public static double[] sum;
	public static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int tc=1;
		while (t-->0)
		{
			String inp[]=br.readLine().split(" ");
			n=Integer.parseInt(inp[0]);
			d=Integer.parseInt(inp[1]);
			inp=br.readLine().split(" ");
			HashSet<Double> set=new HashSet<>();
			HashMap<Double, Integer> map=new HashMap<>();
			arr=new double[n];
			int maxcount=0;
			for (int i=0;i<n;i++)
			{
				arr[i]=(1000000000*Double.parseDouble(inp[i]));
				set.add(arr[i]);
				map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
				maxcount=Math.max(maxcount, map.get(arr[i]));
			}
//			if (n>=d)
//			{
//				System.out.println("Case #" + tc+": 0");
//				tc++;
//				continue;
//			}
			if (d==2)
			{
				if (n==1)
					System.out.println("Case #" + tc+": 1");
				else
				{
					if (set.size()<n)
						System.out.println("Case #" + tc+": 0");
					else
						System.out.println("Case #" + tc+": 1");
				}
			}
			else if (d==3)
			{
				if (n==1)
					System.out.println("Case #" + tc+": 2");
				else if (n==2)
				{
					if (arr[0]/2==arr[1] || arr[1]/2==arr[0])
						System.out.println("Case #" + tc+": 1");
					else
						System.out.println("Case #" + tc+": 2");
				}
				else
				{
					if (maxcount==2)
						System.out.println("Case #" + tc+": 1");
					else if (maxcount>=3)
						System.out.println("Case #" + tc+": 0");
					else
						System.out.println("Case #" + tc+": 2");
				}
			}
			tc++;
		}
	}
}