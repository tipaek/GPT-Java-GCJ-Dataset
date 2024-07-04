import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    		String answer = "";
    		int n = in.nextInt();
    		List<Event> cameron = new ArrayList<>();
    		List<Event> jamie = new ArrayList<>();
    		boolean cam_flag = false;
    		boolean jam_flag = false;
    		for(int j = 0; j < n; j++) {
    			Event event = new Event(in.nextInt(), in.nextInt());
    			cam_flag = false;
    			jam_flag = false;
    			for(Event e: cameron) {
    				if(e.overlap(event)) {
    					cam_flag = true;
    					break;
    				}
    			}
    			for(Event e: jamie) {
    				if(e.overlap(event)) {
    					jam_flag = true;
    					break;
    				}
    			}
    			if(cam_flag && jam_flag) {
    				answer = "IMPOSSIBLE";
    				break;
    			}
    			if(cam_flag && !jam_flag) {
    				jamie.add(event);
    				answer+="J";
    			}
    			if(!cam_flag) {
    				cameron.add(event);
    				answer+="C";
    			}
    		}
    		
    		System.out.println("Case #" + i + ": " + answer);
    }
  }
}
class Event{
	int s;
	int e;
	public Event(int start, int end) {
		s = start;
		e = end;
	}
	public boolean overlap (Event e2) {
		return !(s >= e2.e || e <= e2.s);
	}
}