import java.util.*;
class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int l=1;l<=t;l++)
		{
			int n = sc.nextInt();

			String arr[] = new String[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.next();

			String maxString = "";
			int indexOfMax = -1;
			int max = Integer.MIN_VALUE;
			boolean flag = true;

			for(int i=0;i<n;i++)
			{
				if(arr[i].length() > max)
				{
					max = arr[i].length();
					indexOfMax = i;
					maxString = arr[indexOfMax];
				}
			}

			StringBuffer sb = new StringBuffer(maxString);

			for(int i=0;i<n;i++)
			{
				String compare = sb.substring(maxString.length()-arr[i].length()+1);
				if(!("*"+compare).equals(arr[i]))
				{
					flag = false;
					break;
				}
			}

			if(!flag)
			{
				System.out.println("Case "+"#"+l+": "+  "*");
				continue;
			}

			System.out.println("Case "+"#"+l+": "+ maxString);

		}
	}
}