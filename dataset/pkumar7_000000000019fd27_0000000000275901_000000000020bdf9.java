import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
       /* do {
            in.nextInt();
        } while (in.hasNextLine());*/
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int case_number = 1; case_number <= t; ++case_number) {
            int N = in.nextInt();
			int[][] intervals = new int[N][2];
			for (int i = 0; i < N; i++) {
				int[] curr = new int[2];
				curr[0] = in.nextInt();
				curr[1] = in.nextInt();
				intervals[i] = curr;
			}
			String output = schedule(intervals);
			String res = "Case #"+case_number + ": " + output;
            System.out.println(res);
        }
    }

    public static String schedule(int[][] intervals){
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				int comp = Integer.compare(a[0], b[0]);
				if(comp == 0){
					return Integer.compare(a[1], b[1]);
				}
				return comp;
			}
		});

		StringBuilder builder = new StringBuilder();
		boolean isJFree = true;
		boolean isCFree = true;
		int[] cInt = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
		int[] jInt = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
		for (int[] curr : intervals){
			if(curr[0] >= jInt[1]) {
				isJFree = true;
			}else if(curr[0] >= cInt[1]) {
				isCFree = true;
			}else if(!isCFree && !isJFree){
				builder = new StringBuilder();
				builder.append("IMPOSSIBLE");
				break;
			}
			if(isCFree){
				cInt = curr;
				isCFree = false;
				builder.append("C");
			}else if(isJFree){
				jInt = curr;
				isJFree = false;
				builder.append("J");
			}
		}
		//System.out.println("builder = " + builder.toString());
		return builder.toString();
	}

    static String isLatinSquare(int[][] matrix , int case_number, int N){
		int rowsDup = 0;
		int colsDup = 0;
		int trace = 0;

		for (int i = 0; i < matrix.length; i++) {
			trace += matrix[i][i];
		}
		for (int i = 0; i < matrix.length; i++) {
			Set<Integer> sets = new HashSet<>();
			for (int j = 0; j <matrix[i].length; j++) {
				if(!sets.add(matrix[i][j])){
					rowsDup++;
					break;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			Set<Integer> sets = new HashSet<>();
			for (int j = 0; j <matrix[i].length; j++) {
				if(!sets.add(matrix[j][i])){
					colsDup++;
					break;
				}
			}
		}

		String res = "Case #" + case_number + ": " + trace + " " + rowsDup +" " + colsDup;
		System.out.println("res = " + res);
		return res;
	}

}
