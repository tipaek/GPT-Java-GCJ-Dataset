import java.util.Scanner;

class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int smp=sc.nextInt();
		for(int h=0; h<smp; h++) {
			String s=sc.next();
			StringBuilder sb=new StringBuilder();
			int par=0;
			for(int i=0; i<s.length(); i++) {
				int t=s.charAt(i)-'0';
				if(par>t) {
					while(par!=t) {
						sb.append(")");
						par--;
					}
				}
				else if(par<t) {
					while(par!=t) {
						sb.append("(");
						par++;
					}
				}
				sb.append(t);
			}
			for(; par>0; par--) {
				sb.append(")");
			}
			System.out.println("Case #"+(h+1)+": "+sb.toString());
		}
	}
}