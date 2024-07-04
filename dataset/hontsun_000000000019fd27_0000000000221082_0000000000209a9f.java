
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static String S;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for(int test=1;test<=tests;test++) {
			S = in.next();
			char[] ch = S.toCharArray();
			int num = ch[0]-'0';
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<num;i++) {
				sb.append("(");
			}
			sb.append(ch[0]);
			for(int i=0;i+1<ch.length;i++) {
				int nab = ch[i+1]-ch[i];
				num += nab;
				String s;
				if(nab>0) {
					s = "(";
				}else {
					s = ")";
				}
				for(int j=0;j<Math.abs(nab);j++) {
					sb.append(s);
				}
				sb.append(ch[i+1]);
			}
			for(int i=0;i<num;i++) {
				sb.append(")");
			}
			
			System.out.printf("Case #%d: %s\n",test,sb.toString());
		}
	}
	
}
