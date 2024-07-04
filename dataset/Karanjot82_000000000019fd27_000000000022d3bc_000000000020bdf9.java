import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = in.nextInt();
			int start[] = new int[n];
			int dept[] = new int[n];
			for (int i = 0; i < n; i++) {
				start[i] = in.nextInt();
				dept[i] = in.nextInt();
			}
			int temp[] = new int[n];
			int temp2[] = new int[n];
			for(int i =0 ; i<n;i++) {
				temp[i] = start[i];
				temp2[i] = dept[i];
			}
			int result = find(start, dept, n);
			if (result > 2) {

				System.out.print("Case #" + t + ": ");
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.print("Case #" + t + ": ");
				printMaxActivities(temp, temp2, n);
				System.out.println();
			}
		}
	}

	static int find(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int need = 1, result = 1;
		int i = 1, j = 0;
		while (i < n && j < n) {
			if (arr[i] < dep[j]) {
				need++;
				i++;
				if (need > result)
					result = need;
			}

			else {
				need--;
				j++;
			}
		}

		return result;
	}

	public static void printMaxActivities(int s[], int f[], int n) {
		

		List<Pair> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(new Pair(s[i],f[i],i));
		}
		
		list.sort((l,r)->{
			return Integer.compare(l.end, r.end);
		});
		// The first activity always gets selected
		char c[] = new char[n];
		int i, j;
		i = 0;
		c[list.get(0).index]='C';

		// Consider rest of the activities
		for (j = 1; j < n; j++) {
			// If this activity has start time greater than or
			// equal to the finish time of previously selected
			// activity, then select it
			if (list.get(j).start >= list.get(i).end) {
				c[list.get(j).index]='C';
				i = j;
			} else {

				c[list.get(j).index]='J';
			}
		}
		for(char ch:c) {
			System.out.print(ch);
		}
	}
	
	static class Pair{
		int start;
		int end;
		int index;
		public Pair(int start, int end, int index) {
			super();
			this.start = start;
			this.end = end;
			this.index = index;
		}
		
	}

}
