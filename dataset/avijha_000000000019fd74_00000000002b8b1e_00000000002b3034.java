import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test_cases = in.nextInt();
		for(int test=1; test<=test_cases; test++) {
			int n = in.nextInt();
			String start = "";
			String end = "";
			String mid = "";
			for(int string_num=0; string_num<n; string_num++) {
				String s = in.next();
//				System.out.println(s);
				int len = s.length();
				int i = 0;
				while(s.charAt(i)!='*') {
					if(start.length()>i) {
						if(start.charAt(i)!=s.charAt(i)) {
							mid = "*";
							break;
						}
					}
					else
						start+=s.charAt(i);
					i++;
				}
				if(mid.equals("*"))
					break;
				int j = 0;
				while(s.charAt(len-1-j)!='*') {
					if(end.length()>j) {
						if(end.charAt(j)!=s.charAt(len-1-j)) {
							mid = "*";
							break;
						}
					}
					else
						end+=s.charAt(len-1-j);
					j++;
				}
				if(mid.equals("*"))
					break;
				j = len-1-j;
				while(i!=j) {
					if(s.charAt(i)!='*')
						mid+=s.charAt(i);
					i++;
				}
			}
			String ans = "";
			if(mid.equals("*"))
				ans = "*";
			else 
				ans=start+mid+new StringBuffer(end).reverse().toString();
			System.out.println("Case #"+test+": "+ans);
				
		}
		
		in.close();
	}

}
