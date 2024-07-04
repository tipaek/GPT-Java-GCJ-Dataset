import java.util.*;
import java.io.*;

public class vestigium
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int[][] theMatrix;
		int placeholder;
		int sum;
		ArrayList<Integer> yeeeet;
		int numRows;
		int numColumns;
		boolean boolPlaceholder;
		
		for (int i = 1; i <= numCases; i++)
		{
			numRows = 0;
			numColumns = 0;
			int n = in.nextInt();
			theMatrix = new int[n][n];
			for(int b = 0; b < n; b++)
			{
				StringTokenizer st = new StringTokenizer(in.nextLine());
				for(int c = 0; c < n; c++)
				{
					theMatrix[b][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			placeholder = 0;
			sum = 0;
			for(int b = 0; b < n; b++)
			{
				sum += theMatrix[b][placeholder];
				placeholder++;
			}

			for(int b = 0; b < n; b++)
			{
				boolPlaceholder = false;
				yeeeet = new ArrayList<Integer>(n);
				for(int c = 0; c < n; c++)
				{
					if(boolPlaceholder)
					{
						break;
					}
					
					for(int dd = 0; dd < yeeeet.size(); dd++)
					{
						if(theMatrix[b][c] == yeeeet.get(dd))
						{
							numRows++;
							boolPlaceholder = true;
							break;
						}
					}
					
					yeeeet.add(theMatrix[b][c]);
				}
			}
			
			for(int b = 0; b < n; b++)
			{
				boolPlaceholder = false;
				yeeeet = new ArrayList<Integer>(n);
				for(int c = 0; c < n; c++)
				{
					if(boolPlaceholder)
					{
						break;
					}
					
					for(int dd = 0; dd < yeeeet.size(); dd++)
					{
						if(theMatrix[c][b] == yeeeet.get(dd))
						{
							numColumns++;
							boolPlaceholder = true;
							break;
						}
					}
					
					yeeeet.add(theMatrix[c][b]);
				}
			}
			
			System.out.println("Case #" + i + ": " + sum + " " + numRows + " " + numColumns);
		}
	}
}