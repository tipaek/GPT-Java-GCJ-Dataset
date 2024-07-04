import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			int[] answer = new int[B];
			int count = 0;
			int pos = 0;
			int same = -1;
			int diff = -1;
			while (pos < B) {
				if ((count%10) == 0) {
					if (same >= 0) {
						pw.println(same+1);
						pw.flush();
						if (answer[same] != Integer.parseInt(br.readLine())) {
							for (int i = 0; i < B; i++) if (answer[i] == 0) answer[i] = 1; else answer[i] = 0;
						}
						count++;
					}
					if (diff >= 0) {
						pw.println(diff+1);
						pw.flush();
						if (answer[diff] != Integer.parseInt(br.readLine())) {
							for (int i = 0; i < B/2; i++) {
								int a = answer[i];
								answer[i] = answer[B-i-1];
								answer[B-i-1] = a;
							}
						}
						count++;
					}
				}
				if ((pos%2) == 0) {
					pw.println((pos/2)+1);
					pw.flush();
					answer[pos/2] = Integer.parseInt(br.readLine());
					count++;
					pos++;
				} else {
					pw.println(B-(pos/2));
					pw.flush();
					answer[B-(pos/2)-1] = Integer.parseInt(br.readLine());
					count++;
					if (same < 0) {
						if (answer[pos/2] == answer[B-(pos/2)-1]) same = pos/2;
					}
					if (diff < 0) {
						if (answer[pos/2] != answer[B-(pos/2)-1]) diff = pos/2;
					}
					pos++;
				}
			}
			
			for (int i = 0; i < B; i++) pw.print(answer[i]);
			pw.println();
			pw.flush();
			if (!"Y".equals(br.readLine())) break;
		}
	}
}
