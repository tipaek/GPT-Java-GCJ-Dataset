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
			int activityAssigned[][];
			String activitySlot;
			String activitySlotSplit[];
			for(int testCaseInstance = 0;testCaseInstance < numberOfTestCases;testCaseInstance++)
			{	
				answers[testCaseInstance] = "";
				activityCount = Integer.parseInt(bufferedReader.readLine());
				activityAssigned = new int[activityCount][2];
				int activityTime[][] = new int[activityCount][3];
				for(activityInstance=0;activityInstance<activityCount;activityInstance++)
				{
					activitySlot = bufferedReader.readLine();
					activitySlotSplit = activitySlot.split(" ");
					activityTime[activityInstance][0] = Integer.parseInt(activitySlotSplit[0]);
					activityTime[activityInstance][1] = Integer.parseInt(activitySlotSplit[1]);
					activityTime[activityInstance][2] = activityInstance;
				}
				Arrays.sort(activityTime, new Comparator<int[]>() {
					public int compare(int[] o1, int[] o2) {
					    return Integer.compare(o1[1],o2[1]);
					}
				});
				int jamesPreviousActivityInstance = 0;
				int cameronPreviousActivityInstance = -1;
				activityAssigned[jamesPreviousActivityInstance][0] = 1;
				activityAssigned[jamesPreviousActivityInstance][1] = activityTime[jamesPreviousActivityInstance][2];
				//activityAssigned[cameronPreviousActivityInstance] = "C";
		        for (activityInstance = 1; activityInstance < activityCount; activityInstance++) 
		        {
		            if (activityTime[activityInstance][0] >= activityTime[jamesPreviousActivityInstance][1])
		            {
		            	activityAssigned[activityInstance][0] = 1;
		            	activityAssigned[activityInstance][1] = activityTime[activityInstance][2];
		            	jamesPreviousActivityInstance = activityInstance;
		            }
		            else
		            {
		            	if(cameronPreviousActivityInstance == -1)
		            	{
		            		activityAssigned[activityInstance][0] = 2;
		            		activityAssigned[activityInstance][1] = activityTime[activityInstance][2];
		            		cameronPreviousActivityInstance = activityInstance;
		            	}
		            	else if(activityTime[activityInstance][0] >= activityTime[cameronPreviousActivityInstance][1])
		            	{
		            		activityAssigned[activityInstance][0] = 2;
		            		activityAssigned[activityInstance][1] = activityTime[activityInstance][2];
		            		cameronPreviousActivityInstance = activityInstance;
		            	}
		            }
		        }
				Arrays.sort(activityAssigned, new Comparator<int[]>() {
					public int compare(int[] o1, int[] o2) {
					    return Integer.compare(o1[1],o2[1]);
					}
				});
		        for (activityInstance = 0; activityInstance < activityCount; activityInstance++) 
		        {
		        	if(activityAssigned[activityInstance][0] == 0)
		        	{
		        		answers[testCaseInstance] = "IMPOSSIBLE";
		        		break;
		        	}
		        	else
		        	{
		        		answers[testCaseInstance]+=activityAssigned[activityInstance][0];
		        		//System.out.println(activityAssigned[activityInstance][0]+
		        		//		" "+activityTime[activityInstance][2]
		        		//				+" "+activityAssigned[activityInstance][1]);
		        	}
		        		
				}
		        answers[testCaseInstance] = answers[testCaseInstance].replace("1","J");
		        answers[testCaseInstance] = answers[testCaseInstance].replace("2","C");
				
			}
			for(int j=0;j<numberOfTestCases;j++)
			{
				System.out.println("Case #"+(j+1)+": "+answers[j]);
			}
		}
		
		
	}
