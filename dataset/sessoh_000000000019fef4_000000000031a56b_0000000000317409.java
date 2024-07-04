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

			String[] str = br.readLine().split(" ");
			int X = Integer.parseInt(str[0]);
			int Y = Integer.parseInt(str[1]);
			String M = str[2];
			
			if (X == 0 && Y == 0) { pw.println('0'); pw.flush(); continue; }
			for (int i = 0; i < M.length(); i++) {
				switch (M.charAt(i)) {
				case 'N': Y++; break;
				case 'S': Y--; break;
				case 'E': X++; break;
				case 'W': X--; break;
				}
				if (Math.abs(X)+Math.abs(Y) <= (i+1)) { pw.println(i+1); pw.flush(); continue loop; }
			}
			pw.println("IMPOSSIBLE"); pw.flush();
		}
	}
}
