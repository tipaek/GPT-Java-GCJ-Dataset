import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        int[][] events;
        int[] eventTimes;
        int[] assignments;
        int nextEvent;
        int jShiftEnds;
        int cShiftEnds;
        boolean impossible;
        String answer;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	events = new int[N][3];
        	eventTimes = new int[N*2];
        	assignments = new int[N];
        	nextEvent = 0;
        	jShiftEnds = -1;
        	cShiftEnds = -1;
        	for (int j = 0; j < N; j++) {
        		st = new StringTokenizer(f.readLine());
        		events[j][0] = Integer.parseInt(st.nextToken());
        		events[j][1] = Integer.parseInt(st.nextToken());
        		events[j][2] = j;
        		
        		eventTimes[j*2] = events[j][0];
        		eventTimes[j*2+1] = events[j][1];
        	}
        	Arrays.sort(eventTimes);
        	Arrays.sort(events, (a, b) -> a[0]-b[0]);
        	
        	/*for (int j = 0; j < N; j++) {
        		System.out.println(events[j][0]+" "+events[j][1]+" "+events[j][2]);
        	}
        	System.out.println();
        	
        	for (int j = 0; j < N*2; j++) {
        		System.out.print(eventTimes[j]+" ");
        	}
        	System.out.println();*/
        	
        	int currentTime;
        	impossible = false;
        	for (int j = 0; j < eventTimes.length; j++) {
        		currentTime = eventTimes[j];
        		if (cShiftEnds == currentTime) {
        			cShiftEnds = -1;
        		} else if (jShiftEnds == currentTime) {
        			jShiftEnds = -1;
        		} else {
        			if (cShiftEnds == -1) {
        				cShiftEnds = events[nextEvent][1];
        				assignments[events[nextEvent][2]] = 1;
        			} else if (jShiftEnds == -1) {
        				jShiftEnds = events[nextEvent][1];
        				assignments[events[nextEvent][2]] = 2;
        			} else {
        				impossible = true;
        				j = eventTimes.length;
        			}
        			nextEvent++;
        		}
        	}
        	
        	for (int j = 0; j < assignments.length; j++) {
        		//System.out.print(assignments[j]+" ");
        	}
        	System.out.println();
        	
        	if (impossible) {
        		System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
        	} else {
        		answer = new String("");
        		for (int j = 0; j < assignments.length; j++) {
        			if (assignments[j] == 1) {
        				answer += 'C';
        			} else if (assignments[j] == 2) {
        				answer += 'J';
        			} else {
        				//System.out.println("Help!!");
        				answer += "x";//Shouldn't happen!!
        			}
        		}
        		System.out.println("Case #"+(i+1)+": "+answer);
        	}
        	
        }
        f.close();
    }
}