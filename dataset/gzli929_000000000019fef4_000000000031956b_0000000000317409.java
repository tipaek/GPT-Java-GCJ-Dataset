import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tC; t++) {
			System.out.print("Case #" + t + ": ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String line = st.nextToken();
			
			
			for(int i = 1; i <= line.length(); i++) {
				String dir = line.substring(i-1,i);
				
				int xDir = 0;
				int yDir = 0;
				
				if(dir.equals("N")) {
					yDir = 1;
				}
				else if(dir.equals("S")) {
					yDir = -1;
				}
				else if(dir.equals("E")) {
					xDir = 1;
				}
				else if(dir.equals("W")) {
					xDir = -1;
				}
				
				x += xDir;
				y += yDir;
				
				if(Math.abs(x) + Math.abs(y) <= i) {
					System.out.println(i);
					break;
				}
				else if(i == line.length()) {
					System.out.println("IMPOSSIBLE");
				}
				
			}
			
		}
	}
}
