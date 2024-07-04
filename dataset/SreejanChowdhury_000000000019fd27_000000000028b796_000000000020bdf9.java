
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
//		char [] c = new char[n];
		List<String> c = new ArrayList<String>();
		List<Job> JJobs= new ArrayList<Job>(),CJobs = new ArrayList<Job>();
		for(int i =0; i <n ;i++) {
			//first lets assign to J
			if(i == 0) {
				c.add("J");
				JJobs.add(new Job(Integer.parseInt(time[i][0]), Integer.parseInt(time[i][1])));
			}
			else {
				//check if J is free for work 
				//i.e there is no over lap in the next interval
				
				//check overlap condition
				if(
					isOverLap(JJobs,Integer.parseInt(time[i][0]),Integer.parseInt(time[i][1]))
						){
					//if over lapping 
					//check if C is free
					if(CJobs.size() == 0) {
						c.add("C");
						CJobs.add(new Job(Integer.parseInt(time[i][0]), Integer.parseInt(time[i][1])));
					}
					//check if C is also overlapping
					else if( isOverLap(CJobs,Integer.parseInt(time[i][0]),Integer.parseInt(time[i][1])) )
					{
						//if overlapping
						System.out.println("Case #"+t+": IMPOSSIBLE");
						return;
						
					}
					else {
						//assign to C
						//as not C is not overlapping
						c.add("C");
						CJobs.add(new Job(Integer.parseInt(time[i][0]), Integer.parseInt(time[i][1])));
					}
					
					
				}
				else{
					//assign to J
					c.add("J");
					JJobs.add(new Job(Integer.parseInt(time[i][0]), Integer.parseInt(time[i][1])));
				}	
				
				
				
			}
		}
		
		System.out.println("Case #"+t+": "+ (c.size() == n ? String.join("", c) : "IMPOSSIBLE"));
		
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
