import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		int i, j, k, currentVal, previousVal;
		
		Scanner input = new Scanner(System.in);
		int numOfTest = input.nextInt();
		input.nextLine();
        for(k = 0; k < numOfTest; k++) {
        	String inputString = input.nextLine();
			
			StringBuffer inputStringBuffer = new StringBuffer(inputString);
			System.out.print("Case #"+k+": ");
			
			bracesModifier(Integer.parseInt(String.valueOf(inputStringBuffer.charAt(0))), Integer.parseInt(String.valueOf(inputStringBuffer.charAt(0))), true);
			
			for (i = 1; i < inputStringBuffer.length(); i++) {
				currentVal = Integer.parseInt(String.valueOf(inputStringBuffer.charAt(i)));
				previousVal = Integer.parseInt(String.valueOf(inputStringBuffer.charAt(i-1)));
				if (currentVal - previousVal > 0 ) {
					bracesModifier(currentVal, currentVal - previousVal, true);
				} else if (currentVal - previousVal < 0) {
					bracesModifier(currentVal, previousVal - currentVal, false);
				} else {
					System.out.print(currentVal);
				}
			}
			int lastChar = Integer.parseInt(String.valueOf(inputStringBuffer.charAt(inputString.length()-1)));
			for (j = 0; j < lastChar; j++) {
				System.out.print(")");
			}
        	System.out.println();
        }
		input.close();
	}
	
	public static void bracesModifier(int charValue, int braceNumber, boolean braceIdentifier) {
		int i;
		if(braceIdentifier) {
			for(i = 0; i < braceNumber;i++) {
				System.out.print("(");
			}
			System.out.print(charValue);
		}
		else {
			System.out.print(charValue);
			for(i = 0; i < braceNumber;i++) {
				System.out.print(")");
			}
		}
	}
}
