
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		int B = in.nextInt();
		for ( int i = 1; i <= T; i++ ) {
			processCase(i, B, in);
		}
	}
	
	static void processCase(int caseNo, int B, Scanner in) throws Exception {
		//System.err.printf("Starting with case %s and value %s\n", caseNo, B);
		if ( 10 != B ) {
			throw new RuntimeException("Only support simple case for now");
		}
		StringBuilder sb = new StringBuilder();
		for ( int i = 1; i <= B; i++ ) {
			//System.err.printf("Printing %s\n", i);
			System.out.println(i);
			System.out.flush();
			String response = in.next();
			//System.err.printf("Got response %s\n", response);
			if ( "N".equals(response) )
				return;
			sb.append(response);
		}
		//System.err.printf("Printing solution %s\n", sb.toString());
		System.out.println(sb.toString());
		System.out.flush();
		String res2 = in.next();
		//System.err.printf("Got final %s\n", res2);
	}
}

// 0001101111
// 0000100111