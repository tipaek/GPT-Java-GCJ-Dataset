import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<testCases;i++) {
			StringBuilder sbThisCase = new StringBuilder();
			String line = in.nextLine();
			int currentParens = 0;
			char[] characters = line.toCharArray();
			for(int j=0;j<characters.length;j++) {
				int thisNumber = characters[j] - '0';
				while(thisNumber > currentParens) {
					//We need to add parenthesis to match
					sbThisCase.append("(");
					currentParens++;
				}
				while(thisNumber < currentParens) {
					sbThisCase.append(")");
					currentParens--;
				}
				sbThisCase.append(characters[j]);
			}
			while(0 < currentParens) {
				sbThisCase.append(")");
				currentParens--;
			}
			sb.append("Case #").append(i+1).append(": ").append(sbThisCase).append("\n");
		}
		System.out.print(sb);
	}
}
