import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			String s=scanner.next();
			String r="";
			int i=0;
			boolean open=false;
			while(i<s.length()) {
			if(s.charAt(i)=='1' && open==false) {
				r+="(1";
				open=true;
			}
			else if(s.charAt(i)=='1'&&open) {
				r+="1";
			}
			else if(s.charAt(i)=='0'&&open) {
				r+=")0";
				open=false;
			}
			else r+="0";
			
			i++;
			}
			if(r.charAt(r.length()-1)=='1')r+=")";
			System.out.println("Case #"+(t+1)+": "+r);
		}
		
	}
}
