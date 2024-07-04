import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tt = 0; tt < t; tt++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			
			String m = str.nextToken();
			int n = m.length();
			int ans=-1;
			for(int i=0;i<n;i++)
			{
				char c =m.charAt(i);
				if(c=='N') y++;
				else if(c=='S') y--;
				else if(c=='E') x++;
				else if(c=='W') x--;
				int sum = Math.abs(x)+Math.abs(y);
				if(sum<=(i+1)) 
					{
					ans=i+1; 
					break;
					}
			}
			if(ans!=-1)
			{
			System.out.println("Case #"+(tt+1)+": "+ans);
			}
			else
			{
				System.out.println("Case #"+(tt+1)+": "+"IMPOSSIBLE");
			}
		}
	}
}