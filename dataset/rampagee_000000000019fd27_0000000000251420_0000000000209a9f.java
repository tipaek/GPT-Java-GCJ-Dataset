import java.util.*;
public class Solution {
public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);
	int t= sc.nextInt();
	for(int i=1;i<=t;i++) {
		String s=sc.next();
		System.out.println();
		String ans ="";
		
		for(int j=0;j<s.charAt(0)-'0';j++) {
			ans=ans+"(";
		}
		ans=ans+s.charAt(0);
		for(int j=1;j<s.length();j++) {
			if(s.charAt(j)>s.charAt(j-1)) {
				int v=s.charAt(j)-s.charAt(j-1);
				for(int k=0;k<v;k++) {
					ans=ans+"(";
				}
				ans=ans+s.charAt(j);
			}
			else if(s.charAt(j)<s.charAt(j-1)) {
				int g=s.charAt(j-1)-s.charAt(j);
				for(int k=0;k<g;k++) {
					ans=ans+")";
				}
				ans=ans+s.charAt(j);
			}
			else {
				ans=ans+s.charAt(j);
			}
		}
		int l=s.length()-1;
		for(int j=0;j<s.charAt(l)-'0';j++) {
			ans=ans+")";
		}
		System.out.println("Case "+"#"+i+": "+ans);
	}
}
}
