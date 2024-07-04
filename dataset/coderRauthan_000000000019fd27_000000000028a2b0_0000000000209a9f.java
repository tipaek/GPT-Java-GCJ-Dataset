import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		
		String open = "(";
		String close = ")";
		
		for(int i=0; i< testCases; i++)
		{
			String s = sc.next();
			
			String ans = "";
			
			int currentOpen = 0;
			
			for(int j=0; j < s.length(); j++)
			{
				int value = Integer.parseInt(String.valueOf(s.charAt(j)));
				
				if(value == currentOpen)
				{
					ans += value;
				}
				else if(value < currentOpen)
				{
					int extra = currentOpen - value;
					for(int k=0; k< extra; k++)
					{
						ans += close;
					}
					ans += value;
					currentOpen = value;
				}
				else
				{
					int extra = value - currentOpen;
					for(int k=0; k< extra; k++)
					{
						ans += open;
					}
					ans+= value;
					currentOpen = value;
				}
				
				
				if(j == s.length()-1)
				{
					for(int k=0; k< currentOpen; k++)
					{
						ans+= close;
					}
				}
			}
			
			int currently = i+1;
			
			System.out.println("Case #"+currently+": "+ans);
		}

	}

}
