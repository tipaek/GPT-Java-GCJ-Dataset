import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String s;
		StringBuffer sb;
		int past;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			s = br.readLine();
			sb = new StringBuffer();
			past = 0;
			
			for (int i=0; i<s.length(); i++) {
				int d = s.charAt(i) - '0';
				int count = d - past;
				if (count >= 0) {
					for (int j=0; j<count; j++)
						sb.append('(');
				}
				else {
					for (int j=0; j<-count; j++)
						sb.append(')');
				}
				sb.append(d);
				past = d;
				
				if (i == s.length() - 1) {
					for (int j=0; j<d; j++)
						sb.append(')');
				}
			}
			
			
			
			bw.write("Case #" + test_case + ": " + sb + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}