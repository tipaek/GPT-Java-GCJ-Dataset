package CodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class CJ20_NestingDepth {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			String[] input = br.readLine().split("");
			StringBuilder sb = new StringBuilder();

			int depth = 0;

			for(int i=0 ; i<input.length ; i++) {
				int now = Integer.parseInt(input[i]);

				if(now>depth) {
					int dif = now-depth;
					for(int j=0 ; j<dif ; j++) {
						sb.append("(");
					}
					sb.append(now);
					depth = now;
				}
				else if(now<depth) {
					int dif = depth-now;
					for(int j=0 ; j<dif ; j++) {
						sb.append(")");
					}
					sb.append(now);
					depth = now;
				}
				else {
					sb.append(now);
				}
			}
			if(depth!=0) {
				for(int j=0 ; j<depth ; j++) {
					sb.append(")");
				}
			}
			bw.write("Case #"+tt+": "+sb.toString()+"\n");
		}

		bw.flush();
	}
}
