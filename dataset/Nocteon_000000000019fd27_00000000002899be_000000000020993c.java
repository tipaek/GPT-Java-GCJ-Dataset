import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int cases = kb.nextInt();
		for(int cc = 1; cc <= cases; cc++) {
			System.out.print("Case #" + cc + ": ");
			int sqLen = kb.nextInt();
			int[][] square = new int[sqLen][sqLen];
			int k = 0;
			int r = 0;
			int c = 0;
			for(int i = 0; i < sqLen; i++)
				for(int j = 0; j < sqLen; j++) {
					square[i][j] = kb.nextInt();
					if(i == j) k+=square[i][j];
				}
			HashSet<Integer> dups;
			for(int i = 0; i < sqLen; i++) {
				dups = new HashSet<>();
				for(int j = 0; j < sqLen; j++) {
					if(dups.contains(square[i][j])) {
						r++;
						break;
					}
					dups.add(square[i][j]);
				}
			}
			for(int i = 0; i < sqLen; i++) {
				dups = new HashSet<>();
				for(int j = 0; j < sqLen; j++) {
					if(dups.contains(square[j][i])) {
						c++;
						break;
					}
					dups.add(square[j][i]);
				}
			}
			System.out.println(k + " " + r + " " + c);
		}
	}
}
