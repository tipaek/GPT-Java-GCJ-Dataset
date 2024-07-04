import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void getResult(int R, int S) {
		int[] array = new int[R * S];
		int index = 0;
		for (int i = 0; i < S; i++) {
			for (int j = 1; j <= R; j++) {
				array[index] = j;
				index++;
			}
		}
		
		List<int[]> ways = new ArrayList<>();
		int count = 0;
		int initial = R - 1;
		for (int i = R * (S - 1); i >= R * (S - 1) - (R - 1) * (S - 1) + 1; i--) {
			if (count == S - 1) {
				count = 0;
				initial--;
			}
			ways.add(new int[] {i, initial});
			count++;
		}
		
		System.out.print(ways.size());
		System.out.println();
		for (int[] element : ways) {
			System.out.println(element[0] + " " + element[1]);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int R= scanner.nextInt();
			int S = scanner.nextInt();
			System.out.print("Case #" + (i + 1) + ": ");
			getResult(R, S);
		}
	}
}