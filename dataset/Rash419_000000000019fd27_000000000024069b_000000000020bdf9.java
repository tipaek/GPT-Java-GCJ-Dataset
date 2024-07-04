

import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int r=0;r<t;r++)
		{
			int n = scan.nextInt();
			int arr[][] = new int[n][2];
			char chArr[] = new char[n];
			Arrays.fill(chArr, 'X');
			for(int i=0;i<n;i++)
			{
				arr[i][0] = scan.nextInt();
				arr[i][1] = scan.nextInt();
			}
			int noOverlap = 0;
			for(int i=0;i<n;i++)
			{
				noOverlap = 0;
				int st = arr[i][0];
				int end = arr[i][1];
				for(int j=0;j<n;j++)
				{
					if((st > arr[j][0] && st < arr[j][1] || end > arr[j][0] && end < arr[j][1]))
					{	
						if(chArr[i] == 'J')
						{
							chArr[j] = 'C';
						}
						else if(chArr[i] == 'C')
						{
							chArr[j]='J';
						}
						else if(chArr[j] == 'J')
						{
							chArr[i] = 'C';
						}
						else if(chArr[j] == 'C')
						{
							chArr[i] = 'J';
						}
						else
						{
							chArr[i] = 'J';
							chArr[j] = 'C';
						}
						noOverlap++;
					}
				}
			}
		//	System.out.println(noOverlap);
			if(noOverlap >= 2 ) {
				System.out.println("Case #"+(r+1)+": " + "IMPOSSIBLE");
			}
			else
			{
				for(int k=0;k<chArr.length;k++)
				{
					if(chArr[k] == 'X')
						chArr[k] = 'J';
				}
				System.out.print("Case #"+(r+1)+": ");
				for(char ch:chArr)System.out.print(ch);
				System.out.println();
			}
			
		}
	}
}
