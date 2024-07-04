import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}

	static void solve(Scanner sc) {
		int X = sc.nextInt();
		int Y = sc.nextInt();
		char[] M = sc.next().toCharArray();

		for(int i=0; i<M.length; i++) {
			switch(M[i]) {
			case 'N':
				Y++;
				break;
			case 'S':
				Y--;
				break;
			case 'E':
				X++;
				break;
			case 'W':
				X--;
				break;
			}
			if(Math.abs(X)+Math.abs(Y) <= i+1) {
				System.out.println(i+1);
				return;
			}
			
		}
		System.out.println("IMPOSSIBLE");
	}
}