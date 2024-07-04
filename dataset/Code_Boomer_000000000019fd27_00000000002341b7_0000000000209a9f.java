import java.util.Scanner;

public class Solution {

	public static String addP(String s) {
		String r = "";
		String s1 = ""; 
		for(int i=0;i<s.length();i++) {
			int value = Integer.parseInt(s.charAt(i)+"");
			s1  += value;
			for(int j=i+1;j<s.length() && value!=0;j++) {
				if((s.charAt(j)+"").equals(""+value)) {
					s1+=s.charAt(j);
					i++;
				}
				else {
					break;
				}
			}
			for(int j=0;j<value;j++) {
				r +="(";
			}
			r += s1;
			for(int j=0;j<value;j++) {
				r +=")";
			}
			s1 = "";
		}
		return r;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			String s = sc.next();
			s = addP(s);
			System.out.println("Case #"+(i+1)+": "+s);
		}
	}
}
