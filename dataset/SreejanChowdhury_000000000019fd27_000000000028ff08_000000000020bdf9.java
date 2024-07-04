import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public class Job{
		int startTime,endTime;
		
		Job(int startTime,int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		
		
	}
	public static void main(String[] args) {
		
		Solution s = new Solution();
		Scanner in = new Scanner(System.in);
    	int testCount = in.nextInt();
        for (int t = 1; t <= testCount; t++) {
        	int n = in.nextInt();
        	String a[][] = new String[n][2];
    		in.nextLine();
    		for(int i = 0; i < n; i++) {
    			a[i] = in.nextLine().split(" ");
    		}
    		
    		
    		s.assignJobs(a, n,t);
        }


	}
	
	private void assignJobs(String [][] time,int n,int t) {
		//form a priority queue so that it sorts based on starttime
		Comparator<Job> nameSorter = Comparator.comparing(Job::getStartTime);
		 
		PriorityQueue<Job> pq = new PriorityQueue<>( nameSorter );
		for(int i =0; i <n ;i++) {
			pq.add(new Job(Integer.parseInt(time[i][0]), Integer.parseInt(time[i][1])));
		}
		List<String> c = new ArrayList<String>();
		List<Job> JJobs= new ArrayList<Job>(),CJobs = new ArrayList<Job>();
		while(true) {
			Job j = pq.poll();
			if(j == null) break;
			if(JJobs.size() == 0) {
//				c.add("J");
				JJobs.add(j);
			}
			else {
				//j is not free
				if(isOverLap(JJobs, j.getStartTime(), j.getEndTime())) {
					
					//c's first assignment
					if(CJobs.size() == 0) {
//						c.add("C");
						CJobs.add(j);
					}
					//c is not free
					else if(isOverLap(CJobs,j.getStartTime(), j.getEndTime())) {
						System.out.println("Case #"+t+": IMPOSSIBLE");
						return;
					}
					//c is free
					else {
//						c.add("C");
						CJobs.add(j);
					}
				}
				//j is free
				else {
//					c.add("J");
					JJobs.add(j);
				}
			}
			
			j= null;
		}
		
		//now assign jobs according to the slots
		for(int i = 0 ; i <n ;i++) {
			Job jJ = isPresent(JJobs, Integer.parseInt(time[i][0]),Integer.parseInt(time[i][1]) );
			Job jC = isPresent(CJobs, Integer.parseInt(time[i][0]),Integer.parseInt(time[i][1]) );
			if(jJ != null) {
				c.add("J");
				JJobs.remove(jJ);
			}else if(jC != null) {
				c.add("C");
				JJobs.remove(jC);
			}
		}
		System.out.println("Case #"+t+": "+ (c.size() == n ? String.join("", c) : "IMPOSSIBLE"));
		
	}
	
	private static Job isPresent(List<Job> jobs,int startTime,int endTime) {
		
		for(Job j: jobs) {
			if(startTime == j.getStartTime() 
					&& endTime == j.getEndTime() )
				return j;
		}
		return null;
		
	}
	
	private static boolean isOverLap(List<Job> jobs,int startTime,int endTime) {
		
		boolean flag = true;
		for(Job j : jobs) {
			if( 
					(startTime >= j.getEndTime())
					||
					(endTime <= j.getStartTime())
					)
				{
				flag = false;
				}
			else {
				flag = true;
				break;
			}
		}
		
		return flag;
	}


}
