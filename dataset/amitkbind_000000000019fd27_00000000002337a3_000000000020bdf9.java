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
				arr[i]=new Job(start,end);
			}
			Arrays.sort(arr);
			char CAM='C',JAMES='J';
			char[] JC=new char[2];
			JC[0]=CAM;JC[1]=JAMES;
			int[] free=new int[2];
			int ind=0;
			String res="";
			int i=0;
			while(i<n) {
				if(free[ind]<=arr[i].start) {
					free[ind]=arr[i].end;
					res+=JC[ind];
					i++;
				}else {
					ind=(ind+1)%2;
					if(free[ind]>arr[i].start) {
						res="IMPOSSIBLE";
						break;
					}else {
						free[ind]=arr[i].end;
						res+=JC[ind];
						i++;
					}
				}
			}
			System.out.println("Case #"+tc+": "+res);
		}
			
			
			
			
			//
	}
		
}
class Job implements Comparable<Job>{
		int start,end;
		Job(int s, int e){
			start=s;
			end=e;
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