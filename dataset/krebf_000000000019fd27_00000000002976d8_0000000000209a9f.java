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
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < val.size(); i++) {
					if (i > 0) {
						int cnt = val.get(i - 1) - val.get(i);
						if (cnt <= 0) {
							for (int j = 0; j < val.get(i) + cnt; j++) {
								sb.append("(");
							}
						}
					} else {
						for (int j = 0; j < val.get(i); j++) {
							sb.append("(");
						}
					}
					for (int j = 0; j < sz.get(i); j++) {
						sb.append(val.get(i));
					}
					if (i < val.size() - 1) {
						int cnt = Math.max(val.get(i) - val.get(i + 1), 0);
						for (int j = 0; j < cnt; j++) {
							sb.append(")");
						}
					} else {
						for (int j = 0; j < val.get(i); j++) {
							sb.append(")");
						}
					}
				}
				System.out.println(sb.toString());
				System.out.println();
			}
		}
	}
}