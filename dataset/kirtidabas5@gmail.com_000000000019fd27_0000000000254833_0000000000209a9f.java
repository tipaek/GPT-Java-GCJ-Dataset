
import java.util.*;

 class Solution {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		scn.nextLine();
		int Case=0;
		while(t-->0) {
			String str=scn.nextLine();
			int total=0;
			int idx=0;
			StringBuilder sb=new StringBuilder("");
			for(int i=0;i<str.length();i++) {
				int dig=str.charAt(i)-'0';
				while(total<dig) {
					sb.insert(idx, "()");
					total++;
					idx++;
				}
				if(total>dig) {
					for(int j=total;j>=0 && total>dig;j--) {
						idx++;
						total--;
					}
				}
//				System.out.println(sb+" "+idx+" "+dig);
				
				sb.insert(idx,dig);
				idx++;
			}
			Case++; 
			System.out.println("Case #"+Case+": "+sb);
			}
	}

}
