import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i=1;i<=t;i++) {
			String s = in.readLine();
			System.out.println("Case #"+i+": "+comp(s));
		}
	}
	
	public static String comp(String s) {
		char c[] = s.toCharArray();
		Stack<Character> t = new Stack<Character>();
		for(int i=0;i<c.length;i++) {
			int n = Integer.parseInt(""+c[i]);
			//Add (
			for(int j=1;j<=n;j++) {
				if(!t.empty() && t.peek() == ')') {
					t.pop();
				} else {
					t.push('(');
				}
			}
			//Add num
			t.push(c[i]);
			
			//Add )
			for(int j=1;j<=n;j++) 
				t.push(')');
		}
		StringBuffer ans = new StringBuffer();
		while(!t.empty()) {
			ans.append(t.pop());
		}
		ans.reverse();
		return ans.toString();
	}
}
