import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
		String answers[] = new String[numberOfTestCases];
		int activityCount;
		int activityInstance;
		String activityAssigned[];
		String activitySlot;
		String activitySlotSplit[];
		for(int testCaseInstance = 0;testCaseInstance < numberOfTestCases;testCaseInstance++)
		{	
			answers[testCaseInstance] = "";
			activityCount = Integer.parseInt(bufferedReader.readLine());
			activityAssigned = new String[activityCount];
			int activityTime[][] = new int[activityCount][activityCount];
			for(activityInstance=0;activityInstance<activityCount;activityInstance++)
			{
				activitySlot = bufferedReader.readLine();
				activitySlotSplit = activitySlot.split(" ");
				activityTime[activityInstance][0] = Integer.parseInt(activitySlotSplit[0]);
				activityTime[activityInstance][1] = Integer.parseInt(activitySlotSplit[1]);
			}
			Arrays.sort(activityTime, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
				    return Integer.compare(o1[1],o2[1]);
				}
			});
			int jamesPreviousActivityInstance = 0;
			int cameronPreviousActivityInstance = 1;
			activityAssigned[jamesPreviousActivityInstance] = "J";
			activityAssigned[cameronPreviousActivityInstance] = "C";
	        for (activityInstance = 1; activityInstance < activityCount; activityInstance++) 
	        {
	            if (activityTime[activityInstance][0] >= activityTime[jamesPreviousActivityInstance][1])
	            {
	            	activityAssigned[activityInstance] = "J";
	            	jamesPreviousActivityInstance = activityInstance;
	            }
	            else
	            {
	            	if(activityTime[activityInstance][0] >= activityTime[cameronPreviousActivityInstance][1])
	            	{
	            		activityAssigned[activityInstance] = "C";
	            		cameronPreviousActivityInstance = activityInstance;
	            	}
	            }
	        }
	        for (activityInstance = 0; activityInstance < activityCount; activityInstance++) 
	        {
	        	if(activityAssigned[activityInstance] ==null)
	        	{
	        		answers[testCaseInstance] = "IMPOSSIBLE";
	        		break;
	        	}
	        	else
	        	{
	        		answers[testCaseInstance]+=activityAssigned[activityInstance];
	        		//System.out.println(activityAssigned[activityInstance]);
	        	}
	        		
			}
			
		}
		for(int j=0;j<numberOfTestCases;j++)
		{
			System.out.println("Case #"+(j+1)+": "+answers[j]);
		}
	}
	
	
}
