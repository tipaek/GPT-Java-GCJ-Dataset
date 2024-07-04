import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	String s;
	StringBuilder outsb;
	
	private void readTest() {
		s = scanner.nextLine();
	}


	private void calculate() {
		outsb=new StringBuilder();
		int curopen=0;
		for(int i=0;i<s.length();i++) {
			int c= Integer.parseInt(s.substring(i,i+1),10);
			if (c<curopen)
				for(int j=0;j<curopen-c;j++)
					outsb.append(')');
			if (c>curopen)
				for(int j=0;j<c-curopen;j++)
					outsb.append('(');
			curopen=c;
			outsb.append(s.charAt(i));
		}
		for(int i=0;i<curopen;i++)
			outsb.append(')');
		
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #" + i + ": ");

		sb.append(outsb);
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		new Solution().run();
	}

	public void run() {
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}
