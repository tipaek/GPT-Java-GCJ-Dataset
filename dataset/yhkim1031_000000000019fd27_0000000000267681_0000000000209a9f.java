import java.util.Scanner;
import java.util.Stack;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for(int i=0;i<t;i++) {
			Stack<Character> stack = new Stack<>();
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			for(int l=0;l<s.length();l++) {
				char cur = s.charAt(l);
				int num = cur-'0';
				int stackSize = stack.size();
				if(num-stackSize>=0) {
					for(int x=0;x<num-stackSize;x++) {
						sb.append('(');
						stack.push('(');
					}
					sb.append(num);
				}else {
					for(int x=0;x<stackSize-num;x++) {
						sb.append(')');
						stack.pop();
					}
					sb.append(num);
				}
			}
			while(!stack.isEmpty()) {
				stack.pop();
				sb.append(')');
			}
			System.out.println("Case #"+(i+1)+": "+sb.toString());
		}
	}
}