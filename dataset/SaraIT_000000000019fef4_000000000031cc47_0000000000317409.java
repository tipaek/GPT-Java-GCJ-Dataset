import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	static String solutin(int x, int y, String target) {
		int minute = 0;
		int solution = -1;
		int min = 100000;
		for (int i = 0; i < target.length(); i++) {
			if ((target.charAt(i)+"").equals("S")) {
				y--;
				minute++;
				solution = x + Math.abs(y);
				
			} else if ((target.charAt(i)+"").equals("N")) {
				//x--;
				y++;
				minute++;
				solution = x + Math.abs(y);
			}
			
			if (solution != -1 && solution <= min && solution <=minute) {
				min = solution;
				return minute+"";

			}
		}
		if (min == 100000) {
			return "IMPOSSIBLE";
		} else {
			return minute+"";
		}
	}

	public static void main(String[] args) {
		int T =  Integer.parseInt(in.nextLine());
		String[] line;
		String solution = "";
		
		for (int i = 1; i <= T; i++) {
			line =in.nextLine().split("\\s+");
			solution = solutin(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2]);
			
			System.out.println("Case #" + i + ": " + solution);
			
		}
		
	}

}
