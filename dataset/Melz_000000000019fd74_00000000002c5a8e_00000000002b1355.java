import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = scanner.nextInt();
		
		for(int i = 0; i<t;i ++)
		{
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int skill[][] = new int[r][c];
			for(int j = 0; j<r;j++)
			{
				for(int k = 0; k<c;k++)
				{
					skill[j][k] = scanner.nextInt();
				}
				scanner.nextLine();
			}
			
			int totalInterest = calculateInterestForRound(skill);
			
			int newSkill[][] = new int[r][c];
			
			while(true)
			{
				int eleCount = 0;
				for(int row = 0; row<r;row++)
				{
					for(int col = 0; col<c;col++)
					{
						int neighSkill = 0;
						double neighCount = 0;
						if(skill[row][col] == 0)
							continue;
						for(int neigh = row-1;neigh>=0;neigh--)
						{
							if(skill[neigh][col] !=0)
							{
								neighSkill += skill[neigh][col];
								neighCount++;
								break;
							}
								
						}
						
						for(int neigh = row+1;neigh<r;neigh++)
						{
							if(skill[neigh][col] !=0)
							{
								neighSkill += skill[neigh][col];
								neighCount++;
								break;
							}
								
						}
						
						for(int neigh = col-1;neigh>=0;neigh--)
						{
							if(skill[row][neigh] !=0)
							{
								neighSkill += skill[row][neigh];
								neighCount++;
								break;
							}
								
						}
						
						for(int neigh = col+1;neigh<c;neigh++)
						{
							if(skill[row][neigh] !=0)
							{
								neighSkill += skill[row][neigh];
								neighCount++;
								break;
							}	
						}
						
						if(skill[row][col] < (neighSkill/neighCount))
						{
							newSkill[row][col] = 0;
							eleCount ++;
						}
						else
							newSkill[row][col] = skill[row][col];
						
					}
				}
				
				if(eleCount == 0)
					break;
				totalInterest += calculateInterestForRound(skill);
				skill = newSkill;	
			}
			
			System.out.println("Case #"+(i+1)+": "+totalInterest);
		}
		scanner.close();
	}
	
	public static int calculateInterestForRound(int skill[][])
	{
		
		int interest = 0;
		for(int row = 0; row<skill.length;row++)
		{
			for(int col = 0; col<skill[row].length;col++)
			{
				interest += skill[row][col];
			}
		}
		return interest;
	}

}
