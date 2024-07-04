import java.io.*;

public class Solution {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();
			String ans = "";
//			StringBuilder sb = new StringBuilder(ans);
			
			int init = str.charAt(0) - '0';
			for(int i=0; i<init; i++) {
				ans+='(';
//				sb.append('(');
			}
//			sb.append(init);
			ans+=str.charAt(0);
			
			for(int i=1; i<str.length(); i++) {
				int a = str.charAt(i-1) - '0';
				int b = str.charAt(i) - '0';
								
				if(a > b) {
					for(int j=0; j<a-b; j++) {
//						sb.append(')');
						ans+=')';
					}
//					sb.append(b);
					ans+=str.charAt(i);
				}
				else if(a < b) {
					for(int j=0; j<b-a; j++) {
//						sb.append('(');
						ans+='(';
					}
//					sb.append(b);
					ans+=str.charAt(i);
				}
				else {
//					sb.append(b);
					ans+=str.charAt(i);
				}
			}
			
			int end = str.charAt(str.length()-1) - '0';
			for(int i=0; i<end; i++) {
//				sb.append(')');
				ans+=')';
			}
			
//			System.out.println("Case #"+t+": "+sb.toString());
			System.out.println("Case #"+t+": "+ans);
			
		}

	}

}
