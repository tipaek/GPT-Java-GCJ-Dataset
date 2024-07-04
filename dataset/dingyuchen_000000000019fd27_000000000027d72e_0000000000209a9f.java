import java.util.*;

public class Solution {
    private void solve(int testNo, String digits) {
	int length = digits.length();
	Stack<Character> stack = new Stack<>();
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < length; i++) {
	    int level = Character.getNumericValue(digits.charAt(i));
	    while (stack.size() < level) {
		stack.push('(');
		sb.append('(');
	    }
	    while (stack.size() > level) {
		stack.pop();
		sb.append(')');
	    }
	    sb.append(level);
	}
	while (stack.size() > 0) {
	    stack.pop();
	    sb.append(')');
	}
	System.out.println(String.format("Case #%d: %s",
					 testNo, sb.toString()));
    }
    public void run() {
	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for (int i = 0; i < T; i++) {
	    String input = sc.next();
	    solve(i + 1, input);

	}
    }
    public static void main(String[] args) {
	new Solution().run();
    }
}
