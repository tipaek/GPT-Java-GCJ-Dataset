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
			if (N <= 500) {
				for (int i = 1; i <= N; i++) pw.println(""+i+" 1");
			} else {
				pw.println("1 1");
				pw.println("2 1");
				pw.println("3 2");
				for (int i = 3; i < 500; i++) pw.println(""+i+" 1");
			}
			pw.flush();
		}
	}
}
