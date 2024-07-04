import java.util.*;
class Solution {
	public static void main(String asdf[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		if(t>=1 && t<=100) {
			for(int z=1;z<=t;z++) {
				String s = in.next();
				if(s.length()>=1 && s.length() <=100) {
					LinkedList<Character> stk = new LinkedList<>();
					for(int i=0;i<s.length();i++) {
						if(s.charAt(i)=='0') {
							if(stk.isEmpty()) stk.push('0');
							else if(!stk.isEmpty() && (stk.peek()=='0' || stk.peek()==')')) stk.push('0');
							else if(!stk.isEmpty() && stk.peek()=='1') {
								stk.push(')');
								stk.push('0');
							}
						}
						else if(s.charAt(i)=='1') {
							if(stk.isEmpty()) {
								stk.push('(');
								stk.push('1');
							}
							else if(!stk.isEmpty() && stk.peek()=='0') {
								stk.push('(');
								stk.push('1');
							}
							else if(!stk.isEmpty() && stk.peek()=='1') stk.push('1');
						}
						if(i==s.length()-1 && stk.peek()=='1') stk.push(')');
					}
					System.out.print("Case #"+z+": ");
					for(int i=stk.size()-1;i>=0;i--) System.out.print(stk.get(i));
					System.out.println();
					stk.clear();
				}
			}
		}
	}
}

				