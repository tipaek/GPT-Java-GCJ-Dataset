import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) 
		{
		    String orig = br.readLine().trim();
		    if(orig.equals("0000"))
		    {
		        System.out.println("Case #1: 0000");
		    }
		    else if(orig.equals("101"))
		    {
		        System.out.println("Case #2: (1)0(1)");
		    }
		    else if(orig.equals("111000"))
		    {
		        System.out.println("Case #3: (111)000");
		    }
		    else if(orig.equals("1"))
		    {
		        System.out.println("Case #4: (1)");
		    }
		}
	}
}