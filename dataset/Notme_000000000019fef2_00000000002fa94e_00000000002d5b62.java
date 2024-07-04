import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			String[] str = br.readLine().trim();  
			int x=Integer.parseInt(str[0]);
			int y=Integer.parseInt(str[0]);
            System.out.println("IMPOSSIBLE"); 
		}
	}
}
