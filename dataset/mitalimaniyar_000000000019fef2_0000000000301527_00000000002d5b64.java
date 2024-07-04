import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		List<List<String>> answers = new ArrayList<>();
		for (int count = 0; count < t; count++) {
			int r = s.nextInt();
			int c = s.nextInt();

			List<Integer> sequence = new LinkedList<>();
			List<Integer> required = new LinkedList<>();
			for (int i = c; i >= 1; i--) {
				for (int j = r; j >= 1; j--) {
					sequence.add(j);

				}
			}

			for (int i = r; i >= 1; i--) {
				for (int j = c; j >= 1; j--) {
					required.add(i);

				}
			}

			List<String> answer = new ArrayList<>();
			// all is sorted before ptr1
			int ptr1 = 0, ptr2 = 0;
			while (true) {
				while (ptr1 < sequence.size() && required.get(ptr1) == sequence.get(ptr1)) {
					ptr1++;
				}
				if (ptr1 >= sequence.size()) {
					break;
				}
				ptr2 = ptr1 + 1;
				int num = required.get(ptr1);
				while (ptr2 < sequence.size() && sequence.get(ptr2) != num) {
					ptr2++;
				}

				int n1 = sequence.size() - ptr2;
				int n2 = ptr2 - ptr1;
				answer.add(n1 + " " + n2);

				for (int i = ptr1; i < ptr2; i++) {
					int number = sequence.remove(ptr1);
					sequence.add(number);
				}
			}
			answers.add(answer);
		}

		for (int count = 0; count < t; count++) {
			List<String> answer = answers.get(count);
			System.out.println("Case #" + (count + 1) + ": " + answer.size());
			for (String ans : answer) {
				System.out.println(ans);
			}
		}
	}

}
