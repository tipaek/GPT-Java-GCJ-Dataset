import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner((Readable) new BufferedReader(
				new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for ( int t = 1 ; t <= T ; t++ ) {
			int N = sc.nextInt();
			Event[] list = new Event[N * 2];
			for ( int i = 0 ; i < N ; i++ ) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				list[2 * i] = new Event(i, s, 1);
				list[2 * i + 1] = new Event(i, e, 0);
			}
			Arrays.sort(list);

			int c = -1;
			int j = -1;
			boolean impossible = false;
			char[] assign = new char[N];
			for ( Event e : list ) {
				if ( e.type == 1 ) {
					if ( c == -1 ) {
						assign[e.id] = 'C';
						c = e.id;
					} else if ( j == -1 ) {
						assign[e.id] = 'J';
						j = e.id;
					} else {
						impossible = true;
						break;
					}
				} else {
					if ( c == e.id ) {
						c = -1;
					} else if ( j == e.id ) {
						j = -1;
					}
				}
			}
			String ans = null;
			if ( impossible ) {
				ans = "IMPOSSIBLE";
			} else {
				ans = new String(assign);
			}
			System.out.println("Case #" + t + ": " + ans);
		}
		sc.close();
	}
}

class Event implements Comparable<Event> {
	int id = 0;
	int t = 0;
	int type = 0; // 1:start, 0:end
	Event(int id, int t, int type) {
		this.id = id;
		this.t = t;
		this.type = type;
	}

	@Override
	public int compareTo(Event o) {
		if ( this.t != o.t ) {
			return this.t - o.t;
		} else if ( this.type != o.type ) {
			return this.type - o.type;
		} else {
			return this.id - o.id;
		}
	}
}