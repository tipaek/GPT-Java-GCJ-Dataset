import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanIntLine(scanner);
		for(int i = 1; i <= cases; i++) {
			int rows = scanIntLine(scanner);
			int[][] activities = new int[rows][2];
			for(int j = 0; j < rows; j++) {
				activities[j][0] = scanner.nextInt();
				activities[j][1] = scanIntLine(scanner);
			}
			if(checkPossible(activities)) {
				System.out.println("Case #" + i + ": " + plan(activities));
			}
			else {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
			}
		}
	}
	public static int scanIntLine(Scanner scanner) {
		int output = scanner.nextInt();
		scanner.nextLine();
		return output;
	}
	public static boolean checkPossible(int[][] activities) {
		int most = -1;
		for(int i = 0; i < activities.length; i++) {
			if(activities[i][1] > most)
				most = activities[i][1];
		}
		int[] notTheMostEfficientSolutionIK = new int[most + 1];
		for(int i = 0; i < activities.length; i++) {
			for(int j = activities[i][0] + 1; j <= activities[i][1]; j++) {
				if(notTheMostEfficientSolutionIK[j] < 2)
					notTheMostEfficientSolutionIK[j]++;
				else
					return false;
			}
		}
		return true;
	}
	public static String plan(int[][] activities) {
		String output = "";
		for(int i = 0; i < activities.length; i++) {
			output += " ";
		}
		int ca = -1;
		int ja = -1;
		for(int i = 0; i < activities.length; i++) {
			Integer least = null;
			for(int j = 0; j < activities.length; j++) {
				if(activities[j][0] != -1) {
					if(least == null)
						least = j;
					else if(activities[j][0] < activities[least][0]) 
						least = j;
				}
			}
			if(ca != -1 && activities[least][0] >= activities[ca][1]) 
				ca = -1;
			if(ja != -1 && activities[least][0] >= activities[ja][1]) 
				ja = -1;
			if(ca == -1) {
				ca = least;
				StringBuilder newOutput = new StringBuilder(output);
				newOutput.setCharAt(least, 'C');
				output = newOutput.toString();
				activities[least][0] = -1;
			}
			else if(ja == -1) {
				ja = least;
				StringBuilder newOutput = new StringBuilder(output);
				newOutput.setCharAt(least, 'J');
				output = newOutput.toString();
				activities[least][0] = -1;
			}
		}
		return output;
	}
}
