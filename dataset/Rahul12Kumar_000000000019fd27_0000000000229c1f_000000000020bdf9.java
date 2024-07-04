
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
			StringBuilder sb = new StringBuilder();
			String a[] = new String[2];
			a[0] = "J";
			a[1] = "C";
			sb.append(a[0]);
			sb.append(a[1]);
			int start1 = arr[0][0];
			int time1 = arr[0][1];
			int start2 = arr[1][0];
			int time2 = arr[1][1];
			boolean flag = false;
			for(int i=2;i<x;i++)
			{
				int start = arr[i][0];
				int end = arr[i][1];
				if(end<start1)
				{
					sb.append(a[0]);
				}
				else if(end<start2)
				{
					sb.append(a[1]);
				}
				else if(time1>start)
				{
				     if(time2>start)
				     {
				    	 flag = true;
				    	 break;
				     }
				     else
				     {
				    	 sb.append(a[1]);
				    	 start2 = start;
				    	 time2=end;
				     }
				}
				else
				{
					sb.append(a[0]);
					start1 = start;
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
