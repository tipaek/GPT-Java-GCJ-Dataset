import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		int T = Integer.parseInt(scanner.nextLine());
		
		for(int i = 1; i<=T; i++){
			
			int N = Integer.parseInt(scanner.nextLine());
			ArrayList<Event> timeline = new ArrayList<Event>();
			Solution A = new Solution();
			
			for(int j = 0; j<N; j++){
				
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				timeline.add(A.new Event(j,Integer.parseInt(st.nextToken()),true));
				timeline.add(A.new Event(j,Integer.parseInt(st.nextToken()),false));
			}
			
			Collections.sort(timeline);
			
			int J = -1, C = -1;
			StringBuffer answer = new StringBuffer();
			boolean impossible = false;
			
			for(Event e: timeline){
				
				//System.out.println(e.taskId + " " + e.time + " " + e.taskState);
			
				if(e.taskState){
					if(J==-1){
						J = e.taskId;
						//System.out.println(" J");
						answer.append('J');
					}
					else if(C==-1){
						C = e.taskId;
						//System.out.println("C ");
						answer.append('C');
					}
					else{
						impossible = true;
						break;
					}
				}
				else{
					if(J==e.taskId){
						J=-1;
					}
					if(C==e.taskId){
						C=-1;
					}
				}
				
				
			}
			System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : answer));
			
		}
	}
	
	class Event implements Comparable<Event>{
		
		int taskId;
		int time;
		boolean taskState;
		
		Event(int id, int t, boolean b){
			taskId = id;
			time = t;
			taskState = b;
		}
		
		@Override     
		  public int compareTo(Event other) {          
		    return (this.time < other.time ? -1 : 
		            (time == other.time ? 0 : 1));     
		  }
	}
}