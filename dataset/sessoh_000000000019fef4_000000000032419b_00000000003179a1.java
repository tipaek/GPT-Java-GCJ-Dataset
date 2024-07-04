import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			int U = Integer.parseInt(br.readLine());
			int[] top = new int[26];
			int[] all = new int[26];
			for (int i = 0; i < 10000; i++) {
				String[] str = br.readLine().split(" ");
				String s = str[1];
				top[s.charAt(0)-'A']++;
				for (int j = 0; j < s.length(); j++) {
					all[s.charAt(j)-'A']++;
				}
			}
			int[] rank = new int[26];
			for (int i = 0; i < 26; i++) {
				if (all[i] > 0) { rank[i] = ((top[i]+1)<<8) | i; }
				else rank[i] = i;
			}
			Arrays.sort(rank);
			String answer = "" + (char)('A'+(rank[16]&0xff));
			for (int i = 25; i > 16; i--) answer += (char)('A'+(rank[i]&0xff));
			pw.println("Case #" + t + ": " + answer);
			pw.flush();
		}
	}
}
