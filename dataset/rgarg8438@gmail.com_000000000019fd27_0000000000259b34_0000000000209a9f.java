
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int cases = sc.nextInt();
	for (int i = 0; i < cases; i++) {
		String s = sc.next();
		//System.out.println(s);
		Stack<Character> st = new Stack<Character>();
		for (int j = 0; j < s.length(); j++) {
			//System.out.println(s.charAt(j));
			int num = s.charAt(j)-'0';
			//System.out.println(num);
			int count = 0;
			while(count<num & !st.isEmpty() && st.peek()==')')
			{
				count++;
				st.pop();
				//System.out.println(st.pop()+"????????");
			}
			count = num-count;
			
			while(count>0)
			{
				st.push('(');
				count--;
			}
			st.push((char) s.charAt(j));
			while(num>0)
			{
				st.push(')');
				num--;
			}
		}
		String ans = new String();
		while(!st.isEmpty())
		{	ans = st.peek()+ans;
			st.pop();
		}
		
        System.out.println("Case #"+(i+1)+": "+ans);
	}
}
}
