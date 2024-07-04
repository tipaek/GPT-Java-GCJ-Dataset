import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			int nc = sc.nextInt();
			for (int ci = 1; ci <= nc; ci++) {
				List<Integer> sz = new ArrayList<>();
				List<Integer> val = new ArrayList<>();
				String text = sc.next("\\d+");
				char[] in = text.toCharArray();
				int pv = -1;
				for (char c : in) {
					int cv = c - 48;
					if (pv != cv) {
						val.add(cv);
						sz.add(1);
					} else {
						int idx = val.size() - 1;
						sz.set(idx, sz.get(idx) + 1);
					}
					pv = cv;
				}
				System.out.print("Case # " + ci + " ");
				for (int i = 0; i < val.size(); i++) {
					for (int j = 0; j < val.get(i); j++) {
						System.out.print("(");
					}
					for (int j = 0; j < sz.get(i); j++) {
						System.out.print(val.get(i));
					}
					for (int j = 0; j < val.get(i); j++) {
						System.out.print(")");
					}
				}
				System.out.println();
			}
		}
	}
}