import java.util.*;
                 
public class Solution{
     public static void main(String[] args) {		 
     Scanner in = new Scanner(System.in);
     int T = in.nextInt();
     for(int cas = 1; cas <= T; cas++){
		int n = in.nextInt();
		Pair[] time = new Pair[n];
		for(int i = 0; i < n; i++){
			time[i] = new Pair(i, in.nextInt(), in.nextInt());
		}
	
		Arrays.sort(time);
		int curEndTime = 0;
		LinkedList<Integer> list1= new LinkedList<>();
		LinkedList<Integer> list2= new LinkedList<>();
		list1.add(0);
		boolean stop = false;
		
		for(int i = 1; i < n; i++){
			if(time[i].startTime >= time[list1.getLast()].endTime)
				list1.add(i);
			else if(list2.size() == 0 || time[i].startTime >= time[list2.getLast()].endTime)
				list2.add(i);
			else{
				stop = true;
				System.out.println("Case #"+cas+": IMPOSSIBLE");
				break;
			}
		}
		if(stop)
			continue;
		
		char[] ans = new char[n];
		for(int p: list1){
			ans[time[p].idx] = 'C';
		}
		for(int p: list2){
			ans[time[p].idx] = 'J';
		}
		System.out.println("Case #"+cas+": " + String.valueOf(ans));
	 }
	 }
	 
	 static class Pair implements Comparable<Pair>{
		 int idx, startTime, endTime;
		 public Pair(int a, int b, int c){
			 idx = a;
			 startTime = b;
			 endTime = c;
		 }
		 public int compareTo(Pair p){
			 int res = Integer.compare(startTime, p.startTime);
			 if(res == 0)
				 res = Integer.compare(endTime, p.endTime);
			 return res;
		 }
	 }		 
}
			
	 