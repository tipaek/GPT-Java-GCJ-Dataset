import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		loop: for (int t = 1; t <= T; ++t) {
			pw.print("Case #" + t + ": ");

			int N = Integer.parseInt(br.readLine());
			String[] str = new String[N];
			for (int n = 0; n < N; n++) str[n] = br.readLine();

			char[] top = new char[1000];
			char[] bottom = new char[1000];
			char[] middle = new char[10000];
			int topcount = 0;
			int bottomcount = 0;
			int middlecount = 0;
			for (int n = 0; n < N; n++) {
				char[] now = str[n].toCharArray();
				int s = 0;
				while (now[s] != '*') {
					if (topcount > s) {
						if (top[s] != now[s]) {
							pw.println("*");
							pw.flush();
							continue loop;
						}
					} else {
						top[topcount++] = now[s];
					}
					s++;
				}
				int b = 0;
				while (now[now.length-1-b] != '*') {
					if (bottomcount > b) {
						if (bottom[b] != now[now.length-1-b]) {
							pw.println("*");
							pw.flush();
							continue loop;
						}
					} else {
						bottom[bottomcount++] = now[now.length-1-b];
					}
					b++;
				}
				b = now.length-1-b;
				while (s < b) {
					if (now[s] != '*') middle[middlecount++] = now[s];
					s++;
				}
			}
			for (int i = 0; i < topcount; i++) pw.print(top[i]);
			for (int i = 0; i < middlecount; i++) pw.print(middle[i]);
			for (int i = bottomcount-1; i >= 0; i--) pw.print(bottom[i]);

			pw.println();
			pw.flush();
		}
	}
}
