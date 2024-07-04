import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		ArrayList<String> results = new ArrayList<String>(test_cases);
		for (int i=0 ; i<test_cases; i++) {
			String inp = sc.next();
			results.add(nesting(inp));
		}
		
		test_cases = 1;
		for(String result : results) {
			StringBuilder sb = new StringBuilder();
			sb.append("Case #");
			sb.append(test_cases);
			sb.append(": ");
			sb.append(result);
			System.out.println(sb.toString());
			test_cases++;
		}
	}
	
	public static String nesting(String input) {
		Deque<Character> stack = new ArrayDeque<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<input.length(); i++) {
			int value =  Integer.parseInt(input.substring(i, i+1));
			while(stack.size() < value) {
				stack.add('(');
				sb.append('(');
			}
			while(stack.size() > value) {
				stack.pop();
				sb.append(')');
			}
			sb.append(value);
		}
		while(stack.size() !=0) {
			stack.pop();
			sb.append(')');
			
		}
		
		return(sb.toString());
	}

}
