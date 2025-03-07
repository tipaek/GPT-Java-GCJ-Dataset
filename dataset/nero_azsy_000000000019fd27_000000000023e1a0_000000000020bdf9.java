import java.io.*;
import java.util.*;
public class Parenting_Partnering_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int x = 1;
		
		for(int i = 0; i < cases; i++) {
			Stack<Activity> c = new Stack<>();
			Stack<Activity> j = new Stack<>();
			
			StringBuilder sb = new StringBuilder();
			boolean flag = true; 
			
			int act = Integer.parseInt(br.readLine());
			
			Activity[] acts = new Activity[act];
			for(int k = 0; k < act; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int se = Integer.parseInt(st.nextToken());
				int ee = Integer.parseInt(st.nextToken());
				acts[k] = new Activity(se, ee);
			}
			
			Arrays.sort(acts, new Comparator<Activity>() {
				public int compare(Activity a1, Activity a2) {
					return a1.start - a2.start;
				}
			});
			
			for(int l = 0; l < acts.length; l++) {
				if(c.isEmpty()) {
					c.add(acts[l]);
					sb.append('C');
					
				}
				
				else if(c.peek().end <= acts[l].start) {
					c.add(acts[l]);
					sb.append('C');
					
				}else if(c.peek().end > acts[l].start) {
					
					if(j.isEmpty()) {
						j.add(acts[l]);
						sb.append('J');
					
					}else if(j.peek().end <= acts[l].start) {
						j.add(acts[l]);
						sb.append('J');
						
					}else {
						flag = false; 
					}
					
				}
				
			}
			if(flag) {
				System.out.println("Case #" + x + ": " + sb.toString());
			}else {
				System.out.println("Case #" + x + ": IMPOSSIBLE");
			}
			x++;
		}
	}
	
	static class Activity{
		int start;
		int end;
		Activity(int a, int b){
			this.start = a;
			this.end = b;
		}
	}
}
