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
			String total = "CJ";
			int numActivities = input.nextInt();
			int[][] activities = new int[numActivities][2];
			for(int i = 0; i < numActivities; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					activities[i][j] = input.nextInt();
				}
			}
			for(int k = 2; k < numActivities; k++)
			{
				int currentStart = activities[k][0];
				int currentEnd = activities[k][1];
				int camActivityStart = activities[0][0];
				int camActivityEnd = activities[0][1];
				int jamActivityStart = activities[1][0];
				int jamActivityEnd = activities[1][1];
				if(camActivityStart >= currentStart && camActivityStart >= currentEnd)
				{
					total += "C";
					camActivityStart = currentStart;
					camActivityEnd = currentEnd;
				}
				else if(jamActivityStart >= currentStart && jamActivityStart >= currentEnd)
				{
					total += "J";
					jamActivityStart = currentStart;
					jamActivityEnd = currentEnd;
				}
				else if(camActivityEnd <= currentStart)
				{
					total += "C";
					camActivityStart = currentStart;
					camActivityEnd = currentEnd;
				}
				else if(jamActivityEnd <= currentStart)
				{
					total += "J";
					jamActivityStart = currentStart;
					jamActivityEnd = currentEnd;
				}
				else
				{
					total = "IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #" + caseNum + ": " + total);
			caseNum++;
		}
	}
}