import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		int T = Integer.parseInt(scanner.nextLine());
		
		for(int i = 1; i<=T; i++){
			
			int N = Integer.parseInt(scanner.nextLine());
			ArrayList<Event> timeline = new ArrayList<Event>();
			
			for(int j = 0; j<N; j++){
				
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				timeline.add(new Event(j,Integer.parseInt(st.nextToken()),true));
				timeline.add(new Event(j,Integer.parseInt(st.nextToken()),false));
			}
			
			Collections.sort(timeline, Event.compareByTime());
			
			int J = -1, C = -1;
			boolean impossible = false;
			
			for(Event e: timeline){
				
				//System.out.println(e.taskId + " " + e.time + " " + e.taskState);
			
				if(e.taskState){
					if(J==-1){
						J = e.taskId;
						e.doneBy = 'J';
					}
					else if(C==-1){
						C = e.taskId;
						e.doneBy = 'C';
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
			
			
			Collections.sort(timeline, Event.compareById());
			StringBuffer answer = new StringBuffer();
			
			for(Event e: timeline){
				if(e.taskState){
					answer.append(e.doneBy);
				}
			}
			
			System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : answer));
			
		}
	}
	
	static class Event implements Comparable<Event>{
		
		char doneBy = ' ';
		int taskId;
		int time;
		boolean taskState;
		
		Event(int id, int t, boolean b){
			taskId = id;
			time = t;
			taskState = b;
		}
		
		static Comparator<Event> compareById(){
			return new Comparator<Event>(){
				public int compare(Solution.Event a, Solution.Event b){
					return (a.taskId < b.taskId ? -1 : 
			            (a.taskId == b.taskId ? 0 : 1));  
				}
			};
		}
		
		static Comparator<Event> compareByTime(){
			return new Comparator<Event>(){
				public int compare(Solution.Event a, Solution.Event b){
					if(a.time < b.time){
						return -1;
					}
					else if(a.time > b.time){
						return 1;
					}
					else{
						if(!a.taskState){
							return -1;
						}
						else if(!b.taskState){
							return 1;
						}
						else{
							return 0;
						}
					}
				}
			};
		}

		@Override
		public int compareTo(Event arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}