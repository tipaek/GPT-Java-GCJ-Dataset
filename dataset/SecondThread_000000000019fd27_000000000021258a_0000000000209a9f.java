import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner fs=new Scanner(System.in);
		int T=fs.nextInt();
		for (int tt=1; tt<=T; tt++) {
			char[] board=fs.next().toCharArray();
			StringBuilder sb=new StringBuilder();
			int last=0;
			for (char c:board) {
				while (last<c-'0') {
					last++;
					sb.append('(');
				}
				while (last>c-'0') {
					last--;
					sb.append(')');
				}
				sb.append(c);
			}
			while (last>0) {
				last--;
				sb.append(')');
			}
			System.out.println("Case #"+tt+": "+sb.toString());
		}
		
	}

}
