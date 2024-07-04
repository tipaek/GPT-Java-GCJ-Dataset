import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
	    int T = Integer.parseInt(scanner.nextLine());
	    for(int i = 0; i < T; i++) { //T test cases
	    	String input = scanner.nextLine();
	    	int caseNumber = i+1;
	    	String output = "Case #"+caseNumber+": ";
	    	String semiFinalOut = "";
	    	String lastDigit = "0";
	    	for(int j = 0; j < input.length(); j++) {
	    		int lastDigitint = Integer.parseInt(lastDigit);
	    		int currentDigit = Integer.parseInt(input.charAt(j)+"");
	    		if(lastDigitint == currentDigit) {
	    			semiFinalOut += currentDigit+"";
	    		}else if(lastDigitint < currentDigit) {
	    			for(int k = 0; k < (currentDigit-lastDigitint); k++) {
	    				semiFinalOut+="(";
	    				semiFinalOut += currentDigit+"";
	    			}
	    		}else if(lastDigitint > currentDigit) {
	    			for(int k = 0; k < (lastDigitint-currentDigit); k++) {
	    				semiFinalOut+=")";
	    				semiFinalOut += currentDigit+"";
	    			}
	    		}
	    		lastDigit = currentDigit+"";
	    	}
	    	int lastNum = Integer.parseInt(lastDigit);
	    	if(lastNum > 0) {
	    		for(int k = 0; k < (lastNum-0); k++) {
    				semiFinalOut+=")";
    			}
	    	}
	    	System.out.println(output+semiFinalOut);
	    }
	}

}