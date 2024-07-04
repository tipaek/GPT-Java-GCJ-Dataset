import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			String line = br.readLine();
			StringBuilder ans = new StringBuilder();
			
			int num = 0;
			
			for(int i = 0; i<line.length(); i++) {
				int digit  = line.charAt(i) - '0';
				if(num < digit) {
					for(int j = 0; j<digit-num; j++) {
						ans.append("(");
					}
				}
				else if(num > digit) {
					for(int j = 0; j< num-digit; j++) {
						ans.append(")");
					}
				}
				num = digit;
				ans.append(Integer.toString(digit));
			}
			for(int i = 0; i<num; i++) {
				ans.append(")");
			}
			
			bw.write("Case #" + t + ": " + ans.toString() + "\n");
			
		}
		
		
		bw.flush();
		br.close();
		bw.close();
	}
}


