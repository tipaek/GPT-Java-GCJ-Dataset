import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.next());
		System.out.println(n);
		for(int i=0;i<n;i++) {
			String s=sc.next();
			String res="";
			for(int k=s.charAt(0)-'0';k>0;k--) {
				res+="(";
			}
			res+=s.charAt(0);
			for(int j=0;j<s.length()-1;j++) {
				if(s.charAt(j)>s.charAt(j+1)) {
					for(int k=s.charAt(j)-s.charAt(j+1);k>0;k--) {
						res+=")";
					}
				}
				else if(s.charAt(j)<s.charAt(j+1)) {
					for(int k=s.charAt(j+1)-s.charAt(j);k>0;k--) {
						res+="(";
					}
				}
				res+=s.charAt(j+1);
			}
			for(int k=s.charAt(s.length()-1)-'0';k>0;k--) {
				res+=")";
			}
			System.out.println(res);
		}
		
		sc.close();
	}
}