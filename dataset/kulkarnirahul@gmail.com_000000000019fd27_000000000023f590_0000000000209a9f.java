import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Scanner input = new Scanner(System.in);
		  int numberOfTestcases = Integer.parseInt(input.nextLine());
		  for(int i=0; i < numberOfTestcases ; i++){
			  StringBuffer returnString = new StringBuffer();
			  String testCase = input.nextLine();
			  String [] rowArray = testCase.split("");
			  
			  int openingBraces = 0;
			  int closingBraces = 0;
			  
			  for (int z= 0; z< rowArray.length ; z++){
     			 int singleDigit = Integer.parseInt(rowArray[z]);
     			 
     			 for (int j=0; j <= singleDigit; j++){
     				
     				if (singleDigit > openingBraces){
         				returnString.append("(");
         				openingBraces ++;	
     				}
     				else if (singleDigit < openingBraces){
         				returnString.append(")");
         				openingBraces --;	
     				}
     			 }
     			returnString.append(singleDigit);
     		 }
			  
   			for (int k = 0 ; k <openingBraces; k++ ){
 				returnString.append(")");
 			}  
   			System.out.println("Case #"+(i+1)+": "+returnString);
		  }

	}

}
