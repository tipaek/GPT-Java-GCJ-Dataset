import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int i = 0; i < T; i++) { //T test cases
	    	int N = Integer.parseInt(scanner.nextLine());
	    	//create array of pairs of start and endtimes
	    	int[][] schedules = new int[N][2];
	    	for(int j = 0; j < N; j++) {
	    		String schedInput = scanner.nextLine();
	    		String[] schedTime = schedInput.split(" ");
	    		schedules[j][0] = Integer.parseInt(schedTime[0]);
	    		schedules[j][1] = Integer.parseInt(schedTime[1]);
	    	}
	    	int temp0 = 0;
	    	int temp1 = 0;
	    	for(int x=0; x < N; x++){  
	        	for(int y=1; y < (N-x); y++){  
	        		if(schedules[y-1][0] > schedules[y][0]){  
	        			//swap elements  
	        			temp0 = schedules[y-1][0];  
	        			schedules[y-1][0] = schedules[y][0];  
	        			schedules[y][0] = temp0;
 
	        			temp1 = schedules[y-1][1];  
	        			schedules[y-1][1] = schedules[y][1];  
	        			schedules[y][1] = temp1;
	        		}  
	                          
	        	}
	    	}
	    	int caseNum = i+1;
	    	String finalCaseOutput = "Case #"+caseNum+":";
	    	String finalAnswer = "";
	    	int timeAllotedJ = 0;
	    	int timeAllotedC = 0;
	    	int schedNumCounter = 0;
	    	for(int x = 0; x < (24*60); x++) {
	    		if(timeAllotedJ > 0) {
	    			timeAllotedJ--;
	    		}
	    		if(timeAllotedC > 0) {
	    			timeAllotedC--;
	    		}
	    		if(schedNumCounter > N-1) {
	    			break;
	    		}
	    		if(schedules[schedNumCounter][0] == x) {
	    			
	    			if(timeAllotedJ == 0) {
	    				timeAllotedJ = schedules[schedNumCounter][1] - schedules[schedNumCounter][0];
	    				finalAnswer += " J";
	    				schedNumCounter+=1;
	    				if(schedNumCounter <= N-1 && schedules[schedNumCounter][0] == x) {
	    					if(timeAllotedC == 0) {
	    						timeAllotedC = schedules[schedNumCounter][1] - schedules[schedNumCounter][0];
	    						finalAnswer += " C";
	    						schedNumCounter+=1;
	    						if(schedNumCounter <= N-1 && schedules[schedNumCounter][0] == x) {
	    							finalAnswer = "IMPOSSIBLE";
	    						}
	    					}else {
	    						finalAnswer = "IMPOSSIBLE";
	    					}
	    				}
		    		}else if(timeAllotedC == 0){
		    			timeAllotedC = schedules[schedNumCounter][1] - schedules[schedNumCounter][0];
		    			finalAnswer += " C";
	    				schedNumCounter+=1;
	    				if(schedNumCounter <= N-1 && schedules[schedNumCounter][0] == x) {
	    						finalAnswer = "IMPOSSIBLE";
	    				}
		    		}else {
		    			finalAnswer = "IMPOSSIBLE";
		    		}
	    		}
	    	}
	    	finalCaseOutput += finalAnswer;
	    	System.out.println(finalCaseOutput);
	    }
	}

}