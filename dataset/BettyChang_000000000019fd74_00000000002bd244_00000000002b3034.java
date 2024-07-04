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
			ArrayList<String> input = new ArrayList<String>();
			for(int j = 0; j<size; j++) {
				input.add(in.next());
			}
			boolean rejectCase = false;
			for(int j = 0; j<size; j++) {
				if(input.get(j).charAt(0) != '*') {
					rejectCase = true;
				}
			}
			if(rejectCase) {
				System.out.println("Case #" + i + ": *");
			}else {
				//sort by length
				quickSort(input, 0, input.size()-1);
				boolean compatible = true;
				for(int j = input.size()-1; j>0; j--) {
					//check if previous one is substring of the next
					String curr = input.get(j).substring(1);
					String prev = input.get(j-1).substring(1);
					if(!curr.contains(prev)) {
						compatible = false;
					}
				}
				if(compatible) {
					System.out.println("Case #" + i + ": " + input.get(input.size()-1).substring(1));
				}else {
					System.out.println("Case #" + i + ": *");
				}
			}
			
		}
		
		
		

	}

	private static void quickSort(ArrayList<String> input, int low, int high) {
		if(low<high) {
			int pi = partition(input, low, high);
			quickSort(input, low, pi-1);
			quickSort(input, pi+1, high);
		}
		
	}

	private static int partition(ArrayList<String> input, int low, int high) {
		String pivot = input.get(high);
		int i = low -1;
		for (int j = low; j <= high- 1; j++)
	    {
	        // If current element is smaller than the pivot
	        if (input.get(j).length() < pivot.length())
	        {
	            i++;    // increment index of smaller element
	            String swap = input.get(i);
	            input.set(i, input.get(j));
	            input.set(j, swap);
	        }
	    }
		String swap = input.get(i+1);
		input.set(i+1, input.get(high));
		input.set(high, swap);
	    return (i + 1);
	}

}