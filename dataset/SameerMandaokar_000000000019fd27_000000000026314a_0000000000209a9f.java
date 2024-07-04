
import java.io.*;
import java.util.*;

/**
 * Code about finding nesting depth of string of numbers.
 * 
 * @author smandaokar
 *
 */
public class Solution {

	public static void main(String[] args) {
		 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 
		 int testCasesCount = in.nextInt();
		 int counter=1;
		 
		 while(counter<=testCasesCount) {
			 String testData = in.next();
			 computeString(testData,counter);
			 counter++;
		 }
		 
	}

	/**
	 * 4
	 * 
	 * 0000 	Case #1: 0000 
	 *  
	 * 101		Case #2: (1)0(1) 
	 * 
	 * 111000 	Case #3: (111)000 
	 * 
	 * 1 		Case #4: (1)
	 * 
	 * Algo:
	 * 
	 * 1. Check if all the consecutive are zero if yes then send output as input.
	 * 2. Check for all the consecutive in batches:
	 * 		2.1 if consecutive-batch contains only 0, then append batch to output.
	 * 		2.2 if consecutive-batch contains only number between 1-9, then append batch 
	 * 			with surrounding having that many number of brackets
	 * @param counter 
	 * 
	 * 
	 * @param input
	 */
	private static void computeString(String inputString, int testCounter) {
		int count=0;
		int input[] = new int[inputString.length()];
		
		for(char c: inputString.toCharArray()) {
			input[count] = Integer.parseInt(String.valueOf(c));
			count++;
		}
		count=0;
		StringBuilder output = new StringBuilder();
		
		while(true) {
			
			if(count>=input.length)
				break;
			
			//1. Check for all zeros or consecutive batches
			int batchCount=0;
			while(count < input.length-1 && input[count] == input[count+1]) {
				
				if(input[count] == 0) {
					output.append(input[count]);
				}else
					batchCount++;
				count++;
			}
			
			if(count>=input.length)
				break;
			
			//2. Append batch of consecutive numbers
			if(count>0) {
				if(Integer.parseInt(String.valueOf(input[count])) == 0)
					output.append(0);
				else
					output.append(enclose(input[count],batchCount));
			}
			
			//3. No consecutive similar numbers
			if(count == 0) {
				if(Integer.parseInt(String.valueOf(input[count])) == 0) {
					output.append(0);
				}else {
					output.append(enclose(input[count],-1));
				}
			}
			count++;
		}
		System.out.println("Case #"+testCounter+": " +output.toString());
		
	}

	private static String enclose(int element, int batchCount) {
		StringBuilder opening = new StringBuilder();
		StringBuilder closing = new StringBuilder();
		StringBuilder elementBuilder = new StringBuilder();
		
		//Append brackets
		for(int i=1; i<=element; ++i) {
			opening.append("(");
			closing.append(")");
		}
		
		//Append number
		if (batchCount != -1) {
			for (int i = 0; i <= batchCount; ++i) {
				elementBuilder.append(element);
			}
		}else {
			elementBuilder.append(element);
		}
		return opening.toString()+elementBuilder.toString()+closing.toString();
	}
}
