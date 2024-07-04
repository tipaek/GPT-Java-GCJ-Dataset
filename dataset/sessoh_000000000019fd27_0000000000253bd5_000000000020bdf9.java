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
		loop: for (int t = 1; t <= T; ++t) {
			pw.print("Case #" + t + ": ");
			int N = Integer.parseInt(br.readLine());
			int[] table = new int[N*2];
			for (int n = 0; n < N; n++) {
				String[] str = br.readLine().split(" ");
				table[n*2] = (Integer.parseInt(str[0]) << 11) | (1 << 10)| n;
				table[n*2+1] = (Integer.parseInt(str[1]) << 11) | n;
			}
			Arrays.sort(table);
			
			int busy = 0;
			int[] charge = new int[N];
			for (int ta : table) {
//				int time = ta >> 11;
				int se = (ta >> 10) & 1;
				int menu = (ta & 1023);
				if (se == 0) {
					busy ^= (1 << charge[menu]);
				} else {
					if (busy == 3) { pw.println("IMPOSSIBLE"); pw.flush(); continue loop; }
					int ch = 0;
					while ((busy & (1 << ch)) > 0) ch++;
					charge[menu] = ch;
					busy |= (1 << charge[menu]);
				}
			}
			for (int c : charge) pw.print((c == 0) ? 'C' : 'J');
			pw.println();
			pw.flush();
		}
	}
}
