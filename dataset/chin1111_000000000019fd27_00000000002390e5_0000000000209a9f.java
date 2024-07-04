import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer numberOfTestCases = Integer.parseInt(br.readLine().trim());
		
		for(int i =1; i <= numberOfTestCases;i++)
		{
			String input = br.readLine().trim();
			String output = "";
			
			Boolean isStart = false;
			for(int j =0;j < input.length();j++)
			{
				if(input.charAt(j) == '1')
				{
					if(!isStart)
					{
						output += "(" + input.charAt(j);
						isStart = true;
					}else {
						if((j+1) < input.length())
						{
							if(input.charAt(j+1) == '0')
							{
								output +=  input.charAt(j) + ")";
								isStart = false;
							}
							else {
								output += input.charAt(j);
							}
						}
					}
				}else {
					if(isStart)
					{
						output += ")";
						isStart = false;
					}
					output += input.charAt(j);
				}
			}
			
			if(isStart)
			{
				output += ")";
			}
			System.out.println("Case #" + i + ": " + output);
		}
	}

}
