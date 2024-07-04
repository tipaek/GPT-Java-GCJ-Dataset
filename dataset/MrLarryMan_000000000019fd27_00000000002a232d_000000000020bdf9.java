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
		char placeholderChar;
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
				blocks[b] = new block(in.nextInt(), in.nextInt());
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
					answer += person;
					placeholder = blocks[b].end;
					onePersonOccupied = true;
				} else if (bothPeopleOccupied)
				{
					System.out.println("Case " + yeeeeeeet + ": IMPOSSIBLE");
					flag = true;
					break;
				} else
				{
					answer += otherPerson;
					placeholder2 = blocks[b].end;
					bothPeopleOccupied = true;
				}
			}
			
			if(!flag)
				System.out.println("Case " + yeeeeeeet + ": " + answer);
		}
	}
}

class block implements Comparable<block>
{
	public int start;
	public int end;
	
	public block(int s, int e)
	{
		start = s;
		end = e;
	}
	
	public int compareTo(block other)
	{
		return start - other.start;
	}
}
