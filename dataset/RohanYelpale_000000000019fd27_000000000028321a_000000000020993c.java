import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Codejam1 {

	public static void main(String[] args) {
		int t, n, k, r, c;
		int array[][];
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		String input;
		for (int w = 0; w < t; w++) {
			input = "";
			n = sc.nextInt();
			array = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					array[i][j] = sc.nextInt();
					input = input + array[i][j];
				}
				input = input + " ";
			}
			input = input.trim();
			String strs[] = input.split(" ");
			k = 0;
			r = 0;
			for (int l = 0; l < strs.length; l++) {
				k = k + Integer.parseInt(strs[(int) l].charAt((int) l) + "");
				char[] characterArray = strs[(int) l].toCharArray();
				Arrays.sort(characterArray);
				for (int j = 0; j < characterArray.length - 1; j++) {
					if (characterArray[j] == characterArray[j + 1]) {
						r++;
						break;
					}
				}

			}

			c = 0;
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					list.add(array[i][j]);
				}
				Collections.sort(list);
				for (int l = 0; l < list.size() - 1; l++) {
					if (list.get(l) == list.get(l + 1)) {
						c++;
						break;
					}
				}
				list.clear();
			}
			System.out.println("Case #" + (w + 1) + ": " + k + " " + r + " " + c);

		}
		sc.close();

	}

}
