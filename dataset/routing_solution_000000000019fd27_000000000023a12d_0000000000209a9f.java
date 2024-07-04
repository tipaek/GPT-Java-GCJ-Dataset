
import java.util.*;
import java.io.*;

class Solution {

	public static void main(String[] args) {
		
		String inputNumbers;
		int testCase, testCounter = 1;
		
		Scanner inputScanner = new Scanner(System.in);
		
		testCase = inputScanner.nextInt();
		inputScanner.nextLine();
		
		while(testCounter <= testCase) {
			inputNumbers = inputScanner.nextLine();
			
			
			//Number Char Array
			char[] ch = new char[inputNumbers.length()]; 
			  
	        // Copy character by character into array 
	        for (int i = 0; i < inputNumbers.length(); i++) { 
	            ch[i] = inputNumbers.charAt(i); 
	        } 
	        
	        
	        List<Character> nestedDepths = new ArrayList<>();
	        for (char c : ch) { 
	        	
	            int number = Character.getNumericValue(c);
	            
	            for (int i = 0; i < number; i++) {
	            	nestedDepths.add('(');
				}
	            
	            nestedDepths.add(c);
	            
	            for (int i = 0; i < number; i++) {
	            	nestedDepths.add(')');
				}
	        } 
	        
	        
	        boolean isFound = true;
			while (isFound) {
				isFound = false;
				int index = 0;
				int sizeOfArray = nestedDepths.size();
				while (index < (sizeOfArray - 2)) {
					char first = nestedDepths.get(index);
					char second = nestedDepths.get(index + 1);
					if (first == ')' && second == '(') {
						nestedDepths.set(index, 'e');
						nestedDepths.set(index + 1, 'e');
						isFound = true;
						break;
					}
					index++;
				}
				 
				nestedDepths.removeAll(Collections.singleton('e'));
			}
	        	        
			System.out.print("Case #"+testCounter+": ");
	        for (int i = 0; i < nestedDepths.size(); i++) {
	        	System.out.print(nestedDepths.get(i));
			}
	        
	        System.out.println();
	        
			testCounter++;
			
		}
	}

}
