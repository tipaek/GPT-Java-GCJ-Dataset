//package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static StringBuilder answer= new StringBuilder();
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int h=1;
		while(T>0) {
			String str =  scn.next();
			Stack<String> s = new Stack<>();
			Queue<Integer> q = new LinkedList<>();
			for(int i=0;i<str.length();i++) {
				int a =((int)str.charAt(i))-48;
				q.add(a);
			}
			int a=0;
			answer.append("Case #"+h+":");
			while(!q.isEmpty()) {
				 a = q.remove();
				 int b = s.size();
				if(b<a) {
				for(int j=1;j<=(a-b);j++) {
					answer.append("(");
					s.push("(");
				}
				}
				else if(b>a) {
					for(int j=1;j<=(b-a);j++) {
			           answer.append(")");
						s.pop();
					}	
				}
				answer.append(a);
			}
			for(int k=1;k<=a;k++) {
			answer.append(")");}
			answer.append("\n");
			T=T-1;
			h=h+1;
		}
		System.out.println(answer);
	}
}