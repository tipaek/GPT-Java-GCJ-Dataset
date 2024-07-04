import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int count = inputScanner.nextInt();
		//cases
		for (int k = 1; k<= count; k++) {
			//activities
			int num = inputScanner.nextInt();
			int[][] activities = new int[num][3];
			int[][] activitiesCopy = new int[num][3];

			for(int i=0; i< num; i++) {
				for(int j=0; j < 2; j++) {
					activities[i][j] = inputScanner.nextInt();
					activitiesCopy[i][j] = activities[i][j];
				}
			}
			Arrays.sort(activitiesCopy, new Comparator<int[]>() {
	            @Override
	            public int compare(final int[] entry1, final int[] entry2) {
	                final Integer time1 = entry1[0];
	                final Integer time2 = entry2[0];
	                return time1.compareTo(time2);
	            }
	        });
			
			boolean isImpossible = false;
			
			boolean isCameronFree = true;
			int cameronCount = 0;
			int cameronFinishTime = 0;
			
			boolean isJamieFree = true;
			int jamieCount = 0;
			int jamieFinishTime = 0;
			
			for(int i=0; i< num; i++) {
				if(i == 0) {
					activitiesCopy[i][2] = 1;
					isCameronFree = false;
					cameronCount ++;
					cameronFinishTime = activitiesCopy[i][1];
					continue;
				}
				if(!isCameronFree && activitiesCopy[i][0] == cameronFinishTime) {
					activitiesCopy[i][2] = 1;
					cameronCount ++;
					cameronFinishTime = activitiesCopy[i][1];
					continue;
				} else if(!isJamieFree && activitiesCopy[i][0] == jamieFinishTime) {
					activitiesCopy[i][2] = 2;
					jamieCount ++;
					jamieFinishTime = activitiesCopy[i][1];
					continue;
				} else if(!isCameronFree && activitiesCopy[i][0] >= cameronFinishTime) {
					isCameronFree = true;
				} else if(!isJamieFree && activitiesCopy[i][0] >= jamieFinishTime) {
					isJamieFree = true;
				}
				
				if(isCameronFree && isJamieFree && cameronCount <= jamieCount){
					activitiesCopy[i][2] = 1;
					isCameronFree = false;
					cameronCount ++;
					cameronFinishTime = activitiesCopy[i][1];
					continue;
				} else if (isCameronFree && isJamieFree && jamieCount <= cameronCount){
					activitiesCopy[i][2] = 2;
					isJamieFree = false;
					jamieCount ++;
					jamieFinishTime = activitiesCopy[i][1];
					continue;
				} else if(isCameronFree) {
					activitiesCopy[i][2] = 1;
					isCameronFree = false;
					continue;
				} else if(isJamieFree) {
					activitiesCopy[i][2] = 2;
					isJamieFree = false;
					jamieCount ++;
					jamieFinishTime = activitiesCopy[i][1];
					continue;
				}
				isImpossible = true;
				break;
			}
			
			String result = "";
			if(isImpossible) {
				result = "IMPOSSIBLE";
			}else {
				for(int i=0; i< num; i++) {
					for(int j=0; j< num; j++) {
						if(activities[i][0] == activitiesCopy[j][0] && activities[i][1] == activitiesCopy[j][1]) {
							result +=activitiesCopy[j][2]==1?"C":"J";
							break;
						}
					}
				}
			}
			
			
			System.out.printf("Case #%d: ", k);
			System.out.println(result);
		}
		inputScanner.close();
	}
}
