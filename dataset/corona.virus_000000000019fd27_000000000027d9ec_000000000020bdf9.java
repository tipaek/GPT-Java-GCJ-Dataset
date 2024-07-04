import java.io.*;
import java.util.*;
public class Solution{
    
	static class Event implements Comparable<Event>{
		int id;
		int s;
		int e;
		public Event(int id, int s, int e) {
			this.id=id;this.s=s;this.e=e;
		}
		
		@Override
		public int compareTo (Event o) {
			if( this.s < o.s) return -1;
			else if( this.s == o.s ) {
				if(this.e < o.e ) return -1;
				else if(this.e == o.e ) {
					return this.id-o.id;
				}
				return 1;
			}
			return 1;
		}
		
		public String toString() {
			return this.s+" : "+this.e;	
		}
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int sc=1;
		while(T-->0){
		    int n = Integer.parseInt(br.readLine());
		    Event[] events = new Event[n];
		    for(int i=0;i<n;i++) {
		    	String[] in=br.readLine().split(" ");
		    	events[i]=new Event(i, Integer.parseInt(in[0]), Integer.parseInt(in[1]));
		    }
		    bw.append("Case #"+(sc++)+": "+solve(events));
		    if(T>0) bw.append("\n");
		}
		bw.close();
    } 
    
    private static String solve( Event[] events) {
    	
    	Arrays.sort(events);
    	StringBuilder sb = new StringBuilder();
    	int[] buf = new int[] {-1,-1};
    	int poi=0;
    	List<String[]> out = new ArrayList<>();
    	while(poi < events.length) {
    		
    		if(buf[0] == -1) {
			    buf[0]=poi;
			    poi++;	
			}
    		if(poi==events.length) break;
    		if(buf[1]==-1) {
    			buf[1]=poi;
    			poi++;
    		}
    		Event tmp = null;
    		if(events[buf[0]].e <= events[buf[1]].e) {
    			tmp=events[buf[0]];
    			buf[0]=-1;
    			out.add(new String[] {String.valueOf(tmp.id), "C"});
    			
    		}else {
    			tmp=events[buf[1]];
    			buf[1]=-1;
    			out.add(new String[] {String.valueOf(tmp.id), "J"});
    		}
    		if(poi < events.length && tmp.e > events[poi].s ) return "IMPOSSIBLE";
    		
    	}
    	if(buf[0] == -1 || buf[1] == -1) {
    		if(buf[0]==-1) out.add(new String[] {String.valueOf(events[buf[1]].id), "J"});
    		else out.add(new String[] {String.valueOf(events[buf[0]].id), "C"});
    	}else if(events[buf[0]].compareTo(events[buf[1]])==-1) {
    		out.add(new String[] {String.valueOf(events[buf[0]].id), "C"});
    		out.add(new String[] {String.valueOf(events[buf[1]].id), "J"});
    	}else {
    		out.add(new String[] {String.valueOf(events[buf[1]].id), "J"});
    		out.add(new String[] {String.valueOf(events[buf[0]].id), "C"});
    	}
    	Collections.sort(out,(String[] a, String[] b)->{ 
    		return a[0].compareTo(b[0]);
    	});
    	for(String[] tmp : out) sb.append(tmp[1]);
    	return sb.toString();
    }
}