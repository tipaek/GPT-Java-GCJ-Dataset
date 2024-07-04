import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = scanner.nextInt();
		
		for(int i = 0; i< t; i++)
		{
			String s = scanner.next();
			
			int open = 0;
			String newS = "";
			
			for(int j = 0; j <s.length();j++)
			{
				int digit = Integer.parseInt(s.substring(j, j+1));
				
				if(digit == 0)
				{
					int currOpen = open;
					for(int para=0;para < currOpen ;para ++)
					{
						newS = newS.concat(")");
						open--;
					}
					
				}
				
				else if(open < digit)
				{
					int currOpen = open;
					for(int para= 0;para < digit-currOpen ;para ++)
					{
						newS = newS.concat("(");
						open++;
					}	
				}
				
				else if(open > digit)
				{
					int currOpen = open;
					for(int para= 0;para < currOpen-digit ;para ++)
					{
						newS = newS.concat(")");
						open--;
					}	
				}
				
				newS = newS.concat(String.valueOf(digit));
			}
			
			int currOpen = open;
			for(int para=0;para < currOpen ;para ++)
			{
				newS = newS.concat(")");
				open--;
			}
			
			System.out.println("Case #"+(i+1)+": "+newS);
		}
		
		scanner.close();
	}
}
