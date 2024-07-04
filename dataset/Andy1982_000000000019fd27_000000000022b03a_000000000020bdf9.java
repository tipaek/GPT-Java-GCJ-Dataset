

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

 class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int noOfTestCases = input.nextInt();
		List<List<String>> listOfInput  = new ArrayList<>();
		for(int i=0;i<noOfTestCases;i++) {
			int dimesion = input.nextInt();
			 input.nextLine();
			List<String> list = new ArrayList<>();
			for(int j=0;j<dimesion;j++) {
				String str = input.nextLine();
				list.add(str);
			}
			listOfInput.add(list);
		}
		
		int counter=1;
		for(List<String> list:listOfInput) {
			System.out.flush();
			System.out.println("Case #"+counter+": "+findSchedule(list));
			System.out.flush();
			counter++;
		}
		
		
	}

private static String findSchedule(List<String> list) {
	//	System.out.println("Sample Input"+list);
		 int[][] schedule = new int[list.size()][2];
		 int[][] schedule1 = new int[list.size()][2];
		 
		 char[] parents= {'C','J'};
		 
		 Map<Integer,Character> map = new HashMap<>();
		 for(int i=0;i<list.size();i++) {
			 String[] arr = list.get(i).split(" ");
			 schedule[i][0]=Integer.valueOf(arr[0]);
			 schedule[i][1]=Integer.valueOf(arr[1]);
			 schedule1[i][0]=Integer.valueOf(arr[0]);
			 schedule1[i][1]=Integer.valueOf(arr[1]);
		
		 }
		 
		 
		 Arrays.sort(schedule,(x,y)->{
			 return x[0]-y[0];
		 });
		 
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->{
			return x-y;
			});
		StringBuilder sb = new StringBuilder();
		pq.add(schedule[0][1]);
		int turn=0;
		
		map.put(schedule[0][1],'C');
		//sb.append(parents[turn]);
		for(int i=1;i<schedule.length;i++) {
			if(schedule[i][0]>=pq.peek()) {
				int value=pq.poll();
				 char ch =map.get(value);
				// map.remove(value);
				 pq.add(schedule[i][1]);
				 map.put(schedule[i][1],ch);
				 //sb.append(ch);
			} else {
				if(pq.size()>=2) {
					return "IMPOSSIBLE"; 
				}
				turn =1-turn;
				pq.add(schedule[i][1]);
				map.put(schedule[i][1],parents[turn]);
				//sb.append(parents[turn]);
			}
			
		}
		 //System.out.println(map);
		 for(int i=0;i<schedule1.length;i++) {
			 char ch=map.get(schedule1[i][1]);
			 sb.append(ch);
		 }
		// System.out.println("Sample output"+sb.toString());
		return sb.toString();
		
	}
	
	
}
