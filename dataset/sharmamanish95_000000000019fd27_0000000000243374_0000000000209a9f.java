import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i<=t; i++) {
            String input = sc.nextLine();
            String ans = solve(input);
            System.out.println("Case #"+ i +": " + ans);
        }
    }
    
    static String solve(String input) {
		int n = input.length();
		int prev = 0;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<n; i++) {
			char ch = input.charAt(i);
			int curr = Character.getNumericValue(ch);
			int val = curr-prev;
			if(val>0) {
				for(int j = 0; j<val; j++) {
					sb.append('(');
					stack.push('(');
				}
			}else if(val<0){
				for(int j = 0; j<Math.abs(val); j++) {
					sb.append(')');
					stack.pop();
				}
			}
			sb.append(ch);
			prev = curr;
		}
		while(!stack.isEmpty()) {
			sb.append(')');
			stack.pop();
		}
		return sb.toString();
	}
    
    
    
}
