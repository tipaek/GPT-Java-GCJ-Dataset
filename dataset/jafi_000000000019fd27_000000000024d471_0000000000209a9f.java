import java.util.*;

public class Solution {

	public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		int T= scan.nextInt();
		for(int n=1; n<=T; n++) {
		String S = scan.next();
		
		String string="";
		char[] a = S.toCharArray();
		int p=0;
		
		for(int i=0; i<S.length();i++) {
			int diff=0;
		if(a[i]-48 == p) {
			string+=S.charAt(i);
		}
		else if(a[i]-48>p) {
			diff = a[i]-48-p;
			for(int k=0; k<diff; k++) {
				string = string+'(';
			}
			string+=S.charAt(i);
			p+=diff;
		}
		else {
			diff = p-(a[i]-48);
			for(int k=0; k<diff;k++) {
				string = string+")";
			}
			string+=S.charAt(i);
			p-=diff;
		}
			
			
		}
		if(p>0) {
			for(int k=0;k<p;k++) {
			string+=')';
			}
		}
		System.out.print("Case #"+n+": ");
		System.out.println(string);
		
		}
		
		
	}

}
