import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner thisScanner = new Scanner(System.in);
		
		List<String> lines = new ArrayList<>();
		
				while(thisScanner.hasNext()) {
					lines.add(thisScanner.next());
				}

	

		String currentLine = "";
		String outputString = "";

		for(int i = 1; i <= Integer.parseInt(lines.get(0)); i++) {
			currentLine = lines.get(i);
			outputString = addParentheses(currentLine);
			System.out.println("Case #" + i + ": " + outputString);
		}

	}

	private static String addParentheses(String currentLine) {
		StringBuffer sb = new StringBuffer();
		int currentNbParentheses = 0;
		int decalage = 0;

		int c;
		for(int j = 0; j < currentLine.length(); j++) {
			c = Character.getNumericValue(currentLine.charAt(j));
			if(c > currentNbParentheses) {
				decalage = c - currentNbParentheses;
				for(int i = 0; i < decalage; i++) {
					currentNbParentheses++;
					sb.append("(");
				}
				sb.append(c);
			}
			else
				if(c < currentNbParentheses) {
					decalage = currentNbParentheses - c;
					for(int i = 0; i < decalage; i++) {
						currentNbParentheses--;
						sb.append(")");
					}
					sb.append(c);
				}
				else {
					sb.append(c);
				}
		}

		if(currentNbParentheses > 0) {
			for(int i = 0; i < currentNbParentheses; i++) {
				sb.append(')');
			}
		}

		return sb.toString();
	}

}