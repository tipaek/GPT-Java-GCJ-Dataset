import java.util.*;
import java.io.*;

public class Solution
{	
	public static void main(String[] args)
	{
		Scanner infile = new Scanner(System.in);
		int numTestCases = infile.nextInt();
		int bits = infile.nextInt();
		infile.nextLine();
		boolean passed = true;
		int testCase = 1;
		while(passed && testCase <= numTestCases)
		{
			char[] array = new char[bits + 1];
			int maxLeft = 1;
			int minRight = array.length - 1;
			int same = 0, different = 0;
			boolean sameChange = false, diffChange = false;
			label:for(int q = 1; q <= 150; q++)
			{
				if(q == 1 || q == 2)
				{
					if(q == 1)
					{
						System.out.println(maxLeft);
						array[maxLeft] = infile.nextLine().charAt(0);
						maxLeft++;
					}
					else
					{
						System.out.println(minRight);
						array[minRight] = infile.nextLine().charAt(0);
						if(array[1] == array[minRight])
							same = 1;
						else
							different = 1;
						minRight--;
					}
				}
				else if((same == 0 && different != 0) || (same != 0 && different == 0))
				{
					if(same == 0)
					{
						if(q % 10 == 1)
						{
							System.out.println(different);
							char temp = infile.nextLine().charAt(0);
							if(temp != array[different])
								complement(array);
						}
						else if(q % 10 == 2)
							continue label;
						else if(q % 2 == 1)
						{
							System.out.println(maxLeft);
							array[maxLeft] = infile.nextLine().charAt(0);
							maxLeft++;
						}
						else
						{
							System.out.println(minRight);
							array[minRight] = infile.nextLine().charAt(0);
							if(array[maxLeft - 1] == array[minRight])
								same = maxLeft - 1;
							minRight--;
							if(maxLeft > minRight)
								break label;
						}
					}
					else
					{
						if(q % 10 == 1)
						{
							System.out.println(same);
							char temp = infile.nextLine().charAt(0);
							if(temp != array[same])
								complement(array);
						}
						else if(q % 10 == 2)
							continue label;
						else if(q % 2 == 1)
						{
							System.out.println(maxLeft);
							array[maxLeft] = infile.nextLine().charAt(0);
							maxLeft++;
						}
						else
						{
							System.out.println(minRight);
							array[minRight] = infile.nextLine().charAt(0);
							if(array[maxLeft - 1] != array[minRight])
								different = maxLeft - 1;
							minRight--;
							if(maxLeft > minRight)
								break label;
						}
					}
				}
				else
				{
					if(q % 10 == 1)
					{
						System.out.println(same);
						char temp = infile.nextLine().charAt(0);
						if(temp != array[same])
							sameChange = true;
						else
							sameChange = false;
					}
					else if(q % 10 == 2)
					{
						System.out.println(different);
						char temp = infile.nextLine().charAt(0);
						if(temp != array[different])
							diffChange = true;
						else
							diffChange = false;
						
						if(sameChange && diffChange)
							complement(array);
						else if(sameChange && !diffChange)
						{
							reverse(array);
							complement(array);
						}
						else if(!sameChange && diffChange)
							reverse(array);
					}
					else if(q % 2 == 1)
					{
						System.out.println(maxLeft);
						array[maxLeft] = infile.nextLine().charAt(0);
						maxLeft++;
					}
					else
					{
						System.out.println(minRight);
						array[minRight] = infile.nextLine().charAt(0);
						if(array[maxLeft - 1] != array[minRight])
							different = maxLeft - 1;
						minRight--;
						if(maxLeft > minRight)
							break label;
					}
				}
			}
			
			for(int i = 1; i <= bits; i++)
				System.out.print(array[i]);
			System.out.println();
			
			if(infile.nextLine().charAt(0) == 'Y')
				testCase++;
			else
				passed = false;
		}
	}
	
	private static void complement(char[] array)
	{
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] == '0')
				array[i] = '1';
			else if(array[i] == '1')
				array[i] = '0';
		}
	}
	
	private static void reverse(char[] array)
	{
		for(int i = 1; i <= (array.length - 1) / 2; i++)
			swap(array, i, array.length - i);
	}
	
	private static void swap(char[] array, int a, int b)
	{
		char temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}