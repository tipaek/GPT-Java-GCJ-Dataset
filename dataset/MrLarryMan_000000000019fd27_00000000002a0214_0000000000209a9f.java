import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = in.nextInt();
		in.nextLine();

		int[] daStringInt;
		int[] daStringIntCopy;
		int daIndex;
		
		for (int b = 1; b <= numCases; b++)
		{
			String daString = in.nextLine();
			daStringInt = new int[daString.length()];
			for (int i = 0; i < daString.length(); i++)
			{
				daStringInt[i] = Integer.parseInt(daString.charAt(i) + "");
			}

			daStringIntCopy = new int[daString.length()];

			for (int i = 0; i < daString.length(); i++)
			{
				daStringIntCopy[i] = daStringInt[i];
			}

			String returned = doOut(daStringIntCopy);

			daIndex = 0;

			for (int i = 0; i < returned.length(); i++)
			{
				if (Character.isDigit(returned.charAt(i)))
				{
					if (i == returned.length() - 1)
					{
						returned = returned.substring(0, i) + daStringInt[daIndex];
					} else
					{
						returned = returned.substring(0, i) + daStringInt[daIndex] + returned.substring(i + 1);
					}
					daIndex++;
				}
			}

			System.out.println("Case #" + b + ": " + returned);
		}
	}

	public static String doOut(int[] yeet)
	{
		String returned = "";
		if (yeet.length == 0)
		{
			return "";
		} else if (yeet.length == 1)
		{
			for (int i = 0; i < yeet[0]; i++)
			{
				returned += "(";
			}

			returned += "" + yeet[0];

			for (int i = 0; i < yeet[0]; i++)
			{
				returned += ")";
			}
		} else
		{
			int placeholder = Integer.MAX_VALUE;
			for (int i : yeet)
			{
				placeholder = Math.min(placeholder, i);
			}
			for (int i = 0; i < placeholder; i++)
			{
				returned += "(";
			}

			for (int i = 0; i < yeet.length; i++)
			{
				yeet[i] -= placeholder;
			}

			int lastIndex = 0;

			for (int i = 0; i < yeet.length; i++)
			{
				if (yeet[i] == 0)
				{
					returned += doOut(Arrays.copyOfRange(yeet, lastIndex, i));
					returned += "0";
					lastIndex = i + 1;
				}
			}

			for (int i = 0; i < placeholder; i++)
			{
				returned += ")";
			}
		}

		return returned;
	}
}
