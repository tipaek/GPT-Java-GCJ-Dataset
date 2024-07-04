import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numt = input.nextInt();
		for (int i = 0; i < numt; i++) {
			String yuh = input.next();
			String str = yuh.replaceAll("(?<=\\d)(?=\\d)", " ");
			String strArray[] = str.split(" ");
			int[] arr = parseIntArray(strArray);
			List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
			int curr = 0;
			String ans = "";
			for (int a = 0; a <= list.size(); a++) {
				if (a == list.size()) {
					for (int b = 0; b < curr; b++) {
						ans += ")";
					}
					break;
				} else if (list.get(a) > curr) {
					for (int b = 0; b < list.get(a) - curr; b++) {
						ans += "(";
					}
				} else if (list.get(a) < curr) {
					for (int b = 0; b < curr - list.get(a); b++) {
						ans += ")";
					}
				}
				curr = list.get(a);
				ans += list.get(a);
			}
			System.out.println(ans);
		}
	}

	static int[] parseIntArray(String[] arr) {
		return Stream.of(arr).mapToInt(Integer::parseInt).toArray();
	}
}
