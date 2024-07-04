import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static String[] ParanthesisCache = new String[20];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int testCasesNum = scanner.nextInt();
		for (int i = 1; i <= testCasesNum; i++) {
			char[] S = scanner.next().trim().toCharArray();
			int digit = S[0] - '0';
			String wrappedS = createParenthesis(digit, true) + digit;
			for (int j = 1; j < S.length; j++) {
				int nextDigit = S[j] - '0';
				int diff = nextDigit - digit;
				wrappedS += createParenthesis(Math.abs(diff), diff > 0) + nextDigit; 
				digit = nextDigit;
			}
			wrappedS += createParenthesis(digit, false);
			System.out.println("Case #" + i + ": " + wrappedS);
		}
		try{
			scanner.close();
		}
		catch (Exception e){}
		System.out.flush();
	}
	
	private static String createParenthesis(int count, boolean openning)
	{
		if (ParanthesisCache[openning?count:count+10] == null){
			String temp = "";
			for (int i = 0; i < count; i++) {
				temp += (openning?"(":")");
			}
			ParanthesisCache[openning?count:count+10] = temp;
		}
		return ParanthesisCache[openning?count:count+10];
	}
}