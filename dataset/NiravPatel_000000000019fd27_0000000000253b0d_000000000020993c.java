import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int n, sum, rowCommon, colCommon;
		String str, strArr[][];
		for (int i = 1; i <= t; ++i) {
			n = in.nextInt();
			sum =0;
			rowCommon = 0;
			colCommon = 0;
			strArr = new String[n][n];
			in.nextLine();
			for (int j = 0; j < n; ++j) {
				strArr[j] = in.nextLine().split(" ");
			}
			for(int j=0; j<n; j++) {
				sum += Integer.parseInt(strArr[j][j]);
			}
			for(int j=0; j<n; j++) {
				HashSet<String> temp = new HashSet<>(Arrays.asList(strArr[j]));
				if(temp.size() != n) {
					rowCommon++;
				}
			}
			for(int j=0; j<n; j++) {
				HashSet<String> temp = new HashSet<>();
				for(int k=0; k<n; k++) {
					temp.add(strArr[k][j]);
				}
				if(temp.size() != n) {
					colCommon++;
				}
			}
			System.out.println("Case #" + i + ": " + sum + " " + rowCommon + " " + colCommon);
		}
	}
}