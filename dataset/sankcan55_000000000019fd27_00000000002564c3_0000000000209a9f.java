import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner in=new Scanner (System.in);
		int t=in.nextInt();
		int test=0;
		while(--t>=0) {
			String s=in.next();
			String result="";
			int n=s.length();
			int count=0;
			for(int i=0;i<n;i++) {
				char ch=s.charAt(i);
				while(count<Character.getNumericValue(ch)) {
					result=result+'(';
					count++;
				}
				while(count>Character.getNumericValue(ch)) {
					result=result+')';
					count--;
				}
				result=result+ch;
			}
			while(count>0) {
				result=result+')';
				count--;
			}
			System.out.println("Case #"+(++test)+": "+result);
		}
	}
}
