package bullseye;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static final String CENTER = "CENTER";
	private static final String HIT = "HIT";
	private static final String MISS = "MISS";
	private static final String WRONG = "WRONG";
	
	private static final int BILLION = 1_000_000_000;
	private static final int TEST_SET_1 = BILLION - 5;
	private static final int TEST_SET_2 = BILLION - 50;
	private static final int TEST_SET_3 = BILLION / 2;
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			String[] line = sc.nextLine().split(" ");
			int numCases = Integer.parseInt(line[0]);
			int minR = Integer.parseInt(line[2]);
			for (int index = 0; index < numCases; index++) {
				if (minR == TEST_SET_1) {
					executeStrategyA(sc);
				} else if (minR == TEST_SET_2) {
					executeStrategyB(sc);
				} else {
					executeStrategyC(sc);
				}
			}
		}
	}
	
	private static void executeStrategyA(Scanner sc) {
		for (int x = -5; x <= 5; x++) {
			for (int y = -5; y <= 5; y++) {
				System.out.println(x + " " + y);
				String answer = sc.nextLine();
				if (CENTER.equals(answer)) {
					return;
				}
			}
		}
	}
	
	private static void executeStrategyB(Scanner sc) {
		int step = 12;
		int startY = 25;
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
		
		step = 12;
		int startX = 25;
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
		
		for (int x = -8; x <= 6; x++) {
			for (int y = -8; y <= 6; y++) {
				System.out.println((x + startX) + " " + (y + startY));
				answer = sc.nextLine();
				if (CENTER.equals(answer)) {
					return;
				}
			}
		}
	}
	
	private static void executeStrategyC(Scanner sc) {
		System.out.println((BILLION + 1) + " " + (BILLION + 1));
	}
}