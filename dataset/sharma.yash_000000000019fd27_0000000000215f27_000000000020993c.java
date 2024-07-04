import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = sc.nextInt();
			Column[] columns = new Column[n];
			Row[] rows = new Row[n];
			int trace = 0;
			int r = 0;
			int c = 0;
			for (int j = 0; j < n; j++) {
				rows[j] = new Row();
				for (int k = 0; k < n; k++) {
					int val = sc.nextInt();
					if (columns[k] == null)
						columns[k] = new Column();
					rows[j].list.add(val);
					columns[k].list.add(val);
					
					if( j == k )
						trace += val;
				}
			}

			for (int j = 0; j < n; j++) {
				if(rows[j].hasDuplicates())
					r++;
				if(columns[j].hasDuplicates())
					c++;
			}
			
			System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
		}
	}
}

class Grid {
	List<Integer> list = new ArrayList<Integer>();

	public boolean hasDuplicates() {
		Set<Integer> set = new HashSet<Integer>(list);
		if (set.size() != list.size())
			return true;
		return false;
	}
}

class Column extends Grid {
}

class Row extends Grid {
}