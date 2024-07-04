import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

	InputStream in;
	PrintStream out;
	Scanner scanner;

	
	Solution(InputStream in, PrintStream out){
		this.in = in;
		this.out=out;
		scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
	}
	
	int B;
	StringBuilder result;
	
	private void readTest() {
	}


	private void calculate() {
		result=new StringBuilder();
		for(int i=1;i<=B;i++) {
			out.println(i);
			result.append(scanner.nextLine());
		}
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(result);
		out.println(sb.toString());
		if(scanner.nextLine().equals("N"))
			System.exit(5);
		
	}

	public static void main(String[] args) {
		new Solution(System.in, System.out).run();
	}

	public void run() {
		int T = scanner.nextInt();
		B = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}
