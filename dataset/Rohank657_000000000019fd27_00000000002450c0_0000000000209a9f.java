import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t= sc.nextInt();
		for(int i = 1;i<=t;i++) {
			String str = sc.next();
			StringBuffer sb = new StringBuffer();
			for(int j=0;j<str.length();) {
				if(str.charAt(j) == '0') {
					sb.append('0');
					j++;
				}
				else {
					sb.append('(');
					sb.append('1');
					j++;
					while(j<str.length() && str.charAt(j)=='1') {
						sb.append('1');
						j++;
					}
					sb.append(')');
				}
			}
			System.out.println("Case #"+i+": "+sb.toString());
		}
		sc.close();
	}

}
