import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int n = in.nextInt(); 
			int [][] schedule = new int[2][n];
			for(int col = 0; col < n; col++) {
				int num1 = in.nextInt();
				
				int num2 = in.nextInt();
				schedule[0][col] = num1;
				schedule[1][col] = num2;
		
				}
				scheduleJC(schedule,i);
			}
			
			
		    
		}
	
	
	public static void scheduleJC(int [][] schedule,int caseNum) {
		int [][] jamie = new int[2][schedule[0].length];
		int jJobs = 0;
		int [][] cameron = new int[2][schedule[0].length];
		int cJobs = 0;
		boolean fail = false;
		boolean jFail = false;
		boolean cFail = false;
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0; i < schedule[0].length; i++) {
			
			if(jJobs == 0  ) {
				jamie[0][jJobs] = schedule[0][i];
				jamie[1][jJobs] = schedule[1][i];
				jJobs++;
				answer.append("J");
			}else {
				
				int k = 0;
				jFail = false;
				cFail = false;
				while( k < jJobs) {
					
					
					if( ( schedule[0][i] >= jamie[0][k]  &&  schedule[0][i] < jamie[1][k]  )  ||  (schedule[1][i] > jamie[0][k]  &&  schedule[1][i] <= jamie[1][k] )) {
						
						jFail = true;
						//break;
					}
					k++;
					
				}
				
				if(!jFail) {
					jamie[0][jJobs] = schedule[0][i];
					jamie[1][jJobs] = schedule[1][i];

					jJobs++;
					answer.append("J");
				}
				
				else {
					
					
					if(cJobs == 0  ) {
						cameron[0][cJobs] = schedule[0][i];
						cameron[1][cJobs] = schedule[1][i];

						cJobs++;
						answer.append("C");
					}else {
						k = 0;
						while( k < cJobs) {

							
							if( ( schedule[0][i] >= cameron[0][k]  &&  schedule[0][i] < cameron[1][k]  )  ||  (schedule[1][i] > cameron[0][k]  &&  schedule[1][i] <= cameron[1][k] )) {
								cFail = true;
								//break;
								
							}
							k++;
							
						}
						
						if(!cFail) {
							cameron[0][cJobs] = schedule[0][i];
							cameron[1][cJobs] = schedule[1][i];

							cJobs++;
							answer.append("C");
						}
						
						if(jFail && cFail) {
							System.out.println("Case #"+ (caseNum+1) + ": IMPOSSIBLE");
							return;
							
						}
					}
					
					
				}
				
				
			}
//			
//			if(jFail && cFail) {
//				fail = true;
//				i = schedule[0].length;
//				
//			}
			
			
			
			
		}
		
		
		
			
	
	
			System.out.println("Case #"+ (caseNum+1) + ": " + answer.toString());
	
		
			
		
	}
}
