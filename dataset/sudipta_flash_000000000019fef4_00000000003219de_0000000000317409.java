import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		sc.nextLine();
		for (int i = 0; i < t; ++i) {
			
			String astr[] = sc.nextLine().split(" ");

			int x = Integer.parseInt(astr[0]);
			int y = Integer.parseInt(astr[1]);
			String direction = astr[2];

			func(i, x, y, direction);
		}
		sc.close();

	}

	private static void func(int i, int x, int y, String direction) {


		int totalTime = direction.length();
		
		int time = 1;
		boolean flag = false;

		for (int j = 0; j < totalTime; j++) {

			char ch = direction.charAt(j);
			if (ch == 'N') {
				y++;
			}
			else if (ch == 'S') {
				y--;
			}
			else if (ch == 'E') {
				x++;
			}
			else if (ch == 'W') {
				x--;
			}
			
			int req = Math.abs(x) + Math.abs(y);
			
			if(req <= time) {
				flag = true;
				break;
			}
			time++;

		}
		
		if(!flag) {
			System.out.println("Case #" + ++i + ": IMPOSSIBLE");
		}
		else {
			System.out.println("Case #" + ++i + ": " + time);
		}
		
	}

}