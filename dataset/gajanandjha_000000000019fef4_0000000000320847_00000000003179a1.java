import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
			br.readLine();
			List<String> ll = new ArrayList<String>();
			Set<Character> hs = new HashSet<Character>();
			for(int i = 0; i < 10000; i++) {
				String[] spl = br.readLine().split("\\s+");
				if(spl[0].length() == 1) {
					ll.add(spl[0] + "," + spl[1]);
				}
				char[] chr = spl[1].toCharArray();
				for(char ch : chr) {
					hs.add(ch);
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append(" ");
			for(int i = 1; i < 10; i++) {
				for(String str : ll) {
					String[] spl = str.split(",");
					if(spl[0].equals("" + i + "") && !sb.toString().contains(spl[1])) {
						sb.append(spl[1]);
					}
				}
			}
			for(char ch : hs) {
				if(!sb.toString().contains(ch + "")) {
					sb = sb.replace(0, 1, ch + "");
					break;
				}
			}
			System.out.println("Case #" + t + ": " + sb.toString());
		}
	}

}
