
// you can also use imports, for example:
import java.util.*;
import java.io.*;

class pair {
	int st, end, idx;

	pair(int st, int end, int idx) {
		this.st = st;
		this.end = end;
		this.idx = idx;
	}
}

class sortByIndex implements Comparator<pair> {

	public int compare(pair a, pair b) {
		return a.idx - b.idx;
	}
}

class sortByStart implements Comparator<pair> {

	public int compare(pair a, pair b) {
		return a.st - b.st;
	}
}


public class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int test_cases = in.nextInt();
		for (int q = 1; q <= test_cases; q++) {
			int len = in.nextInt();
			System.out.print("Case #" + q + ": ");
			ArrayList<pair> arr = new ArrayList();
			for (int x = 0; x < len; x++) {
				arr.add(new pair(in.nextInt(), in.nextInt(), x));
			}

			Collections.sort(arr, new sortByStart());
			char[] output = new char[len];
			output[arr.get(0).idx] = 'C';
			int dep1 = arr.get(0).end, dep2 = 0;
			boolean flag = true;
			for(int x = 1; x < len; x++) {
				int ari = arr.get(x).st;
				if(dep1 <= ari) {
					output[arr.get(x).idx] = 'C';
					dep1 = arr.get(x).end;
				}
				else if(dep2 <= ari) {
					output[arr.get(x).idx] = 'J';
					dep2 = arr.get(x).end;
				}
				else {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				for(int x = 0; x < len; x++) {
					System.out.print(output[x]);
				}
				System.out.println();
			}
			else {
				System.out.println("IMPOSSIBLE");
			}
			
		}
	}

	
}
