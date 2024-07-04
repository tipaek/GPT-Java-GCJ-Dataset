import java.util.*;
import java.io.*;

public class naming_compromise {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		for(int ti = 1; ti <= t; ti++) {
			System.out.print("Case #" + ti + ": ");

			String cs = in.next(), js = in.next();
			int cl = cs.length(), jl = js.length();

			int[][] dp = new int[cl + 1][jl + 1];
			int[][][] p = new int[cl + 1][jl + 1][2];
			for(int i = 0; i <= cl; i++) {
				dp[i][0] = i;
				p[i][0][0] = -1;
				p[i][0][1] = 0;
			}
			for(int j = 0; j <= jl; j++) {
				dp[0][j] = j;
				p[0][j][0] = 0;
				p[0][j][1] = -1;
			}
			for(int i = 1; i <= cl; i++)
				for(int j = 1; j <= jl; j++) {
					int del = dp[i - 1][j] + 1;
					int ins = dp[i][j - 1] + 1;
					int sub = dp[i - 1][j - 1];
					if(cs.charAt(i - 1) != js.charAt(j - 1))
						sub += 1;

					if(del <= ins && del <= sub) {
						dp[i][j] = del;
						p[i][j][0] = -1;
						p[i][j][1] = 0;
					}
					else if(ins <= del && ins <= sub) {
						dp[i][j] = ins;
						p[i][j][0] = 0;
						p[i][j][1] = -1;
					}
					else if(sub <= ins && sub <= del) {
						dp[i][j] = sub;
						p[i][j][0] = -1;
						p[i][j][1] = -1;
					}
				}
			
			int ii = cl, jj = jl;
			String bc = "", bj = "";
			while(ii != 0 && jj != 0) {
				int x = p[ii][jj][0], y = p[ii][jj][1];
				if(x == -1)
					bc += cs.charAt(--ii);
				else
					bc += "*";
				if(y == -1)
					bj += js.charAt(--jj);
				else
					bj += "*";
			}
			while(ii != 0) {
				bc += cs.charAt(--ii);
				bj += "*";
			}
			while(jj != 0) {
				bj += js.charAt(--jj);
				bc += "*";
			}

			int cc = 0;
			String fs = "";
			for(int i = 0; i < bc.length(); i++) {
				if(bc.charAt(i) == bj.charAt(i) ||
					cc++ < dp[cl][jl] / 2) {
					if(bc.charAt(i) != '*')
						fs += bc.charAt(i);
				}
				else if(bj.charAt(i) != '*')
					fs += bj.charAt(i);
			}

			int fl = fs.length();
			for(int i = 0; i < fl; i++)
				System.out.print(fs.charAt(fl - 1 - i));
			System.out.println();
		}
	}
}