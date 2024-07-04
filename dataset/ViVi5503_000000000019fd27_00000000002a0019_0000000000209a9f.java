import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int numCase = input.nextInt();
		int caseNum = 1;
		while(numCase >= caseNum)
		{
			String total = "";
			String s = input.next();
			int firstInt = 0;
			int currentInt = 0;
			int previousInt = 0;
			for(int i = 0; i < s.length(); i++)
			{
				currentInt = Integer.parseInt(s.substring(i, i+1));
				if(i == 0)
				{
					firstInt = currentInt;
					for(int j = 0; j < currentInt; j++)
					{
						total += "(";
					}
					total += currentInt;
				}
				if(i >= 1)
				{
					if(previousInt >= currentInt)
					{
						for(int j = 0; j < previousInt - currentInt; j++)
						{
							total += ")";
						}
						total += currentInt;
					}
					else
					{
						for(int k = 0; k < currentInt - previousInt; k++)
						{
							total += "(";
						}
						total += currentInt;
					}
				}
				previousInt = currentInt;
			}
			for(int y = 0; y < currentInt; y++)
			{
				total += ")";
			}
			System.out.println("\nCase #" + caseNum + ": " + total);
			caseNum++;
		}
	}
}