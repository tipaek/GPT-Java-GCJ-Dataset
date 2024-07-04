import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases = sc.nextInt();
		sc.nextLine();
		
		String result, s;
		int openPar, currentNum;
		
		for(int index = 1; index <= cases; index++)
		{
			openPar = 0;
			result = "";
			s = sc.nextLine();
			
			for(int i = 0; i < s.length(); i++)
			{
				currentNum = Integer.parseInt("" + s.charAt(i));
				
				if(currentNum > openPar)
				{
					for(int j = openPar; j < currentNum; j++)
					{
						result += "(";
						openPar++;
					}
				}
				else if(currentNum < openPar)
				{
					for(int j = currentNum; j < openPar; j++)
					{
						result += ")";
						openPar--;
					}
				}
				
				result += s.charAt(i);
			}
			
			for(int i = 0; i < openPar; i++)
			{
				result += ")";
			}
			
			System.out.println("Case #" + index + ": " + result);
		}
	}
}
