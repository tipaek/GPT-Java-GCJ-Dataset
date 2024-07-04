import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = Integer.parseInt(scanner.nextLine());
		for(int k=1;k<=numberOfTestCases;k++) {
			String str = scanner.nextLine();
			String requiredString = getBalancedParenthesisString(str);
			System.out.println("Case #"+k+": "+requiredString);
		}
	}
	
	public static String getBalancedParenthesisString(String str) {
		String requiredString = "";
		char[] charArray = str.toCharArray();
		int count=0;
		int diff=0;
		for(char c : charArray) {
			int num = Character.getNumericValue(c);
			if(requiredString=="") {
				count=num;
				for(int i=0;i<num;i++)
					requiredString+="(";
				requiredString+=num;
			}else {
				if(count<num) {
					diff=num-count;
					for(int i=0;i<diff;i++)
						requiredString+="(";
					count+=diff;
				}else if(count>num) {
					diff = count-num;
					for(int i=0;i<diff;i++)
						requiredString+=")";
					count-=diff;
				}
				requiredString+=num;
			}
		}
		for(int i=0;i<count;i++)
			requiredString+=")";
		
		return requiredString;
	}

}
