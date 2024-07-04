import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			pw.println("Case #" + t + ":");
			
			int N = Integer.parseInt(br.readLine());
			pw.println("1 1");
			if (N > 1) {
				if (N > 500) {
					pw.println("2 2");
					N = 500;
				}
				for (int i = 2; i <= N; i++) pw.println(""+i+" 1");
			}
			pw.flush();
		}
	}
}
