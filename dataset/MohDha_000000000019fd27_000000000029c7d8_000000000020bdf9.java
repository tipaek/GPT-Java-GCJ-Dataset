import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String output = "";

		int caseCount = in.nextInt();
		for (int x = 0; x < caseCount; x++) {

			// get event count
			int activityCount = in.nextInt();

			// get event
			int[][] event = new int[activityCount][2];
			for (int i = 0; i < activityCount; i++) {
				for (int j = 0; j < 2; j++) {
					event[i][j] = in.nextInt();
				}
			}
			
			// sort Array
			java.util.Arrays.sort(event, new java.util.Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return Integer.compare(a[0], b[0]);
			    }
			});

			if (activityCount >= 2) {

				output = "CJ";

				int endP1 = event[0][1];
				int endP2 = event[1][1];

				int startP1 = event[0][0];
				int startP2 = event[1][0];

				for (int i = 2; i < activityCount; i++) {

					if (endP1 <= event[i][0]) {
						output = output + "C";
						endP1 = event[i][1];
						startP1 = event[i][0];
					}

					else if (endP2 <= event[i][0])  {
						output = output + "J";
						endP2 = event[i][1];
						startP2 = event[i][0];
					}

						
					/*else if(endP1 < endP2 &&  startP1 < startP2 && event[i][0] > endP1){
							output = output + "C";
							endP1 = event[i][1];
							startP1 = event[i][0];
						}*/
						
					/*else if(endP2 > endP1 &&  startP2 < startP1 && event[i][0] > endP2){
						output = output + "J";
						endP2 = event[i][1];
						startP2 = event[i][0];
					}*/
						
						else{
						output = "IMPOSSIBLE"; 
						break;}
					}
			} 

			System.out.println(String.format("Case #%d: %s", x + 1, output.toString()));
		}
	}

}