import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = Integer.parseInt(in.nextLine());
		
		for (int t=1; t<=T; t++){
			String line = in.nextLine();
			StringBuilder result = new StringBuilder();
			int prevInt = 0;
			for (int i = 0; i< line.length(); i++) {
				int currentInt = Integer.parseInt((String) line.subSequence(i, i+1));
				int difference = currentInt - prevInt;
				while (difference != 0) {
					if (difference < 0) {
						result.append(")");
						difference++;
					} else {
						result.append("(");
						difference--;
					}
				}
				result.append(currentInt);
				prevInt = currentInt;
			}
			
			while (prevInt != 0) {
				if (prevInt > 0) {
					result.append(")");
					prevInt--;
				} 
			}
			
			String s = result.toString();
			
			System.out.printf("Case #%d: %s%n", t, s);
		}
	}

}
