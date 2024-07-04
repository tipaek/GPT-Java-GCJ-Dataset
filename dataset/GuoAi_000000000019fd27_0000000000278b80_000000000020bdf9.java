import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int T = fio.nextInt();
		for (int i = 0; i < T; i++) {
			int caseNum = i + 1;
			int N = fio.nextInt();
			String[] res = new String[N];
			PriorityQueue<Event> events = new PriorityQueue<>();
			Event cameron = null;
			Event jamie = null;
			boolean possible = true;
			for (int j = 0; j < N; j++) {
				events.add(new Event(fio.nextInt(), fio.nextInt(), j));
			}
			while (events.size() != 0) {
				Event thisEvent = events.poll();
				if (cameron == null) {
					res[thisEvent.num] = "C";
					cameron = thisEvent;
				} else if (jamie == null) {
					res[thisEvent.num] = "J";
					jamie = thisEvent;
				} else {
					if (thisEvent.startTime >= cameron.endTime) {
						res[thisEvent.num] = "C";
						cameron = thisEvent;
					} else if (thisEvent.startTime >= jamie.endTime) {
						res[thisEvent.num] = "J";
						jamie = thisEvent;
					} else {
						fio.println("Case #" + caseNum + ": IMPOSSIBLE");
						possible = false;
						break;
					}
				}
			}
			if (possible) {
				fio.print("Case #" + caseNum + ": ");
				for (int j = 0; j < N; j++) {
					fio.print(res[j]);
				}
				fio.println();
			}
		}
		fio.close();
	}
}

class Event implements Comparable<Event> {
	public int startTime;
	public int endTime;
	public int num;
	public Event(int startTime, int endTime, int num) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.num = num;
	}
	@Override
	public int compareTo(Event other) {
		if (this.endTime != other.endTime) {
			return this.endTime - other.endTime;
		} else if (this.startTime != other.startTime) {
			return this.startTime - other.startTime;
		}
		return this.num - other.num;
	}
}

class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
        br = new BufferedReader(new
                InputStreamReader(System.in));
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}