import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	private String nestingString(String s) {
		int len = s.length();
		StringBuilder res = new StringBuilder();
		if(len==0)
			return "";
		int index = 0;
		int prevNum = 0;
		Stack<String> st =new Stack<>();
		while(index<len) {
			
			char currChar = s.charAt(index);
			int currNum = Integer.valueOf(String.valueOf(currChar));
			int diff = currNum - prevNum;
			prevNum = currNum;
			if(diff>0) {
				while(diff!=0) {
					st.push("(");
					res.append("(");
					diff--;
				}
			}
			
			if(diff<0) {
				while(diff!=0) {
					st.pop();
					res.append(")");
					diff++;
				}
			}
			res.append(currChar);
			index++;
			while(index<len && s.charAt(index)==currChar)
				res.append(s.charAt(index++));
		}
		while(!st.isEmpty()) {
			st.pop();
			res.append(")");
		}
		
		return res.toString();
		
	}
	public static void main(String args[]){
		Solution sol = new Solution();
		Scanner  sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1;i<=t;i++) {
			String s = sc.next();
		    System.out.println("Case #"+i+": "+sol.nestingString(s));
		}
		sc.close();
				
	    }

}