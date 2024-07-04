
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		for ( int i = 1; i <= cases; i++ ) {
			processCase(i, in);
		}
	}
	
	static void processCase(int caseNo, Scanner in) throws Exception {
		int B = in.nextInt();
		if ( 10 != B ) {
			throw new RuntimeException("Only support simple case for now");
		}
		StringBuilder sb = new StringBuilder();
		for ( int i = 1; i <= B; i++ ) {
			System.out.println(i);
			System.out.flush();
			String response = in.next();
			if ( "N".equals(response) )
				return;
			sb.append(response);
		}
		System.out.println(sb.toString());
		System.out.flush();
		in.next();
	}
}
