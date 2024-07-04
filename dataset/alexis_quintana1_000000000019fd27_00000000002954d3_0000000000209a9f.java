import java.util.*;
import java.io.File;

public class Solution
{
	public static void main (String [] args)
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		String [] str = new String[T];

		for (int i = 0; i < T; i++)
		{
			String S = in.nextLine();
			int [] current = new int[S.length()];
			for (int j = 0; j < S.length(); j++)
				current[j] = Character.getNumericValue(S.charAt(j));
			str[i] = ("Case #" + (i+1) + ": ");
			for (int j = 0; j < S.length(); j++)
			{
				if (S.length() == 1)
				{
					for (int k = 0; k < current[j]; k++)
				 		str[i] += "(";
				 	str[i] += (current[j]);
				 	for (int k = 0; k < current[j]; k++)
				 		str[i] += ")"; 
				 	break;
				}
				if (current[j] == 0)
				{
					str[i] += (current[j]);
					continue;
				}
				if (j != 0 && current[j] == current[j-1])
				{
					if (j-1 == 0)
					{
						for (int k = 0; k < current[j]; k++)
				 			str[i] += "(";
				 		str[i] += (current[j]);
					}
					if (current[j] != current[j-1])
					{
						for (int k = 0; k < current[j]; k++)
				 			str[i] += "(";
					}	
						
				 	str[i] += (current[j]);
				 	if (j <= S.length()-2 && current[j] > current[j+1])
				 	{
				 		int close = current[j] - current[j+1];
				 		for (int k = 0; k < close; k++)
							str[i] += ")"; 
					}
				}
				else if (j <= S.length()-2 && current[j] > current[j+1])
				{
					int close = current[j] - current[j+1];
					for (int k = 0; k < current[j]; k++)
				 		str[i] += "(";
				 	str[i] += (current[j]);
				 	for (int k = 0; k < close; k++)
						str[i] += ")"; 
				}
				else if (j <= S.length()-2 && current[j] < current[j+1])
				{
					int open = current[j+1] - current[j];
					str[i] += (current[j]);
					for (int k = 0; k < open; k++)
						str[i] += "(";
					str[i] += (current[j+1]);
				}
				if (j == S.length()-1 && current[j] > current[j-1])
				{
					if (current[j-1] == 0)
					{
						for (int k = 0; k < current[j]; k++)
				 			str[i] += "(";
				 		str[i] += (current[j]);
				 		for (int k = 0; k < current[j]; k++)
				 			str[i] += ")"; 
					}
					else
					{
						for (int k = 0; k < current[j]; k++)
							str[i] += ")"; 
					}
				}
				else if (j == S.length()-1 && current[j] < current[j-1])
				{
					str[i] += (current[j]);
					for (int k = 0; k < current[j]; k++)
						str[i] += ")"; 
				}

			}
		}
		for (int i = 0; i < T; i++)
			System.out.println(str[i]);
	}
}
