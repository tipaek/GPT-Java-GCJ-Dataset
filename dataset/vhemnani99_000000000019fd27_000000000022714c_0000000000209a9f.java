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

		for(int te=1 ; te<=t ; te++) {
			String input[] = br.readLine().split("");
			StringBuffer st = new StringBuffer();

			int d = 0;

			for(int i=0 ; i<input.length ; i++) {
				int n= Integer.parseInt(input[i]);

				if(n>d) {
					int dif = n-d;
					for(int j=0 ; j<dif ; j++) {
						st.append("(");
					}
					st.append(n);
					d = n;
				}
				else if(n<d) {
					int dif = d-n;
					for(int j=0 ; j<dif ; j++) {
						st.append(")");
					}
					st.append(n);
					d = n;
				}
				else {
					st.append(n);
				}
			}
			if(d!=0) {
				for(int j=0 ; j<d ; j++) {
					st.append(")");
				}
			}
			bw.write("Case #"+te+": "+st.toString()+"\n");
		}

		bw.flush();
	}
}