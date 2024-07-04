import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			String src = in.next();
			System.out.print("CASE #" + (t + 1) + ": ");
			int layer = 0;
			for (int i = 0, iMax = src.length(); i < iMax; i++) {
				char vStr = src.charAt(i);
				int v = vStr - '0';
				if (v < 0 || v > 9) {
					throw new IllegalArgumentException();
				}
				while (v > layer) {
					System.out.print('(');
					layer++;
				}
				while (v < layer) {
					System.out.print(')');
					layer--;
				}
				System.out.print(vStr);
			}
			while (layer > 0) {
				System.out.print(')');
				layer--;
			}
			System.out.println();
		}
	}
}
