import java.util.*;
import java.io.*;


class Solver {
	String numbers;
	int closingAt[];
	int openingAt[];

	public String solve(String numbers){
		this.numbers = numbers;
		this.closingAt = new int[numbers.length() + 1];
		this.openingAt = new int[numbers.length() + 1];

		for(int minVal = 1; minVal <= 9; ++minVal) {
			placeForVal(minVal);
		}

		return buildString();
	}

	public void placeForVal(int minVal) {
		int start = 0;
		while(start < numbers.length()) {
			int end = start;
			while(end < numbers.length() && asInt(numbers.charAt(end)) >= minVal){
					end++;
			}
			if(end == start){
				start++;
			}else{
				openingAt[start]++;
				closingAt[end]++;
				start = end;
			}
		}
	}


	public String buildString() {
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < openingAt[0]; ++i)
			sb.append('(');

		for(int i = 0; i < numbers.length(); ++i) {
			sb.append(numbers.charAt(i));

			for(int j = 0; j < closingAt[i+1]; ++j)
				sb.append(')');
			for(int j = 0; j < openingAt[i+1]; ++j)
				sb.append('(');
		}
		return sb.toString();
	}

	int asInt(char c) {
		return c - '0';
	}

}



public class Solution {
	static PrintWriter pw;
	static BufferedReader br;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		Solver solver = new Solver();
		int tests = Integer.parseInt(br.readLine());
		for(int test = 1; test <= tests; ++test){ 
			String numbers = br.readLine();
			String solution = solver.solve(numbers);
			pw.printf("Case #%d: %s\n", test, solution);
		}
		pw.close();
	}	
}