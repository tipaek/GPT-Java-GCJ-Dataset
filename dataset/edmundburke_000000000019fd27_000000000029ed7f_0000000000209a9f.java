import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int caseCount;
	static int caseIndex = 0;

	public static void main(String[] args) {
		ArrayList<char[]> rows = systemInToCharRows();
		
		caseCount = Integer.parseInt(Character.toString(rows.remove(0)[0]));
		while(caseCount > 0) {
			processCase(rows.remove(0));
			caseCount--;
		}
	}
	
	public static void processCase(char[] row) {
		caseIndex++;
		StringBuilder sb = new StringBuilder("Case #" + caseIndex + ": ");
		int depth = 0;
		for(char c : row) {
			int charDepth = Integer.parseInt(Character.toString(c));
			while(charDepth > depth) {
				sb.append('(');
				depth++;
			}
			while(charDepth < depth) {
				sb.append(')');
				depth--;
			}
			sb.append(c);
		}
		while(depth > 0) {
			sb.append(')');
			depth--;
		}
		System.out.println(sb.toString());
	}
	
	public static ArrayList<char[]> systemInToCharRows(){
		ArrayList<String> rows = systemInToStringRows();

		ArrayList<char[]> charRows = new ArrayList<char[]>();
		for(String row : rows) {
			charRows.add(row.toCharArray());
		}
		return charRows;
	}
	
	public static ArrayList<String> systemInToStringRows(){
		String input = "4\n" + "0000\n" + "101\n" + "111000\n" + "1";
		input = "4\n" + "021\n" + "312\n" + "4\n" + "221";
		
		Scanner scanner = new Scanner(System.in);
		// Scanner scanner = new Scanner(input);
		ArrayList<String> inputLines = new ArrayList<String>();
		while(scanner.hasNext()) {
			inputLines.add(scanner.nextLine());
		}
		scanner.close();
		return inputLines;
	}
}
