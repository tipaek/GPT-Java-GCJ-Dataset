
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
			int max = Integer.MIN_VALUE;
			int min = Integer.MIN_VALUE;
			StringBuilder sb = new StringBuilder();
			String turn = "C";
			sb.append(turn);
            max = arr[0][1];
            boolean flag = false;
			for(int i=1;i<x;i++)
			{
				int start = arr[i][0];
				int end = arr[i][1];
				if(max>start)
				{
					if(min>start)
					{
						flag = true;
						break;
					}
					else
					{
						if(min==Integer.MIN_VALUE)
						{
							min = Math.min(max, end);
							max = Math.max(end,max);
							turn = "J";
							sb.append(turn);
							if(min==end)
								turn ="J";
							else
								turn = "C";
						}
						else
						{
							sb.append(turn);
							min = Math.min(max, end);
							max = Math.max(end,max);
							if(min==end)
								turn ="J";
							else
								turn = turn=="C"?"J":"C";
						}
					}
				}
				else
				{
					min = Integer.MIN_VALUE;
					max = end;
					turn  = "C";
					sb.append(turn);
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
