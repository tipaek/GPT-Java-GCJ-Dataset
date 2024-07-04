import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static final String CENTER = "CENTER";
	private static final String HIT = "HIT";
	private static final String MISS = "MISS";
	private static final String WRONG = "WRONG";
	
	private static final int BILLION = 1000 * 1000 * 1000;
	private static final int TEST_SET_1 = BILLION - 5;
	private static final int TEST_SET_2 = BILLION - 50;
	private static final int TEST_SET_3 = BILLION / 2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String[] line = sc.nextLine().split(" ");
		int numCases = Integer.parseInt(line[0]);
		int minR = Integer.parseInt(line[2]);
		for (int index = 0; index < numCases; index++) {
			if (minR == TEST_SET_1) {
				strategyA(sc);
			} else if (minR == TEST_SET_2) {
				strategyB(sc);
			} else {
				strategyC(sc);
			}
		}
		sc.close();
	}
	
	private static void strategyA(Scanner sc) {
		for (int x = -5; x < 6; x++) {
			for (int y = -5; y < 6; y++) {
				System.out.println(x + " " + y);
				String answer = sc.nextLine();
				if (CENTER.equals(answer)) {
					return;
				} else if (HIT.equals(answer)) {
					
				} else if (MISS.equals(answer)) {
					
				}  else if (WRONG.equals(answer)) {
					
				}
			}
		}
	}
	
	private static void strategyB(Scanner sc) {
		int step = 25;
		int startY = 50;
		String answer;
		while (step > 1) {
			System.out.println(0 + " " + (BILLION - startY));
			answer = sc.nextLine();
			if (HIT.equals(answer)) {
				startY += step;
			} else {
				startY -= step;
			}
			step /= 2;
		}
		
		step = 25;
		int startX = 50;
		while (step > 1) {
			System.out.println((BILLION - startX) + " " + 0);
			answer = sc.nextLine();
			if (HIT.equals(answer)) {
				startX += step;
			} else {
				startX -= step;
			}
			step /= 2;
		}
		
		for (int x = -8; x < 7; x++) {
			for (int y = -8; y < 7; y++) {
				System.out.println((x + startX) + " " + (y + startY));
				answer = sc.nextLine();
				if (CENTER.equals(answer)) {
					return;
				} else if (HIT.equals(answer)) {
					
				} else if (MISS.equals(answer)) {
					
				}  else if (WRONG.equals(answer)) {
					
				}
			}
		}
	}
	
	private static void strategyC(Scanner sc) {
		System.out.println((BILLION + 1) + " " + (BILLION + 1));
	}
}
