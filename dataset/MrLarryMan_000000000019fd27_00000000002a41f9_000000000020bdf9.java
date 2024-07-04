import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = in.nextInt();
		
		String daAnswer;
		int numBlocks;
		block[] blocks;
		String answer;
		char person = 'C';
		char otherPerson = 'J';
		char[] placeholderCharArr;
		int placeholder = -1;
		int placeholder2 = -1;
		boolean onePersonOccupied;
		boolean bothPeopleOccupied;
		boolean flag;
		for(int yeeeeeeet = 1; yeeeeeeet <= numCases; yeeeeeeet++)
		{
			flag = false;
			answer = "";
			numBlocks = in.nextInt();
			blocks = new block[numBlocks];
			for(int b = 0; b < numBlocks; b++)
			{
				blocks[b] = new block(in.nextInt(), in.nextInt(), b);
			}
			
			Arrays.sort(blocks);
			onePersonOccupied = false;
			bothPeopleOccupied = false;
			
			for(int b = 0; b < numBlocks; b++)
			{
				if(onePersonOccupied)
				{
					if(blocks[b].start >= placeholder)
					{
						onePersonOccupied = false;
					}
				}
				
				if(bothPeopleOccupied)
				{
					if(blocks[b].start >= placeholder2)
					{
						bothPeopleOccupied = false;
					}
				}
				
				if(!onePersonOccupied)
				{
					blocks[b].setPerson(person);
					placeholder = blocks[b].end;
					onePersonOccupied = true;
				} else if (bothPeopleOccupied)
				{
					System.out.println("Case #" + yeeeeeeet + ": IMPOSSIBLE");
					flag = true;
					break;
				} else
				{
					blocks[b].setPerson(otherPerson);
					placeholder2 = blocks[b].end;
					bothPeopleOccupied = true;
				}
			}
			
			
			if(!flag)
			{
				placeholderCharArr = new char[numBlocks];
				for(int gg = 0; gg < numBlocks; gg++)
				{
					placeholderCharArr[blocks[gg].order] = blocks[gg].person;
				}
				
				for(int ggg = 0; ggg < numBlocks; ggg++)
				{
					answer += placeholderCharArr[ggg];
				}
				
				System.out.println("Case #" + yeeeeeeet + ": " + answer);
			}
		}
	}
}

class block implements Comparable<block>
{
	public int start;
	public int end;
	public int order;
	public char person;
	
	public block(int s, int e, int o)
	{
		start = s;
		end = e;
		order = o;
	}
	
	public void setPerson(char c)
	{
		person = c;
	}
	
	public int compareTo(block other)
	{
		return start - other.start;
	}
}
