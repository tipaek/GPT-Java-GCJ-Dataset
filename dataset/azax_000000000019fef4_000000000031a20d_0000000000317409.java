import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			String[] line = sc.nextLine().split(" ");
			int x = Integer.parseInt(line[0]);
			int y = Integer.parseInt(line[1]);
			String path = line[2];
			
			System.out.println(
					"Case #" + (index + 1) + ": " +  solve(x, y, path)
			);
		}
		sc.close();
		
	}
	
	private static String solve(int x, int y, String path) {
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			switch(c) {
				case 'N':
					y += 1; break;
				case 'S':
					y -= 1; break;
				case 'E':
					x += 1; break;
				default:
					x -= 1; break;
			}
			if (Math.abs(x) + Math.abs(y) <= i + 1) {
				return Integer.toString(i + 1);
			}
		}
		
		return "IMPOSSIBLE";
	}
}
