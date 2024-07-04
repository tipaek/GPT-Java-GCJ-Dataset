import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static int[][] mergeSort(int[][] items,int index){
		//split
		int[][] first = new int[items.length/2][2];
		int[][] second =  new int[items.length - first.length][2];
		if (items.length ==1){
			return items;
		}
		//populate
		int firstIndex = 0;
		int secondIndex = 0;
		for (firstIndex = 0; firstIndex < first.length; firstIndex++){
			first[firstIndex] = items[firstIndex];
		}
		for (secondIndex = 0; secondIndex < second.length; secondIndex++){
			second[secondIndex] = items[secondIndex + firstIndex];
		}
		//showArray(first);
		//showArray(second);
			
		first = mergeSort(first, index);
		second = mergeSort(second, index);
		return merge(first,second, index);
	}
	public static int[][] merge(int[][] first,int[][] second,int index){
		int[][] items = new int[first.length+second.length][2];
		int itemIndex = 0;
		int firstIndex = 0;
		int secondIndex = 0;
		int mergeIndex = first.length - 1;
		while ((firstIndex < first.length) && (secondIndex < second.length)){
			if (first[firstIndex][index] < second[secondIndex][index]){
				items[itemIndex] = first[firstIndex];
				firstIndex++;
			}
			else {
				items[itemIndex] = second[secondIndex];
				secondIndex++;
			}
			itemIndex++;
		}
		if (firstIndex != first.length){ //means elements in first still remain
			for(;firstIndex < first.length;firstIndex++){
				items[itemIndex] = first[firstIndex];
				itemIndex++;
			}
		}
		if (secondIndex != second.length){ //means elements in second still remain
			for(;secondIndex < second.length;secondIndex++){
				items[itemIndex] = second[secondIndex];
				itemIndex++;
			}
		}
		return items;
	}
	
	
	public static String findSchedule(int[][] matrix) {
		matrix = mergeSort(matrix, 1);
		matrix = mergeSort(matrix, 0);
		String retval = "";
		int JFreeTime = 0;
		int CFreeTime = 0;
		boolean impossible = false;
		for (int i = 0; i < matrix.length; i++) {
			int thisStartTime = matrix[i][0];
			int thisEndTime = matrix[i][1];
			if (thisStartTime >= JFreeTime) {
				//assign to J
				retval = retval + "J";
				JFreeTime = thisEndTime;
			}
			else if (thisStartTime >= CFreeTime) {
				//assign to C
				retval = retval + "C";
				CFreeTime = thisEndTime;
			}
			else {
				retval = "IMPOSSIBLE";
				break;
			}
		}
		
		return retval;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= numCases; ++i) {
	      int jobSize = in.nextInt();
	      int thisMatrix[][] = new int[jobSize][2];
	      for (int j = 0; j < jobSize; j++) {
	    	  int thisValue = in.nextInt();
	    	  thisMatrix[j][0] = thisValue;
	    	  thisValue = in.nextInt();
	    	  thisMatrix[j][1] = thisValue;
	      }
	      System.out.println("Case #" + i + ": " + findSchedule(thisMatrix));
	    }
	    in.close();

	}

}