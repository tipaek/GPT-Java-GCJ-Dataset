import java.util.*;
public class Solution {
	
	
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int test=1; test<=t; test++){
			String str = s.next();
			char max = '0';
			Stack<Character> st = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				st.push(str.charAt(i));
			}
			String ans = "";
			int o=0;
			while(st.size()>0 && st.peek()=='0') {
				ans = ans+st.pop();
			}
			int curr = 0;
			char prev = '0';
			char next = '0';
			while(st.size()!=0) {
				next = st.pop();
				if(next>prev) {
					int diff = next-prev;
					for(int i=0; i<diff; i++) {
						ans = ')'+ans;
						o++;
					}
					ans = next + ans;
				}else if(next==prev) {
					ans = next+ans;
				}else {
					int diff = prev-next;
					for(int i=0; i<diff; i++) {
						ans = '('+ans;
						o--;
					}
					ans = next+ans;
				}
				prev=next;
			}
			for(int i=0; i<o; i++) {
				ans = "("+ans;
			}
			System.out.println("Case #"+test+": " +  ans);
			
		}
	}
	

}