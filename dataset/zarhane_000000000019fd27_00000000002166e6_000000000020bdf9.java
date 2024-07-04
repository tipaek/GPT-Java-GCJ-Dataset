import java.io.*;
import java.util.*;

public class Solution {
	static int posSwitch = 0;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// TEST CASES----------------------------------------------------
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// READ----------------------------------------------------
		    int N = s.nextInt();
		    Event[] ev = new Event[2*N];
		    Map<Event, Event> getStart = new HashMap<>();
		    for (int i = 0; i < N; i++) {
                Event start = new Event(s.nextInt(), true, i);
                Event end = new Event(s.nextInt(), false, i+N);
		        ev[2*i] = start;
                ev[2*i+1] = end;
                getStart.put(end, start);
            }
		    
			// SOLVE----------------------------------------------------
		    Arrays.sort(ev);
		    boolean[] available = new boolean[2];
		    Arrays.fill(available, true);
		    
		    
		    Event e;
		    StringBuffer res = new StringBuffer();
		    for (int i = 0; i < ev.length; i++) {
		        e = ev[i];
		        		        
		        e.t = e.order;
		        if(e.isStart) {
		            if(available[0]) {
		                available[0]=false;
		                e.resp = 0;
		            } else if(available[1]) {
                        available[1]=false;
                        e.resp = 1;
                    } else {
                        res = new StringBuffer("IMPOSSIBLE");
                        break;
                    }
		        } else {
		            available[getStart.get(e).resp]=true;
		        }
            }		
		    
		    if(res.length()==0) {
		        char[] n = {'C', 'J'};
		        Arrays.sort(ev);
		        for (int i = 0; i < N; i++) {
                    res.append(n[ev[i].resp]);
                }
		    }
		    
			System.out.println("Case #"+tc+": "+res);
			
			
		}

		// CLOSE----------------------------------------------------
		s.close();
	}
}

class Event implements Comparable{
    int t = 0;
    boolean isStart;
    int resp = -1;
    int order;
    
    public Event(int t, boolean isStart, int order) {
        super();
        this.t = t;
        this.isStart = isStart;
        this.order = order;
    }

    @Override
    public int compareTo(Object o) {
        Event e = (Event) o;
        if(this.t > e.t || (this.t == e.t && this.isStart && !e.isStart))
            return 1;
        else if(this.t < e.t || (this.t == e.t && !this.isStart && e.isStart))
            return -1;
        return 0;
    }    
}