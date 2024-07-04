import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
			for(int i = 1; i<= t; i++) {
				int actNum = in.nextInt();
				String output = "";
				ArrayList<Integer> cActs = new ArrayList<Integer>();
				ArrayList<Integer> jActs = new ArrayList<Integer>();
				int[] startTimes = new int[actNum];
				int[] endTimes = new int[actNum];
				HashMap<Integer, Integer> endTimesToIndex = new HashMap<Integer, Integer>();
				HashMap<Integer, Integer> indexToendTimes = new HashMap<Integer, Integer>();
				for(int j = 0; j < actNum; j++) {
					int startTime = in.nextInt(); int endTime = in.nextInt();
					startTimes[j] = startTime;
					endTimes[j] = endTime;
					endTimesToIndex.put(endTime, j);
					indexToendTimes.put(j, endTime);
				}
				
				sort(endTimes, 0 ,actNum-1);
				for(int j = 0; j < actNum; j++) {
					int curActindex = endTimesToIndex.get(endTimes[j]);
					if(cActs.isEmpty()) {
						cActs.add(curActindex);
					}else {
						int lastActivity = cActs.get(cActs.size()-1);
						if(indexToendTimes.get(lastActivity)<=startTimes[curActindex]) {
							cActs.add(curActindex);
						}else if(jActs.isEmpty()) {
							jActs.add(curActindex);
						}else {
							lastActivity = jActs.get(jActs.size()-1);
							if(indexToendTimes.get(lastActivity)<=startTimes[curActindex]) {
								jActs.add(curActindex);
							}else {
								output = "IMPOSSIBLE";
								break;
							}
							
						}
					}
					
					
				}
				if(!output.equals("IMPOSSIBLE")) {
					for(int j = 0; j < actNum; j++) {
						if(cActs.contains(j))
							output += "C";
						else {
							output += "J";
						}
					}
				}
				System.out.println("Case #" + i + ": " + output );
					
			}
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
	}
	
	static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
}
