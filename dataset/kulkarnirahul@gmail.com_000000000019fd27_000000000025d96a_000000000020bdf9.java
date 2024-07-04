import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
			  
			 List<int []> jList = new ArrayList<int []>();
			 List<int []> cList = new ArrayList<int []>();

			  
			  for(int j=0; j < noOfInputs ; j++){
				  
				  String testCase = input.nextLine();
				  String [] rowArray = testCase.split(" ");
		
	     			int startTime = Integer.parseInt(rowArray[0]);
	     			int endTime = Integer.parseInt(rowArray[1]);

	     			if (jStartTime == 0 && jEndTime == 0 ){
	     				returnString.append("J"); 
	     				jStartTime= startTime;
	     				jEndTime = endTime;	
	     				jList.add(new int[]{startTime,endTime});
	     			}
	     			else if (startTime >= jEndTime  || endTime < jStartTime ){
	     				returnString.append("J"); 
	     				jEndTime = endTime;
	     				jStartTime = startTime;
	     				jList.add(new int[]{startTime,endTime});

    				}
	     			else if (cstartTime == 0 && cEndTime == 0 ){
	     				returnString.append("C"); 
	     				cstartTime= startTime;
	     				cEndTime = endTime;	
	     				cList.add(new int[]{startTime,endTime});

	     			}
	     			else if (startTime >= cEndTime  || endTime < cstartTime){
	     				returnString.append("C"); 
	     				cEndTime = endTime;
	     				cstartTime = startTime;
	     				cList.add(new int[]{startTime,endTime});

    				}

	     			else{
	     				boolean jCan = deepCheck(jList, startTime, endTime);
	     				boolean cCan = deepCheck(cList,  startTime, endTime);
	     				
	     				if (jCan){
	     					returnString.append("J"); 
		     			
		     				jList.add(new int[]{startTime,endTime});
	     					
	     				}
	     				else if (cCan){
	     					
		     				returnString.append("C"); 

		     				cList.add(new int[]{startTime,endTime});
	     				}
	     				else{
	     				notPossible = true;
	     				}
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

	private static boolean deepCheck(List<int[]> list,  int start, int end) {
		// TODO Auto-generated method stub
		
		boolean checkEnd = false;
		
		for (int i=0; i < list.size() ; i++){
			
			int[] currentTsk = list.get(i);
			
			if (start > currentTsk[1]  ){
				checkEnd = true;
				
			};
			if (checkEnd && (end < currentTsk[0])){
				
				return true;
			};
		}
		return false;
		
	}

	
	
	
}
