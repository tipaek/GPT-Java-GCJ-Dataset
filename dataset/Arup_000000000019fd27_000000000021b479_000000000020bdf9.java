import java.util.*;

public class c {

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int nC = stdin.nextInt();
		
		for (int loop=1; loop<=nC; loop++) {
		
			// Read in times.
			int n = stdin.nextInt();
			event[] events = new event[n];
			for (int i=0; i<n; i++) {
				int s = stdin.nextInt();
				int e = stdin.nextInt();
				events[i] = new event(s,e,i);
			}
			Arrays.sort(events);
			
			char[] res = new char[n];
			boolean ok = true;
			int cReady = 0, jReady = 0;
			for (int i=0; i<n; i++) {
				
				if (events[i].s >= cReady && (cReady >= jReady || jReady > events[i].s)) {
					res[events[i].id] = 'C';
					cReady = events[i].e;
				}
				else if (events[i].s >= jReady) {
					res[events[i].id] = 'J';
					jReady = events[i].e;
				}
				else {
					ok = false;
					break;
				}
			}
			
			if (ok)
				System.out.println("Case #"+loop+": "+(new String(res)));
			else
				System.out.println("Case #"+loop+": IMPOSSIBLE");
		}
	}
}

class event implements Comparable<event> {
	public int s;
	public int e;
	public int id;
	
	public event(int mys, int mye, int myid) {
		s = mys;
		e = mye;
		id = myid;
	}
	
	public int compareTo(event other) {
		if (e != other.e) return e - other.e;
		return id - other.id;
	}
}