

import java.util.*;
public class Solution{


	public static void main(String args[]){

		Scanner sca = new Scanner(System.in);
		int t = sca.nextInt();
		int kase = 1;
		while(t-- > 0){
			
			String s = sca.next();
			int n = s.length();
			Stack<Character> stack = new Stack<>();
			int j = 0;

			for(int i = 0; i < n; i++){

				int digit = s.charAt(i) - '0';
				if(stack.isEmpty()){
					for(j = 0; j < digit; j++){
						stack.push('(');
					}
				}else{
					int k = stack.peek() - '0';
					if(k > digit){
						for(j = 0; j < (k - digit); j++){
							stack.push(')');
						}
					}else{
						for(j = 0; j < (digit - k); j++){
							stack.push('(');
						}
					}

				}
				stack.push(s.charAt(i));
			}
			int k = stack.peek() - '0';
			for(j = 0; j < k; j++){
				stack.push(')');
			}

			StringBuilder ans = new StringBuilder();
			while(!stack.isEmpty()){
				ans.append(stack.pop());
			}
			System.out.println("Case #: " + (kase++) + ": " + ans.reverse().toString());
		}
	}

}