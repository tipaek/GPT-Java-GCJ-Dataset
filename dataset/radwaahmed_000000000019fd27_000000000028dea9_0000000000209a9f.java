import java.util.Scanner;

public class Solution {
	public static String NestingDepth(String s ) {
		StringBuilder st = new StringBuilder();
		for(int i =0 ;i< s.length();i++) {
			if(s.charAt(i) != '0') {
				st.append('(').append(s.charAt(i));
				while (++i < s.length()-1 && s.charAt(i)=='1') {
					st.append(s.charAt(i));
					//i++;
				}
				i--;
				
				st.append(')');
			}else {
				st.append(s.charAt(i));
			}
		}
		return st.toString();
	}
	public static void main(String[] args) {
		Scanner input=new Scanner (System .in);
		int Cases = input.nextInt();
		String[] cases = new String[Cases];
		for(int k =0;k<Cases;k++) {
			String s = input.next();
			cases[k]= NestingDepth(s);
		}
		for(int k =0;k<Cases;k++) {
			System.out.println("Case #"+(k+1)+": "+cases[k]);
		}
	}


}
