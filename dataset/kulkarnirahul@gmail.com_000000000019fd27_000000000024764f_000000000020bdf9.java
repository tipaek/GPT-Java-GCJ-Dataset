import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Scanner input = new Scanner(System.in);
		  int numberOfTestcases = Integer.parseInt(input.nextLine());
		  for(int i=0; i < numberOfTestcases ; i++){
			  StringBuffer returnString = new StringBuffer();
			  int jStartTime = 0;
			  int jEndTime =0;
			int cstartTime = 0;
			  int cEndTime=0;
			  int noOfInputs = Integer.parseInt(input.nextLine());
			  boolean notPossible = false;
			  
			  for(int j=0; j < noOfInputs ; j++){
				  
				  String testCase = input.nextLine();
				  String [] rowArray = testCase.split(" ");
		
	     			int startTime = Integer.parseInt(rowArray[0]);
	     			int endTime = Integer.parseInt(rowArray[1]);

	     			if (jStartTime == 0 && jEndTime == 0 ){
	     				returnString.append("J"); 
	     				jStartTime= startTime;
	     				jEndTime = endTime;	
	     			}
	     			else if (startTime >= jEndTime  || endTime < jStartTime){
	     				returnString.append("J"); 
	     				jEndTime = endTime;
    				}
	     			else if (cstartTime == 0 && cEndTime == 0 ){
	     				returnString.append("C"); 
	     				cstartTime= startTime;
	     				cEndTime = endTime;	
	     			}
	     			else if (startTime >= cEndTime  || endTime < cstartTime){
	     				returnString.append("C"); 
	     				cEndTime = endTime;
    				}
	     			else{
	     				notPossible = true;
	     				
	     			}
	     			
	     		//	System.out.println("startTime"+startTime +"---endTime+: "+endTime);
	     		//	returnString.append("J");
	     	
				  
			  }
			  
			if (notPossible){
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}
			else{
				System.out.println("Case #"+(i+1)+": "+returnString);
			}
		  }

	}

}
