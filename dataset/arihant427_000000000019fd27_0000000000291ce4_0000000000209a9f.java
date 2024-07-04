import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		String t;
		Scanner scn = new Scanner(System.in);

		t = scn.next();
		List<String> input = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(t); i++) {
			input.add(scn.next());
		}
		for (int i = 0; i < input.size(); i++) {
System.out.print("Case #"+(i+1)+": ");
			List<Integer> dataList = new ArrayList<>();
			for (int j = 0; j < input.get(i).length(); j++) {
				char charVal = (input.get(i)).charAt(j);
				dataList.add(Integer.parseInt(String.valueOf(charVal)));
			}
			int remaining = dataList.get(0);
			for (int k = 0; k < dataList.get(0); k++) {
				System.out.print("(");
			}
			for (int k = 0; k < dataList.size(); k++) {
				if (dataList.get(k) > remaining) {
					for (int l = 0; l < dataList.get(k) - remaining; l++) {
						System.out.print("(");

					}
					remaining = dataList.get(k);
				}
				System.out.print(dataList.get(k));
				if (k + 1 < dataList.size()) {
					for (int j = 0; j < dataList.get(k) - dataList.get(k + 1); j++) {
						System.out.print(")");
						remaining = dataList.get(k + 1);
					}
				} else {
					if (remaining > 0) {
						for (int j = 0; j < dataList.get(k); j++) {
							System.out.print(")");
							remaining = remaining - dataList.get(k);
						}
					}
				}

			}
			System.out.println();
		}

	}
}
