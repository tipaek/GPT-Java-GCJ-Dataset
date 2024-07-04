import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br;
	static BufferedWriter bw;
	static int n;
	static int[] s;
	static int[] e;
	static StringBuffer sb;
	static char[] who;
	static boolean solved;
	
	static boolean possible(int i, char c) {
		for (int j=0; j<i; j++) {
			if (who[j] == c) {
				if (s[i] >= s[j] && s[i] < e[j])
					return false;
				if (e[i] > s[j] && e[i] <= e[j])
					return false;
			}
		}
		return true;
	}
	
	static boolean dfs(int i) {
		if (i == n) {
			return true;
		}
		boolean cameron = possible(i,'C');
		boolean jamie = possible(i,'J');
		boolean b1 = false;
		boolean b2 = false;
		if (cameron) {
			who[i] = 'C';
			b1 = dfs(i+1);
		}
		if (jamie) {
			who[i] = 'J';
			b2 = dfs(i+1);
		}
		return b1 || b2;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuffer();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			s = new int[n];
			e = new int[n];
			who = new char[n];
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				s[i] = Integer.parseInt(st.nextToken());
				e[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("Case #" + test_case + ": ");
			
			if (dfs(0)) {
				for (int j=0; j<n; j++)
					sb.append(who[j]);
				sb.append('\n');
			}
			
			else
				sb.append("IMPOSSIBLE\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}