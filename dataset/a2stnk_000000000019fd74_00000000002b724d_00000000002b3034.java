import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			pw.printf("Case #%d: ", i+1);
			solve(sc, pw);
		}
		
		sc.close();
		pw.close();
	}

	static void solve(Scanner sc, PrintWriter pw) {
		int N = sc.nextInt();
		String[] s = new String[N];
		
		for(int i=0; i<N; i++) {
			s[i] = sc.next();
		}
		
		String ans = "*";
		for(int i=0; i<N; i++) {
			int L = s[i].length();
			int pf = ans.indexOf('*');
			int qf = s[i].indexOf('*');

			int commonLength = Math.min(pf, qf);
			if(! ans.substring(0, commonLength).equals(s[i].substring(0, commonLength))) {
				pw.println("*");
				return;
			}
			if(pf < qf) {
				ans = s[i].substring(0, qf) + ans.substring(pf);
			}
			
			int pl = ans.lastIndexOf('*');
			int ql = s[i].lastIndexOf('*');
			
			int commonLength2 = Math.min(ans.length()-pl-1, s[i].length()-ql-1);
			if(! ans.substring(ans.length()-commonLength2).equals(s[i].substring(s[i].length()-commonLength2))) {
				pw.println("*");
				return;
			}
			if(ans.length()-pl-1 < s[i].length()-ql-1) {
				ans = ans.substring(0, pl) + s[i].substring(ql);
			}

			String insert = s[i].substring(qf, ql+1);
			int insertPosition = ans.indexOf('*');
			ans = ans.substring(0, insertPosition) + insert + ans.substring(insertPosition+1);
		}
		
		ans = ans.replaceAll("\\*", "");
		
		pw.println(ans);
		return;
	}
}
