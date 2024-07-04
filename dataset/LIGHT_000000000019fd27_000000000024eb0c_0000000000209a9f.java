import java.util.*;
public class Solution {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int tt;
		
		for(tt=1;tt<=t;++tt) {
			String s = scan.next();
			StringBuffer sb = new StringBuffer();
			int length = s.length();
			int i,countOpen=0,digit,k;
			for(i=0;i<length;++i) {
				digit=s.charAt(i)-'0';
				if(digit<countOpen) {
					for(k=digit;k<countOpen;++k) {
						sb.append(")");
						--countOpen;
					}
				}
				else {
					for(k=countOpen;k<digit;++k) {
						sb.append("(");
						++countOpen;
					}
				}
				sb.append(s.charAt(i));
			}
			for(k=countOpen;k>0;--k)  sb.append(")");
			System.out.println("Case #"+tt+": "+sb.toString());
		}
		
	}
}
