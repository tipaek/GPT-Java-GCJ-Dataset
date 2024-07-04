
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			st = new StringTokenizer(br.readLine());
			
			int N=Integer.parseInt(st.nextToken());
			String[] ans = new String[N];
			boolean impossible = false;
			int C = -1;
			int J = -1;
			time[] times = new time[2*N];
			for(int i=0;i<N;i++){
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				times[2*i]=new time(i,start,false);
				times[2*i+1] = new time(i,end,true);
			}
			Arrays.sort(times, new timeComp());
			
			for(int i=0;i<2*N;i++){
				time curr = times[i];
				if(!curr.isEnd){
					if(C==-1){
						C=curr.index;
						ans[C]="C";
						
					}
					else if(J==-1){
						J=curr.index;
						ans[J]="J";
					}
					else{
						impossible = true;
						break;
					}
				}
				else{
					if(curr.index==C){
						C=-1;
					}
					else{
						J=-1;
					}
				}
			}
			String ans1="";
			if(impossible) ans1="IMPOSSIBLE";
			else{
				for(int i=0;i<N;i++){
					ans1+=ans[i];
				}
			}
			System.out.println("Case #" + test + ": "+ ans1);
		}
	}
}
class time{
	int index;
	int t;
	boolean isEnd;
	
	public time(int i, int t, boolean e){
		index=i;
		this.t=t;
		isEnd = e;
	}
}
class timeComp implements Comparator<time>{
	public int compare(time t1, time t2){
		int temp1 =0, temp2=0;
		if(!t1.isEnd){
			temp1=1;
		}
		if(!t2.isEnd){
			temp2=1;
		}
		return Integer.compare(2*t1.t + temp1, 2*t2.t+temp2);
	}
}