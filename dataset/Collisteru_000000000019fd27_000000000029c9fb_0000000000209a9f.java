import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int limit = in.nextInt();
		in.nextLine();
		for(int l = 0; l<limit; l++) { //Main program loop, odd loop problem, test in normal environment
			StringBuilder str = new StringBuilder(in.nextLine());
			StringBuilder out = new StringBuilder();
			int size = str.length();
			for(int c = 0; c<size; c++) { //Character analysis loop
				StringBuilder ch = new StringBuilder();
				ch.append(str.charAt(c));
				StringBuilder before = new StringBuilder();
				StringBuilder after = new StringBuilder();
				for(int p = 0; p<str.charAt(c)-'0';p++) { //Adding Parentheses
					before.append('(');
					after.append(')');
				}
				ch.insert(0, before);
				ch.append(after);
				out.append(ch);
			}
			//Phase 2
			while(out.toString().contains(")(")) {
				out.delete(out.indexOf(")("), out.indexOf(")(")+2);
			}
			System.out.print("Case #" + (l+1) + ": ");
			System.out.println(out.toString());
		}
	}
}
