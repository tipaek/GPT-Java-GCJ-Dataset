import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static class Activity {
		int index;
		int s,t;
		int person;
		public Activity(int index, int s, int t) {
			this.index = index;
			this.s = s;
			this.t = t;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}
	
	static void solve(Scanner sc) {
		int N = sc.nextInt();
		Activity[] acts = new Activity[N];
		for(int i=0; i<N; i++) {
			acts[i] = new Activity(i, sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(acts, new Comparator<Activity>() {
			public int compare(Activity a1, Activity a2) {
				return Integer.compare(a1.s, a2.s);
			}
		});
		
		Activity[] current = new Activity[2];
		for(int i=0; i<N; i++) {
			int now = acts[i].s;
			boolean ok = false;
			for(int j=0; j<2; j++) {
				if(current[j]!=null && current[j].t<=now) {
					current[j] = null;
				}
				if(current[j]==null) {
					current[j] = acts[i];
					acts[i].person = j;
					ok = true;
					break;
				}
			}
			if(!ok) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		
		Arrays.sort(acts, new Comparator<Activity>() {
			public int compare(Activity a1, Activity a2) {
				return Integer.compare(a1.index, a2.index);
			}
		});
		
		for(int i=0; i<N; i++)
			System.out.print(acts[i].person==0 ? "C" : "J");
		System.out.println();
	}

}
