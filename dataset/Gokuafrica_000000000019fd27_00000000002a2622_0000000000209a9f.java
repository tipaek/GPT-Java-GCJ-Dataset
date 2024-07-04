
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int c = 1;
		StringBuffer output = new StringBuffer();
		while(c<=t) {
			String input = sc.nextLine();
			int openBrackets = 0;
			StringBuffer s = new StringBuffer();
			for(int i=0;i<input.length();++i) {
				int digit = Integer.parseInt(Character.toString(input.charAt(i)));
				while(openBrackets>digit) {
					s.append(")");
					--openBrackets;
				}
				while(openBrackets<digit) {
					s.append("(");
					++openBrackets;
				}
				s.append(Integer.toString(digit));
			}
			while(openBrackets>0) {
				s.append(")");
				--openBrackets;
			}
			output.append("Case #"+c+": "+s.toString()+"\n");
			++c;
		}
		System.out.print(output);
		sc.close();
	}

}
