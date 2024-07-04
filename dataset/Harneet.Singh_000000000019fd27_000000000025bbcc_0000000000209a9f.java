
import java.io.IOException;
import java.util.Scanner;

public class Solution
{
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		
		for (int testcase = 0; testcase < testcases; testcase++)
		{
			char [] line = scan.nextLine().toCharArray();
			int length = line.length;
			int arr[] = new int[length];
			for(int i = 0; i < length; i++)
				arr[i] = line[i] - 48;
			
			int br = 0;
			StringBuffer sb = new StringBuffer(length * 2);
			for(int i = 0; i < length; i++)
			{
				if(br < arr[i])
				{
					for(int j = arr[i] - br; j > 0; j--)
						sb.append('(');
					br = arr[i];
				}
				else if(br > arr[i])
				{
					for(int j = br - arr[i]; j > 0; j--)
						sb.append(')');
					br = arr[i];
				}
				
				sb.append(arr[i]);
			}
			
			if(br != 0)
			{
				for(int j = br; j > 0; j--)
					sb.append(')');
				br = 0;
			}
			System.out.println("Case #" + (testcase + 1) + ": " + sb);
		}
		
		scan.close();
	}
}
