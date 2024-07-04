import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
	
		public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int numCases = Integer.parseInt(in.nextLine());
		    String[] res = new String[numCases];
		    for(int i = 0; i < numCases; i++) {
		    	int numActivities = in.nextInt();
		    	int[] p = new int[1440];
		    	String[] tasks = new String[1440];
		    	String[] assignment = new String[numActivities];
		    	for(int j=0; j<1440; j++) {
		    		tasks[j]="";
		    	}
		    	int[] p1 = new int[1440];
		    	int[] p2 = new int[1440];
		    	
		    	int[] start = new int[numActivities];
		    	int[] end = new int[numActivities];
		    	TreeMap<Integer, Integer> sorted = new TreeMap<>();
		    	
		    	for(int j = 0; j < numActivities; j++) {
		    		assignment[j] = "";
		    		start[j] = in.nextInt();
		    		end[j] = in.nextInt();
		    		sorted.put(start[j], j);
		    	}

		    	ArrayList<Integer> list = new ArrayList<>();
		    	for(int a : sorted.values()) {
		    		list.add(a);
		    	}
		    	
		    	int[] sortedStart = new int[numActivities];
		    	int[] sortedEnd = new int[numActivities];
		    	
		    	int count = 0; 
		    	for(int a : sorted.values()) {
		    		sortedStart[count]=start[a];
		    		sortedEnd[count]=end[a];
		    		count++;
		    	}
		    
		    	String result = "";
		    	for(int j = 0; j < numActivities; j++) {
		    		if(!change(p, tasks, start[j], end[j], j)) {
		    			result = "IMPOSSIBLE";
		    		} 
		    		/*if(!result.equals("IMPOSSIBLE")) {
			    		if(isEmpty(p1, sortedStart[j], sortedEnd[j])) {
			    			change(p1, sortedStart[j], sortedEnd[j]);
			    			result+="C";
			    		} else if (isEmpty(p2, sortedStart[j], sortedEnd[j])) {
			    			change(p2, sortedStart[j], sortedEnd[j]);
			    			result+="J";
			    		} else {
			    			result = "IMPOSSIBLE";
			    		}
		    		}*/
		    		
		    	}
		    	if(!result.equals("IMPOSSIBLE")) {
			    	for(int j=0; j<p.length; j++) {
			    		if(!tasks[j].equals("")) {
				    		String[] st = tasks[j].split("\\s");
				    		if(st.length==1) {
				    			int next = Integer.parseInt(st[0]);
				    			if(assignment[next].equals("")) {
				    				assignment[next]="C";
				    			}
				    		} if (st.length==2) {
				    			int first = Integer.parseInt(st[0]);
				    			int second = Integer.parseInt(st[1]);
				    			if(assignment[first].equals("") && assignment[second].equals("")) {
				    				assignment[first]="C";
				    				assignment[second]="J";
				    			}
				    			else if(assignment[first].equals("C") && assignment[second].equals("")) {
				    				assignment[second]="J";
				    			}
				    			else if(assignment[first].equals("J") && assignment[second].equals("")) {
				    				assignment[second]="C";
				    			}
				    			else if(assignment[second].equals("C") && assignment[first].equals("")) {
				    				assignment[first]="J";
				    			}
				    			else if(assignment[second].equals("J") && assignment[first].equals("")) {
				    				assignment[first]="C";
				    			}
				    			
				    		}
			    		}
			    	}
		    	}
		    	printArray(assignment);
		    	String finalResult = "";
		    	if(!result.equals("IMPOSSIBLE")) {
			    	for(int j = 0; j < numActivities; j++) {
			    		finalResult +=assignment[j];
			    	}
			    	res[i] = finalResult;
		    	} else {
		    		res[i] = "IMPOSSIBLE";
		    	}
		    	
		    } 
		    
		    for(int i = 0; i < numCases; i++) {
		    	System.out.println("Case #"+ (i+1) +": "+res[i]);
		    }
		    in.close();
		    
		}

		
		public static boolean isEmpty(int[] arr, int s, int e) {
			for(int i=s; i<e; i++) {
				if(arr[i]>0) {
					return false;
				}
			}
			return true;
		}
		
		public static boolean change(int[] arr, String[] tasks, int s, int e, int val) {
			for(int i=s; i<e; i++) {
				arr[i] += 1;
				tasks[i] += val + " ";
				if(arr[i]>2) {
		    		return false;
		    	}
			}
			
			return true;
		}

	
	public static void printArray(int[] sortedStart) {
		for(int i=0; i<sortedStart.length; i++) {
			System.out.print(sortedStart[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(Object[] sortedStart) {
		for(int i=0; i<sortedStart.length; i++) {
			System.out.print("("+ sortedStart[i]+ ")" + " ");
		}
		System.out.println();
	}
	
}
