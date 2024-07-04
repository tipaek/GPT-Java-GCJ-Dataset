import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int tc = 1; tc <= t; ++tc) {
			int trace = 0;
			in.nextLine();
			int n = in.nextInt();
			HashSet<?>[] rowsUniqueValues = new HashSet<?>[n];
			HashSet<?>[] columnsUniqueValues = new HashSet<?>[n];
			for (int i = 0; i < n; i++) {
				rowsUniqueValues[i] = new HashSet<>();
				columnsUniqueValues[i] = new HashSet<Integer>();
			}
			for (int i = 0; i < n; i++) { // rows
				in.nextLine();
				for (int j = 0; j < n; j++) {
					int v = in.nextInt();
					((HashSet<Integer>)rowsUniqueValues[i]).add(new Integer(v));
					((HashSet<Integer>)columnsUniqueValues[j]).add(new Integer(v));
					if (i == j) {
						trace+= v;
					}
				}
			}
			int repeatedElementsRows = 0;
			int repeatedElementsColumns = 0;
			for (int i = 0; i < n; i++) {
				if (rowsUniqueValues[i].size() < n) {
					repeatedElementsRows++;
				}
				if (columnsUniqueValues[i].size() < n) {
					repeatedElementsColumns++;
				}
			}
			
			System.out.println("Case #" + tc + ": " + trace + " " + repeatedElementsRows + " " + repeatedElementsColumns);
		}
	}
}