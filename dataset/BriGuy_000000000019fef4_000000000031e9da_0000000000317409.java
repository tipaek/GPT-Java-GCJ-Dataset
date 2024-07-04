import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			String tour = st.nextToken();
			
			boolean poss = false;
			
			for(int i = 0; i < tour.length(); i++) {
				if(tour.charAt(i) == 'N') {
					Y++;
				} else if(tour.charAt(i) == 'S') {
					Y--;
				} else if(tour.charAt(i) == 'E') {
					X++;
				} else if(tour.charAt(i) == 'W') {
					X--;
				}
				
				if(Math.abs(X) + Math.abs(Y) <= i+1) {
					System.out.println("Case #" + t + ": " + (i+1));
					poss = true;
					break;
				}
			}
			
			if(!poss) System.out.println("Case #" + t + ": IMPOSSIBLE");
		}
	}
}
