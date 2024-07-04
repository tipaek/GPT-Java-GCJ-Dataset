import java.util.Scanner;

public class Solution {
	
	public static int getResult(int initialTargetX, int initialTargetY, String road) {
		char[] roadArray = road.toCharArray();
		int[] distance = new int[road.length() + 1];
		distance[0] = Math.abs(initialTargetX) + Math.abs(initialTargetY);
		for (int i = 0; i < road.length(); i++) {
			switch(road.charAt(i)) {
			case 'N':
				initialTargetY++;
				break;
			case 'S':
				initialTargetY--;
				break;
			case 'E':
				initialTargetX++;
				break;
			case 'W':
				initialTargetX--;
				break;
			}
			distance[i + 1] = Math.abs(initialTargetX) + Math.abs(initialTargetY);
		}
		
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] <= i) return i;
		}
		return -1;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int initialTargetX = scanner.nextInt();
			int initialTargetY = scanner.nextInt();
			String road = scanner.next();
			
			
			System.out.print("Case #" + (i + 1) + ": ");
			int result = getResult(initialTargetX, initialTargetY, road);
			if (result == -1) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}
		}
	}
}