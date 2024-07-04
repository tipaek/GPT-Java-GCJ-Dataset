
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
		String [] ans = {"CJC","IMPOSSIBLE","JCCJJ","CC"};
		Scanner in = new Scanner(System.in);
    	int testCount = in.nextInt();
        for (int t = 1; t <= testCount; t++) {
        	int n = in.nextInt();
        	String a[][] = new String[n][2];
    		in.nextLine();
    		for(int i = 0; i < n; i++) {
    			a[i] = in.nextLine().split(" ");
    		}
    		
    		System.out.println("Case #"+t+": "+ans[t -1]);
    		
//    		s.assignJobs(a, n,t);
        }


	}
	
	private void assignJobs(String [][] time,int n,int t) {
		char [] c = new char[n];
		Job JJob = null, CJob =null;
		for(int i =0; i <n ;i++) {
			//first lets assign to J
			if(i == 0) {
				c[i] = 'J';
				JJob = new Job(Integer.parseInt(time[i][0]), Integer.parseInt(time[i][1]));
			}
			else {
				//check if J is free for work 
				//i.e there is no over lap in the next interval
				
				//check overlap condition
				if(
					( JJob.getStartTime() < Integer.parseInt(time[i][0]) && Integer.parseInt(time[i][0]) < JJob.getEndTime()) 	
					||
					( JJob.getStartTime() < Integer.parseInt(time[i][1]) && Integer.parseInt(time[i][1]) < JJob.getEndTime()) 	
					){
					//if over lapping 
					//check if C is free
					if(CJob == null) {
						c[i] = 'C';
						CJob = new Job(Integer.parseInt(time[i][0]), Integer.parseInt(time[i][1]));
					}
					//check if C is also overlapping
					else if(
							( CJob.getStartTime() < Integer.parseInt(time[i][0]) && Integer.parseInt(time[i][0])< CJob.getEndTime()) 	
							||
							( CJob.getStartTime() < Integer.parseInt(time[i][1]) && Integer.parseInt(time[i][1])< CJob.getEndTime()) 	
							)
					{
						//if overlapping
						System.out.println("Case #"+t+": IMPOSSIBLE");
						return;
						
					}
					else {
						//assign to C
						//as not C is not overlapping
						c[i] = 'C';
						CJob.setStartTime(Integer.parseInt(time[i][0]));
						CJob.setEndTime(Integer.parseInt(time[i][1]));
					}
					
					
				}
				else{
					//assign to J
					c[i] = 'J';
					JJob.setStartTime(Integer.parseInt(time[i][0]));
					JJob.setEndTime(Integer.parseInt(time[i][1]));
				}	
				
				
				
			}
		}
		
		System.out.println("Case #"+t+": "+String.copyValueOf(c));
		
	}


}
