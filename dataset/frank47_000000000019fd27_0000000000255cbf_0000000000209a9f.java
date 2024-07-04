import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine().trim());
		int testcase = 0;

		while(testcase < t) {
			testcase++;
			String digitString = sc.nextLine();
			
			String finalString = nestString(digitString);
			System.out.println("Case #"+testcase+": "+finalString);
		}

		sc.close();
	}

	private static String nestString(String digitString) {
		StringBuilder finalString = new StringBuilder();
		int startDigit = 0;
		
		for (int i=0; i<digitString.length(); i++) {
			int tempInt = Integer.parseInt(String.valueOf(digitString.charAt(i)));
			int difference = tempInt - startDigit;
			insertParans(finalString,difference);
			finalString.append(digitString.charAt(i));
			startDigit = tempInt;
		}
		insertParans(finalString,-startDigit);
		
		return finalString.toString();
	}

	private static void insertParans(StringBuilder finalString, int difference) {
		if(difference == 0) {
			return;
		}
		
		if(difference < 0) {
			for(int i=0; i<Math.abs(difference); i++) {
				finalString.append(')');
			}
		}
		
		if(difference > 0) {
			for(int i=0; i<difference; i++) {
				finalString.append('(');
			}
		}
	}


}
