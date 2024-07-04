import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = null;
		if (System.getProperties().getProperty("user.name").equals("Alexey") || 
				System.getProperties().getProperty("user.name").equals("Aleksiej_Mitrofanov")) {
			sc = new Scanner(new FileInputStream("input.txt"));
			System.err.println("development mode, reading from file");
		} else {
			sc = new Scanner((System.in));
		}

		int testCases = Integer.parseInt(sc.nextLine());
		for (int i = 1; i < testCases + 1; i++) {
			String[] taskLine = sc.nextLine().split(" ");
			int x = Integer.parseInt(taskLine[0]);
			int y = Integer.parseInt(taskLine[1]);
			char[] M = taskLine[2].toCharArray();
			String result = readAndresolveSingleCase(x, y, M);
			System.out.println("Case #" + i + ": " + result);
			System.out.flush();
		}
		sc.close();
	}

	private static String readAndresolveSingleCase(int x, int y, char[] route) {
		if (x==0 && y==0) {
			return "0";
		}
		int result = -1;
		int currX=x, currY=y;
		int minResult = Integer.MAX_VALUE;
		
		for (int i = 0; i < route.length; i++) {
			switch(route[i]) {
			case 'N':
				currY++;
				break;	
			case 'S':
				currY--;
				break;
			case 'W':
				currX--;
				break;
			case 'E':
				currX++;
				break;
			}
			if ((i+1)>=Math.abs(currX)+Math.abs(currY)) {
				return "" + (i+1);
			}
		}
		return "IMPOSSIBLE";
	}
	
}