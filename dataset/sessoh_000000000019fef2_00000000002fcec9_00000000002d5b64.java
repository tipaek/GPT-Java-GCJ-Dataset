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
			
			String[] str = br.readLine().split(" ");
			int R = Integer.parseInt(str[0]);
			int S = Integer.parseInt(str[1]);
			int[] cards = new int[R*S];
			for (int i = 0; i < R*S; i++) cards[i] = i%R;
			int[] opsA = new int[R*S];
			int[] opsB = new int[R*S];
			int c = 0;
			for (int i = R*S-1; i >= 0; i--) {
				if (cards[i] == i/S) continue;
				int p = i-1;
				while (cards[p] != i/S) p--;
				opsA[c] = p+1;
				opsB[c] = i-p;
				c++;
				int[] buf = new int[i-p];
				for (int j = 0; j < i-p; j++) buf[j] = cards[p+1+j];
				for (int j = 0; j <= p; j++) cards[i-j] = cards[p-j];
				for (int j = 0; j < i-p; j++) cards[j] = buf[j];
			}
			pw.println("Case #" + t + ": "+c);
			for (int i = 0; i < c; i++) pw.println(""+opsA[i]+" "+opsB[i]);
			pw.flush();
		}
	}
}
