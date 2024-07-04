import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			StringBuffer sb = new StringBuffer();
			char[] chr = br.readLine().trim().toCharArray();
			int[] intr = new int[chr.length];
			for(int k = 0; k < (chr[0] - '0'); k++) {
				sb.append("(");
			}
			sb.append(chr[0] - '0');
			for(int i = 0; i < chr.length-1; i++) {
				intr[i] = chr[i] - '0';
				intr[i+1] = chr[i+1] - '0';
				int diff = intr[i] - intr[i+1];
				if(diff > 0) {
					for(int l = 0; l < diff; l++) {
						sb.append(")");
					}
				} else if(diff < 0) {
					for(int l = 0; l < Math.abs(diff); l++) {
						sb.append("(");
					}
				}
				sb.append(intr[i+1]);
			}
			for(int k = 0; k < (chr[chr.length-1] - '0'); k++) {
				sb.append(")");
			}
			System.out.println("Case #" + t + ": " + sb.toString());
		}
	}
}
