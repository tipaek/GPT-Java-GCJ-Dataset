import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		int numOfActivities, cEnds, jEnds;
		int[][] activities;
		char[] assigned;
		String result = "";
		boolean toC;
		
		for(int index = 1; index <= cases; index++)
		{
			result = "";
			toC = true;
			numOfActivities = sc.nextInt();
			activities = new int[numOfActivities][];
			assigned = new char[numOfActivities];
			
			for(int i = 0; i < numOfActivities; i++)
			{
				activities[i] = new int[3];
				
				activities[i][0] = sc.nextInt();
				activities[i][1] = sc.nextInt();
				activities[i][2] = i;
			}
			
			Arrays.sort(activities, new java.util.Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[0], b[0]);
			    }
			});
			
			cEnds = activities[0][1];
			jEnds = 0;
			assigned[activities[0][2]] = 'C';
			
			for(int i = 1; i < numOfActivities; i++)
			{
				if(activities[i][0] >= cEnds)
				{
					cEnds = activities[i][1];
					assigned[activities[i][2]] = 'C';
				}
				else if(activities[i][0] >= jEnds)
				{
					jEnds = activities[i][1];
					assigned[activities[i][2]] = 'J';
				}
				else
				{
					result = "IMPOSSIBLE";
					break;
				}
			}
			
			if(!result.equals("IMPOSSIBLE"))
			{
				for(int i = 0; i < numOfActivities; i++)
				{
					result += assigned[i];
				}
			}
			
			System.out.println("Case #" + index + ": " + result);
		}
	}
}
