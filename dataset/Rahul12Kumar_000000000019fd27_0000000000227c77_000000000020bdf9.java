
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int k=1;k<=n;k++)
		{
			int x = sc.nextInt();
			int arr[][] = new int[x][2];
			for(int i=0;i<x;i++)
			{
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			Arrays.sort(arr,(a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
			StringBuilder sb = new StringBuilder();
			String a[] = new String[2];
			a[0] = "C";
			a[1] = "J";
			sb.append(a[0]);
			sb.append(a[1]);
			int time1 = arr[0][1];
			int time2 = arr[1][1];
			boolean flag = false;
			for(int i=2;i<x;i++)
			{
				int start = arr[i][0];
				int end = arr[i][1];
				if(time1>start)
				{
				     if(time2>start)
				     {
				    	 flag = true;
				    	 break;
				     }
				     else
				     {
				    	 sb.append(a[1]);
				    	 time2=end;
				     }
				}
				else
				{
					sb.append(a[0]);
					time1=end;
				}
			}
			if(flag)
			System.out.println("Case #"+(k)+": "+"IMPOSSIBLE");
			else
			System.out.println("Case #"+(k)+": "+sb.toString());
		}
		sc.close();
	}

}
