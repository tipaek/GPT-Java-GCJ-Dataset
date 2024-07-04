import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int tt=1 ; tt<=t ; tt++) {
			String[] input = br.readLine().split("");
			StringBuilder sb = new StringBuilder();

			int d = 0;

			for(int i=0 ; i<input.length ; i++) {
				int now = Integer.parseInt(input[i]);

				if(now>depth) {
					int dif = now-d;
					for(int j=0 ; j<dif ; j++) {
						sb.append("(");
					}
					sb.append(now);
					d = now;
				}
				else if(now<d) {
					int dif = d-now;
					for(int j=0 ; j<dif ; j++) {
						sb.append(")");
					}
					sb.append(now);
					d = now;
				}
				else {
					sb.append(now);
				}
			}
			if(d!=0) {
				for(int j=0 ; j<d ; j++) {
					sb.append(")");
				}
			}
			bw.write("Case #"+tt+": "+sb.toString()+"\n");
		}

		bw.flush();
	}
}