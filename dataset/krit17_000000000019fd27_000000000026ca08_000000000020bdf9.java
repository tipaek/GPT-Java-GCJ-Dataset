import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static class Event implements Comparable<Event>{
		public int starttime;
		public int endtime;
		Event(int s,int e){
			starttime=s;
			endtime=e;
		}
		@Override
		public int compareTo(Event o) {
			// TODO Auto-generated method stub
			return (this.starttime < o.starttime) ? -1 : (this.starttime>o.starttime)?1:0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			ArrayList<Event> arr=new ArrayList<>(n);
			for(int j=0;j<n;j++){
				int st=s.nextInt();
				int et=s.nextInt();
				arr.add(new Event(st, et));
			}
			Collections.sort(arr);
			Event cval,jval;
			int j=2;
			cval=arr.get(0);
			jval=arr.get(1);
			String ans="CJ";
			while(j<n){
				Event event=arr.get(j);
				if(cval.endtime<=event.starttime){
					ans=ans+'C';
				}
				else if(jval.endtime<=event.starttime){
					ans=ans+'J';
				}
				else{
					ans="IMPOSSIBLE";
					break;
				}
				j++;
			}
			System.out.println("Case #"+(i+1)+": "+ans);
		}

	}

}
