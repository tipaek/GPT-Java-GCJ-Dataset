import java.util.Scanner;

public class Solution {
	private static void appendStartParenthesis(String count,StringBuilder result) {
		switch(count) {
			case "1": result.append("("); break;
			case "2": result.append("(("); break;
			case "3": result.append("((("); break;
			case "4": result.append("(((("); break;
			case "5": result.append("((((("); break;
			case "6": result.append("(((((("); break;
			case "7": result.append("((((((("); break;
			case "8": result.append("(((((((("); break;
			case "9": result.append("((((((((("); break;
		}
		//return result;
	}
	private static void appendEndParenthesis(String count,StringBuilder result) {
		switch(count) {
			case "1": result.append(")"); break;
			case "2": result.append("))"); break;
			case "3": result.append(")))"); break;
			case "4": result.append("))))"); break;
			case "5": result.append(")))))"); break;
			case "6": result.append("))))))"); break;
			case "7": result.append(")))))))"); break;
			case "8": result.append("))))))))"); break;
			case "9": result.append(")))))))))"); break;
		}
		//return result;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();sc.nextLine();
		for(int i=1;i<=cases;i++) {
			StringBuilder result = new StringBuilder("");
			String[] input = sc.nextLine().split("");
			int braces=0;
			for(int j=0;j<input.length;j++) {
				if(braces==0)
				{
					appendStartParenthesis(input[j], result);
					result.append(input[j]);
					braces = Integer.parseInt(input[j]);
				}
				else if(input[j].equals(input[j-1]))
					result.append(input[j]);
				else if(Integer.parseInt(input[j-1])>Integer.parseInt(input[j]))
				{
					int diff = Integer.parseInt(input[j-1])-Integer.parseInt(input[j]);
					appendEndParenthesis(diff+"", result);
					result.append(input[j]);
					braces-= diff;
				}
				else if(Integer.parseInt(input[j-1])<Integer.parseInt(input[j]))
				{
					//int diff = Integer.parseInt(input[j-1])-Integer.parseInt(input[j]);
					int startDiff = Integer.parseInt(input[j])-braces;
					appendStartParenthesis(startDiff+"", result);
					//appendEndParenthesis(diff+"", result);
					result.append(input[j]);
					braces+= startDiff;
				}
			}
			appendEndParenthesis(braces+"", result);
			System.out.println("Case #"+i+": " +result);
		}

	}
}