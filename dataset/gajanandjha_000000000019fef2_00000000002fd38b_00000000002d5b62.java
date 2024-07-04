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
			String[] str = br.readLine().trim().split("\\s+");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int z = (Math.abs(x) + Math.abs(y));
			if(z%2 == 1) {
				int hi = Integer.highestOneBit(z-1);
				while(!(x == 0 && y == 0)) {
					if(Math.abs(x) > Math.abs(y)) {
						if(x > 0) {
							sb.append("E");
							x -= hi;
						} else {
							sb.append("W");
							x += hi;
						}
					} else {
						if(y > 0) {
							sb.append("N");
							y -= hi;
						} else {
							sb.append("S");
							y += hi;
						}
					}
					hi /= 2;
				}
				System.out.println("Case #" + t + ": " + sb.reverse().toString());
			} else {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}
		}
	}

}
