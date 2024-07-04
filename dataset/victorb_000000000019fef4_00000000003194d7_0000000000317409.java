import java.util.*;

public class Solution {
	

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();
		for(int tCurr = 1; tCurr<=tNum ; tCurr++) {
			
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int result = -1;
			String path = sc.next();
			int cnt = 0;
			if (X == 0 && Y == 0) {
				result = 0;
			} else
			for(char c : path.toCharArray()) {
				switch (c) {
					case 'E': X++; break;
					case 'W': X--; break;
					case 'N': Y++; break;
					case 'S': Y--; break;				
				}
				cnt++;
				if (Math.abs(X)+Math.abs(Y) <= cnt) {
					result = cnt;
					break;
				}
			}			
			
		
			System.out.println(String.format("Case #%d: %s" , tCurr, result == -1 ? "IMPOSSIBLE" : result));
			
		}

		System.out.flush();
	}
	

}

