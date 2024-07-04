import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			int U = Integer.parseInt(in.readLine());
			
			int[] let = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
			char[] lets = new char[10];
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			
			for (int q = 0; q < 10*10*10*10; q++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String MT = st.nextToken();
				String str = st.nextToken();
				
				if (map.size() < 10) match(map, str, lets);
				
				//String MT = M + "";
				if (MT.length() == str.length()) {
					int c = map.get(str.charAt(0));
					let[c] = Math.min(let[c], MT.charAt(0) - '0');
				}
				
				
				
			}
			StringBuilder sb = new StringBuilder("           ");
			for (int p = 0; p < 10; p++) 
				sb.setCharAt(let[p] % 10, lets[p]);
			
			System.out.print("Case #" + (i+1) + ": " + sb);
		}
	}
	private static void match(HashMap<Character, Integer> map, String str, char[] lets) {
		for (int i = 0; i < str.length(); i++) { 
			if (!map.containsKey(str.charAt(i))) {
				lets[map.size()] = str.charAt(i);
				map.put(str.charAt(i), map.size());
			}
		}	
	}
}
