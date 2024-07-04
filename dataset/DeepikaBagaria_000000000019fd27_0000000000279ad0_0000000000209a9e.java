import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(str.nextToken());
		int n = Integer.parseInt(str.nextToken());
		if (n == 10)
		{
			for (int tt = 0; tt < t; tt++)
			{
				int b[] = new int[n];
				for (int i = 0; i < n; i++)
				{
					System.out.println(i + 1);
					b[i] = Integer.parseInt(br.readLine());
				}
                StringBuilder sb = new StringBuilder();
				for (int i = 0; i < n; i++)
				{
					sb.append(b[i]);
				}
				System.out.println(sb.toString());
			}
		}
	}
}