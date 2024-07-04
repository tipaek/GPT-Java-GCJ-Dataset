import java.io.InputStream;
import java.util.Scanner;

public class Solution {

	public static void main( String[] argv ) throws Exception {
		InputStream inputStream = System.in;
		String response = doJob(inputStream);
		System.out.print(response);
	}

	public static String doJob(InputStream inputStream) {
		Scanner sc = new Scanner(inputStream);
		StringBuilder solution = new StringBuilder();
		int testCaseNumber = Integer.valueOf(sc.nextLine());
		for(int i = 0; i< testCaseNumber; i++) {
			String[] testCases = sc.nextLine().split(" ");
			int life = Integer.valueOf(testCases[0]); 
			String instruction = testCases[1];
			int moveNumber = solve(instruction,life);
			solution.append("Case #"+i+": "+moveNumber);
		}
		
		return solution.toString();
	}

	private static int solve(String instruction, int life) {
		// TODO Auto-generated method stub
		return 0;
	}
}