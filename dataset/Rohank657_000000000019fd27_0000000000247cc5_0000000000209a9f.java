import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t= sc.nextInt();
		for(int i = 1;i<=t;i++) {
			String str = sc.next();
			StringBuffer sb = new StringBuffer();
			int openBrackets = 0;
			for(int j=0;j<str.length();j++) {
				int counter = str.charAt(j)-48-openBrackets;
				openBrackets+=counter;
				if(counter<0) {
					int counter2 = Math.abs(counter);
					while(counter2!=0) {
						sb.append(')');
						counter2--;
					}
				}
				else {
					while(counter!=0) {
						sb.append('(');
						counter--;
					}
				}
				sb.append(str.charAt(j));
				if(j==str.length()-1) {
					while(openBrackets!=0) {
						sb.append(')');
						openBrackets--;
					}
				}
			}
			System.out.println("Case #"+i+": "+sb.toString());
		}
		sc.close();
	}
}
