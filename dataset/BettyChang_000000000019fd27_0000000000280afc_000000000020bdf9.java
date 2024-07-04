import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //test cases
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        // read test cases
		for (int i = 1; i <= t; ++i) {
			int size = in.nextInt();
			ArrayList<int[]> activities = new ArrayList<>();
			//read activity
			for(int r = 0; r < size; r++) {
				int[] input = new int[3];
				for(int c = 0; c < 2; c++) {
					input[c] = in.nextInt();
				}
				input[2] = r;
				activities.add(input);
			}
			
			//sort arraylist
			quickSort(activities, 0, activities.size()-1);
			
			//check conflict & assign
			String[] output = new String[size];
			int lastC = -1;
			int lastJ = -1;
			boolean done = false;
			for(int currIndex = 0; !done && currIndex<size; currIndex++) {
				if(currIndex==0) {
					output[activities.get(currIndex)[2]] = "J";
					lastJ = 0;
				}else {
					//check conflict
					boolean conflictJ = activities.get(currIndex)[0] < activities.get(lastJ)[1];
					boolean conflictC = false;
					if(lastC != -1) {
						conflictC = activities.get(currIndex)[0] < activities.get(lastC)[1];
					}
					
					if(conflictJ && conflictC) {
						//impossible
						done = true;
						output = null;
					}else {
						if(!conflictJ) {
							output[activities.get(currIndex)[2]] = "J";
							lastJ = currIndex;
						}else if(!conflictC) {
							output[activities.get(currIndex)[2]] = "C";
							lastC = currIndex;
						}
					}
				}
			}
			System.out.print("Case #" + i + ": ");
			if(output == null) {
				System.out.print("IMPOSSIBLE");
			}else {
				for(int j = 0; j<output.length; j++) {
					System.out.print(output[j]);
				}
			}
			System.out.println();
			/*for(int j = 0; j<activities.size(); j++) {
				for(int k = 0; k<activities.get(j).length; k++)
					System.out.print(activities.get(j)[k] + " ");
				System.out.println();
			}*/
			
		}
	}

	private static void quickSort(ArrayList<int[]> activities, int low, int high) {
		if(low<high) {
			int pi = partition(activities, low, high);
			quickSort(activities, low, pi-1);
			quickSort(activities, pi+1, high);
		}
		
	}

	private static int partition(ArrayList<int[]> activities, int low, int high) {
		int[] pivot = activities.get(high);
		int i = low -1;
		for (int j = low; j <= high- 1; j++)
	    {
	        // If current element is smaller than the pivot
	        if (activities.get(j)[0] < pivot[0])
	        {
	            i++;    // increment index of smaller element
	            int[] swap = activities.get(i);
	            activities.set(i, activities.get(j));
	            activities.set(j, swap);
	        }
	    }
		int[] swap = activities.get(i+1);
		activities.set(i+1, activities.get(high));
		activities.set(high, swap);
	    return (i + 1);
	}

}
