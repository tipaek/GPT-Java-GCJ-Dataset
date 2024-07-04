
import java.util.*;
import java.io.*;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean isCassigned = false, isJAssigned = false;
		int cEndValue = -1, jEndValue = -1;
		
		int testCase, testCounter = 1;
		int [] allMiutes = new int[1441];
		
		Scanner inputScanner = new Scanner(System.in);
		
		testCase = inputScanner.nextInt();
		while(testCounter <= testCase) {
			
			int schedule = inputScanner.nextInt();
			int startEndArray[][] = new int[schedule][3];
			
			for (int i = 0; i < schedule; i++) {
				Arrays.fill(startEndArray[i], 0);
			}
			
			//reset all values
			int scheduleCounter = 0;
			Arrays.fill(allMiutes, 0);
			
			while(scheduleCounter < schedule) {
				
				int startTime = inputScanner.nextInt();
				int endTime = inputScanner.nextInt();
								
				startEndArray[scheduleCounter][0] = startTime;
				startEndArray[scheduleCounter][1] = endTime;
				scheduleCounter++;
				
				for (int index = startTime ; index < endTime ; index++) {
					allMiutes[index]++;
				}
			}
			
			boolean isPossible = true;
			isCassigned = false; isJAssigned = false;
			for (int index = 0 ; index < 1441 ; index++) {
				if(allMiutes[index] > 3) {
					isPossible = false;
					break;
				}else if(allMiutes[index] == 3 && index == 0) {
					isPossible = false;
					break;
				}else if(allMiutes[index] == 3) {
					isPossible = false;
					break;
				} else if(allMiutes[index] == 1 || allMiutes[index] == 2) {
					int endTime = 0;

					for (int i = 0; i < schedule; i++) {
						
						if (index == startEndArray[i][0] && startEndArray[i][2] == 0) {

							endTime = startEndArray[i][1];

							if (isCassigned == false) {
								isCassigned = true;
								cEndValue = endTime;
								startEndArray[i][2] = 3;
							} else if (isJAssigned == false) {
								isJAssigned = true;
								jEndValue = endTime;
								startEndArray[i][2] = 2;
							} else {
								if (index >= cEndValue) {
									isCassigned = true;
									cEndValue = endTime;
									startEndArray[i][2] = 3;
								} else if (index >= jEndValue){
									isJAssigned = true;
									jEndValue = endTime;
									startEndArray[i][2] = 2;
								}
							}

						}
					}
				}
			}

			
			if(isPossible) {
				System.out.print("Case #"+testCounter+": ");
				for (int i = 0; i < startEndArray.length; i++) {
					if(startEndArray[i][2] == 2) {
						System.out.print("J");
					}else if(startEndArray[i][2] == 3) {
						System.out.print("C");
					}else {
						System.out.print("F");
					}
				}
				
			}else {
				System.out.print("Case #"+testCounter+": IMPOSSIBLE");
			}
			
			System.out.println();
			
			
			testCounter++;
		}
				
	}
}
