import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		int testCase = 0;
		int flag = 0;
		ArrayList<String> input= new ArrayList<String>();
		testCase = scanner.nextInt();
		
		while( flag <= testCase) {
			String line = scanner.nextLine();
			if(!line.equalsIgnoreCase("")) {
			input.add(line);			
			}
			flag++;
		}

		
		for(int i = 0; i < input.size(); i++) {
			System.out.println(calc(input.get(i), i + 1));		
		}
	}
	
	static String calc(String input, int outPutCase) {
		StringBuilder result = new StringBuilder("Case #");
		result.append(outPutCase).append(": ");
		
		String[] inputSplit = input.split("");
		int[] number = new int[inputSplit.length];
		
		for(int i = 0; i < inputSplit.length; i++) {	
			number[i] = Integer.parseInt(inputSplit[i]);
		}
		
		
		for(int i = 0; i < number.length; i++) {	
			
			
			if(i == 0) {
				if(number[i] == 0) {
				result.append(0);
				}
				else if(number.length > 1){
					result.append(openPar(number[i]));
					result.append(number[i]);
				}else if(number.length == 1){
					result.append(openPar(number[i]));
					result.append(number[i]);
					result.append(closePar(number[i]));
				} 
			}
			
			else {

				if (number[i-1] == number[i]) {
				result.append(number[i]);
				}
			
				if (number[i-1] < number[i]) {
				result.append(openPar(number[i] - number[i-1]));
				result.append(number[i]);
				}
				
				if (number[i-1] > number[i]) {
				result.append(closePar(number[i-1] - number[i]));
				result.append(number[i]);
				}
				
				if(i == number.length-1) {
					result.append(closePar(number[i]));
					
				}
			}
		}
		
		
		
		return result.toString();
	}
	
	static String openPar(int x) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < x ; i++) {
			result.append("(");
		}
				
		return result.toString();
		
	}
	
	static String closePar(int x) {
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < x ; i++) {
			result.append(")");
		}
				
		return result.toString();
		
	}
}
