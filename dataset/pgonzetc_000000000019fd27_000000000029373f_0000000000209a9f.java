import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{
	public static void main(String args[]){
		Scanner stdin = new Scanner(System.in);
		int t, i, n, row, k;
		String s;
		int num;
		int cur;
		StringBuilder answer;
		t = stdin.nextInt();
		for(i=0;i<t;i++){
			answer = new StringBuilder();
			s = stdin.next();
			cur=0;
			for(n=0;n<s.length();n++){
				num = s.charAt(n) - '0';
				if(num > cur){
					
					for(k=0;k<num-cur;k++)
						answer.append('(');
				}
				else if(num < cur){
					for(k=0;k<cur-num;k++)
						answer.append(')');
				}
				cur = num;
				answer.append(s.charAt(n));
			}
			for(k=0;k<cur;k++)
				answer.append(')');

			System.out.printf("Case #%d: %s", i+1  ,answer.toString());
			System.out.println();
		}
	}
}