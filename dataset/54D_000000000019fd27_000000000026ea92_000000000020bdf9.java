import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {
	
	static boolean checkCalender(int[] calender,int start,int end) {
		for(int i=start;i<end;i++) {
			if(calender[i]==1) {
				return false;
			}
		}
		return true;
	}
	
	static int[] fillCalender(int[] calender,int start,int end) {
		for(int i=start;i<end;i++) {
			calender[i]=1;
		}
		return calender;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int c=0;c<t;c++) { // for each case
			int[] C = new int[1440];
			int[] J = new int[1440];
			String order = "";
			boolean impossible = false;
			int e = sc.nextInt();
			HashMap<Integer,int[]> eventTimes = new HashMap<Integer,int[]>();
			HashMap<Integer,String> eventAssignments = new LinkedHashMap<Integer,String>();
			for(int i=0;i<e;i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int[] times = {start,end};
				eventTimes.put(i,times);
				eventAssignments.put(i,"X");
			}
			List<Map.Entry<Integer,int[]>> eventTimesEntries = new LinkedList<Map.Entry<Integer,int[]>>(eventTimes.entrySet()); 
	        Collections.sort(eventTimesEntries, new Comparator<Map.Entry<Integer,int[]>>() { 
	            public int compare(Map.Entry<Integer,int[]> event1,Map.Entry<Integer,int[]> event2) {
	            	int[] times1 = event1.getValue();
	            	int[] times2 = event2.getValue();
	            	if(times1[0]==times2[0]) {
	            		return (times1[1]>times2[1]?1:-1);
	            	}
	                return (times1[0]>times2[0]?1:-1);
	            }
	        });
	        HashMap<Integer,int[]> eventTimesSorted = new LinkedHashMap<Integer,int[]>();
	        for(Map.Entry<Integer,int[]> entry:eventTimesEntries) { 
	            eventTimesSorted.put(entry.getKey(),entry.getValue()); 
	        }
	        for(int eventID:eventTimesSorted.keySet()) {
	        	if(impossible==false) {
		        	int[] times = eventTimes.get(eventID);
		        	int start = times[0];
		        	int end = times[1];
					if(checkCalender(C,start,end)) {
						C = fillCalender(C,start,end);
						eventAssignments.put(eventID,"C");
					}else if(checkCalender(J,start,end)) {
						J = fillCalender(J,start,end);
						eventAssignments.put(eventID,"J");
					}else {
						impossible=true;
					}
				}
	        }
	        if(impossible==true) {
	        	order = "IMPOSSIBLE";
	        }else {
	        	for(Entry<Integer,String> a:eventAssignments.entrySet()) {
	        		order = order + a.getValue();
	        	}
	        }
			System.out.printf("Case #%d: %s\n",c+1,order);
		}
		sc.close();
	}
	
	
}
