import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int testCases = scanner.nextInt();
		
		if(100 < testCases || testCases <1)
			extracted();
		
		String output[] = new String[testCases] ;

		for (int t = 0; t < testCases; t++) {
			
			
			int activities =scanner.nextInt();
			
			if(activities<2 || activities>1000)
				extracted();

			
			int[][] input = new int[activities][];

			for (int sch = 0; sch < activities; sch++) {
				
				int start =scanner.nextInt();	
				
				if(start<0 || start >1440)
					extracted();
				
				int end =scanner.nextInt();
				
				if(end<0 || end >1440)
					extracted();
				
				int[] entry = { sch + 1, start, end, -1 };

				input[sch] = entry;
			}

			input = sortArray(input, 1);

			int[] c = { 0, 0 };
			int[] j = { 0, 0 };
			boolean imp = false;

			for (int i = 0; i < input.length; i++) {

				if (c[0] == 0 || j[0] == 0) {
					if (c[0] == 0) {
						c[0] = 1;
						c[1] = i;
						input[i][3] = 0;

					} else {
						j[0] = 1;
						j[1] = i;
						input[i][3] = 1;
					}
				} else {

					if (input[i][1] >= input[c[1]][2]) {
						c[0] = 1;
						c[1] = i;
						input[i][3] = 0;
					} else if (input[i][1] >= input[j[1]][2]) {
						j[0] = 1;
						j[1] = i;
						input[i][3] = 1;
					} else {
						input[i][3] = -1;
						imp = true;
					}

				}

			}

			if (imp) {
				output[t] = "IMPOSSIBLE";
			} else {
				String result = "";
				input = sortArray(input, 0);

				for (int i = 0; i < input.length; i++) {
					result += (input[i][3] == 0 ? "C" : "J");
				}

				output[t] = result;
			}

		}

		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i + 1) + ": " + output[i]);
		}

	}

	private static int[][] sortArray(int[][] input, int index) {

		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i][index] > input[j][index]) {
					int[] temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}

		return input;
	}

	private static void extracted() throws Exception {
		throw new Exception();
	}

}
