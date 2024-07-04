import java.io.*;

public class Solution {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String str = br.readLine();
			String ans = "";
			StringBuilder sb = new StringBuilder(ans);
			
			int init = str.charAt(0) - '0';
			for(int i=0; i<init; i++) {
				sb.append('(');
			}
			sb.append(init);
			
			for(int i=1; i<str.length(); i++) {
				int a = str.charAt(i-1) - '0';
				int b = str.charAt(i) - '0';
								
				if(a > b) {
					for(int j=0; j<a-b; j++) {
						sb.append(')');
					}
					sb.append(b);
				}
				else if(a < b) {
					for(int j=0; j<b-a; j++) {
						sb.append('(');
					}
					sb.append(b);
				}
				else {
					sb.append(b);
				}
			}
			for(int i=0; i<end; i++) {
				sb.append(')');
			}
			
			System.out.println("Case #"+t+": "+sb.toString());
			
		}

	}

}
