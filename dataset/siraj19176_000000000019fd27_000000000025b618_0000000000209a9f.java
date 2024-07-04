import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int x=0;x<t;x++) {
			String s=sc.next();
			int diff=0;
			int a=s.charAt(0)-48;
			String s1="";
			while(a>0) {
				s1+="(";
				a--;
			}
			s1=s1+s.charAt(0);
			int l=s.length();
			for(int i=1;i<l;i++) {
				a=s.charAt(i-1)-48;
				int b=s.charAt(i)-48;
				diff=a-b;
				if(diff>0) {
					diff=Math.abs(diff);
					while(diff>0) {
						s1=s1+")";
						diff--;
					}
					s1=s1+s.charAt(i);
				}
				else if(diff<0) {
					diff=Math.abs(diff);
					while(diff>0) {
						s1=s1+"(";
						diff--;
					}
					s1=s1+s.charAt(i);
				}
				else
					s1=s1+s.charAt(i);
				}
			int c=(int)s.charAt(s.length()-1)-48;
			while(c>0) {
				s1=s1+")";
				c--;
			}
			System.out.println("Case #"+(x+1)+": "+s1);
		}

	}

}
