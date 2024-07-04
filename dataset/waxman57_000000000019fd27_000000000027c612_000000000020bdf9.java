import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private static class Event implements Comparable<Event>{
		int start, end;
		int order;

		public int compareTo(Event o) {
			return Integer.compare(start, o.start);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int x = 0; x < T; x++) {
			int S = s.nextInt();
			Event[] arr = new Event[S];
			for(int y = 0; y < S; y++) {
				arr[y] = new Event();
				arr[y].start = s.nextInt();
				arr[y].end = s.nextInt();
				arr[y].order = y;
			}
			Arrays.sort(arr);
			int cEnd = -1;
			int jEnd = -1;
			System.out.print("Case #" + (x + 1) + ": ");
			boolean impossible = false;
			char[] res = new char[S];
			for(int y = 0; y < S; y++) {
				if(cEnd == - 1 || cEnd <= arr[y].start) {
					res[arr[y].order] = 'C';
					cEnd = arr[y].end;
				} else if(jEnd == -1 || jEnd <= arr[y].start) {
					res[arr[y].order] = 'J';
					jEnd = arr[y].end;
				} else {
					impossible = true;
					System.out.print("IMPOSSIBLE");
					break;
				}
			}
			if(!impossible) {
				System.out.print(new String(res));
			}
			System.out.println();
		}
	}
	
}
