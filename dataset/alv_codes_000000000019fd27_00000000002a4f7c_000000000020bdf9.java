import java.util.*;
import java.io.*;

public class Solution {

    public static String assignSchedule(int[][] intervals) {
        
    Integer[] start = new Integer[intervals.length];
    Integer[] end = new Integer[intervals.length];
    
    HashMap<Integer, ArrayList<Integer>> schedule = new HashMap<>();

    for (int i = 0; i < intervals.length; i++) {
      ArrayList<Integer> times = new ArrayList<>();
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
      if(schedule.get(start[i]) != null) {
    	  times = schedule.get(start[i]);
      }
      times.add(end[i]);
	  schedule.put(start[i], times);
    }

    Arrays.sort(
        end,
        new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });

    Arrays.sort(
        start,
        new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });

    int startPointer = 0, endPointer = 0;

    HashMap<Character, Integer> currentTask = new HashMap<>();    
    HashMap<Integer, String> finalSchedule = new HashMap<>();
    
    while (startPointer < intervals.length) {
      if (start[startPointer] >= end[endPointer]) {
    	  if(currentTask.get('C') == end[endPointer]) {
        	  currentTask.remove('C');
        	  
          } 
    	  else {
        	  currentTask.remove('J');
        	  
          } 
        
        endPointer += 1;
      }

      if(!currentTask.containsKey('C')) {
    	  currentTask.put('C', schedule.get(start[startPointer]).get(0));
    	  ArrayList<Integer> times = schedule.get(start[startPointer]);
    	  times.remove(0);
    	  schedule.put(start[startPointer], times);
    	  
    	  finalSchedule.put(start[startPointer], "C");
    	  
      }
      else if(!currentTask.containsKey('J')) {
    	  currentTask.put('J', schedule.get(start[startPointer]).get(0));
    	  ArrayList<Integer> times = schedule.get(start[startPointer]);
    	  times.remove(0);
    	  schedule.put(start[startPointer], times);
    	  
    	  finalSchedule.put(start[startPointer]+'J', "J");
      }
      else {
    	  return "IMPOSSIBLE";
      }
      
      startPointer += 1;

    }
    
    String parentSchedule = "";
    
    for(int j=0; j<intervals.length; j++) {
    	if(finalSchedule.get(intervals[j][0]) != null) {
	    	parentSchedule += finalSchedule.get(intervals[j][0]);
	    	finalSchedule.remove(intervals[j][0]);
    	}
    	else {
    		parentSchedule += finalSchedule.get(intervals[j][0]+'J');
	    	finalSchedule.remove(intervals[j][0]+'J');
    	}
  
    }

    return parentSchedule;
  }

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] matrix = new int[n][2];
			for(int j=0; j<n; j++) {
				for(int k=0; k<2; k++) {
				matrix[j][k] = in.nextInt();
				}
			}
	      
			String schedule = assignSchedule(matrix);
			  
			System.out.println("Case #" + i + ": " + schedule);
		}

	}


}
