import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
	

	public static void main(String[] args) {
		
		try {
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.parseInt(bf.readLine());
			
			for (int i=0; i<T; i++) {
				
				String[] temp = bf.readLine().split(" ");
				
				int X = Integer.parseInt(temp[0]);
				int Y = Integer.parseInt(temp[1]);
				String direction = temp[2];
				
				int time = 0;
				for (; time<direction.length(); time++) {
					
					char c = direction.charAt(time);
					int mult = 1;
					if (c == 'W' || c =='S') mult = -1;
					
					if (c == 'E' || c == 'W') {
						X = X + mult;
					} else {
						Y = Y + mult;
					}
					
					if ((time+1) >= ( Math.abs(X)+Math.abs(Y) ) ) {
						break;
					}
				}

				System.out.println("Case #" + (i+1) + ": " + (time >= direction.length() ? "IMPOSSIBLE" : (time + 1)));
			}

		} catch (Exception e) {
			
		}
	
	}

}
