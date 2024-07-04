import java.io.*;
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine()); 
		for(int i = 0; i < cases; i++) {
			String s = br.readLine();
			
			StringBuilder sb = new StringBuilder();
			
			int depth = s.charAt(0) - 48;
			int d1 = depth;
			int d2 = depth;
			addR(d1, sb);
			sb.append(s.charAt(0));
			
			for(int a = 1; a < s.length(); a++) {
				int tmp = s.charAt(a) - 48;
				if(depth == tmp) {
					sb.append(s.charAt(a));
				}else if(depth > tmp) {
					d2 = depth - tmp;
					addL(d2, sb);
					depth = tmp;
					sb.append(s.charAt(a));
				}else {
					d1 = tmp - depth;
					addR(d1, sb);
					depth = tmp;
					sb.append(s.charAt(a));
				}
			}
			addL(depth, sb);
		}
	}
	
	public static void addR(int d, StringBuilder s) {
		while(d != 0) {
			s.append('(');
			d--;
		}
	}

	public static void addL(int d, StringBuilder s) {
		while(d != 0) {
			s.append(')');
			d--;
		}
	}
}
