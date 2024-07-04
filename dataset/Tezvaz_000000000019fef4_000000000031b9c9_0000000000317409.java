import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			String firstLine = in.nextLine();
			int X = Integer.parseInt(firstLine.split(" ")[0]);
			int Y = Integer.parseInt(firstLine.split(" ")[1]);
			int indexOfSecondSpace = firstLine.indexOf(" ", firstLine.indexOf(" ") + 1);
			
			char[] path = firstLine.substring(indexOfSecondSpace + 1).toCharArray();
			int catCurrX = X;
			int catCurrY = Y;
			
			int min = 20000;
			
			for(int j = 0; j < path.length + 1; j++) {
				
				if(j >= Math.abs(catCurrX) + Math.abs(catCurrY)) {
					if(min > j) {
						min = j;
					}
				}
				
				if(j < path.length) {
					if(path[j] == 'N') {
						++catCurrY;
					} else if (path[j] == 'S') {
						--catCurrY;
					} else if (path[j] == 'E') {
						++catCurrX;
					} else if (path[j] == 'W') {
						--catCurrX;
					}
				}
			}
			
			if(min <= 1000) {
				System.out.println("Case #" + (i+1) + ": " + min);
			} else {
				System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
			}
			
		}
		
		in.close();
	}
}
