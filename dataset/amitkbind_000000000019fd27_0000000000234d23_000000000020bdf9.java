import java.util.Arrays;
import java.util.Scanner;

public class Solution{
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int tc=1;tc<=t;tc++ ) {
			int n=sc.nextInt();
			Job[] arr=new Job[n];
			for(int i=0;i<n;i++) {
				int start=sc.nextInt();
				int end=sc.nextInt();
				arr[i]=new Job(start,end,i);
			}
			Arrays.sort(arr);
			char[] worker=new char[n];
			char CAM='C',JAMES='J';
			char[] JC=new char[2];
			JC[0]=CAM;JC[1]=JAMES;
			int[] free=new int[2];
			int ind=0;
			String rest="";
			int i=0;
			while(i<n) {
				if(free[ind]<=arr[i].start) {
					free[ind]=arr[i].end;
					worker[i]=JC[ind];
					i++;
				}else {
					ind=(ind+1)%2;
					if(free[ind]>arr[i].start) {
						rest="IMPOSSIBLE";
						break;
					}else {
						free[ind]=arr[i].end;
						worker[i]=JC[ind];
						i++;
					}
				}
			}
			if(rest.equals("IMPOSSIBLE")) {
				System.out.println("Case #"+tc+": "+rest);
				continue;
			}
			char[] res=new char[n];
			for(i=0;i<n;i++) {
				int index=arr[i].ind;
				res[index]=worker[i];
				
			}
			System.out.println("Case #"+tc+": "+String.valueOf(res));
		}
			
			
			
			
			//
	}
		
}
class Job implements Comparable<Job>{
		int start,end,ind;
		Job(int s, int e,int i){
			start=s;
			end=e;
			ind=i;
		}
		public int compareTo(Job job) {
			if(this.start<job.start) {
				return -1;
			}
			if(this.start>job.start) {
				return 1;
			}
			if(this.end<job.end) {
				return -1;
			}
			if(this.end>job.end) {
				return 1;
			}
			return 0;
		}
		
	
}