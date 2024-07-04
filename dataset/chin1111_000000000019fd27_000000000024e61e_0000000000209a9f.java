import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer numberOfTestCases = Integer.parseInt(br.readLine().trim());
		
		for(int i =1; i <= numberOfTestCases;i++)
		{
			if(i > 1)
			{
				System.out.println();
			}
			String input = br.readLine().trim();
			StringBuffer output = new StringBuffer();
			output.append("");
			Boolean isStart = false;
			for(int j =0;j < input.length();j++)
			{
				if(input.charAt(j) == '1')
				{
					if(!isStart)
					{
						output.append("(" + input.charAt(j));
						isStart = true;
					}else {
						if((j+1) < input.length())
						{
							if(input.charAt(j+1) == '0')
							{
								output.append(input.charAt(j) + ")");
								isStart = false;
							}
							else {
								output.append(input.charAt(j));
							}
						}
					}
				}else {
					if(isStart)
					{
						output.append(")");
						isStart = false;
					}
					output.append(input.charAt(j));
				}
			}
			
			if(isStart)
			{
				output.append(")");
			}
			
			System.out.print("Case #" + i + ": " + output.toString());
		}
	}

}
