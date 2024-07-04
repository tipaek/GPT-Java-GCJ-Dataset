import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<int[][]> list = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int a[][] = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					a[j][k] = sc.nextInt();
				}
			}
			list.add(a);
		}
		int index = 1;
		for (int[][] a : list) {
			int t = getTrace(a);
			int r = getNoOfRawsHavingRepeatedValues(a);
			int c = getNoOfColsHavingRepeatedValues(a);
			System.out.println("Case #" + index + ": " + t + " " + r + " " + c);
		}
	}

	public static int getNoOfRawsHavingRepeatedValues(int[][] a) {
		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (!set.add(a[i][j])) {
					count++;
					break;
				}
			}
			set.clear();
		}
		return count;
	}

	public static int getNoOfColsHavingRepeatedValues(int[][] a) {
		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (!set.add(a[j][i])) {
					count++;
					break;
				}
			}
			set.clear();
		}
		return count;
	}

	public static int getTrace(int[][] a) {
		int trace = 0;
		for (int i = 0; i < a.length; i++) {
			trace += a[i][i];
		}
		return trace;
	}
}