import java.util.Scanner;

public class Solution {
	
	private static void solve(int nr, Scanner sc) {
		int X = sc.nextInt();
		int Y = sc.nextInt();
		String M = sc.next();
		
		int bestTime = Integer.MAX_VALUE;
		
		int time = 0;
		while(true) {
			int walkTime = Math.abs(X)+Math.abs(Y);
			if (walkTime <= time)
				bestTime = Math.min(bestTime,time);

			// System.out.println(time +" " + walkTime+" "+X+" "+Y);

			
			if (time >= M.length())
				break;

			char c = M.charAt(time++);
			if (c == 'N')
				Y += 1;
			else if (c == 'S')
				Y -= 1;
			else if (c == 'E')
				X -= 1;
			else if (c == 'W')
				X += 1;
			else
				throw new RuntimeException("Not NSEW");
		}
		
		if (bestTime <= M.length()) {
			System.out.println("Case #"+nr+": "+bestTime);
		} else {
			System.out.println("Case #"+nr+": IMPOSSIBLE");
		}  
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			solve(i+1,sc);
		}
	}
}
