import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    
	    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	    in.nextLine();
	    //System.out.println("# of test cases:" + t);
	    
	    int rRowCount =0;
	    int []requirements = null;
	    int size = 0;
	    int latice = 0;
	    for (int i = 1; i <= t; ++i) {
  	      	String rowVal = in.nextLine();
  	      	String[] c = rowVal.split(" ");
  	      	requirements = getIntArray(c);
  	      	size = requirements[0];
  	      	latice = requirements[1];
  	      	
  	      	String resultStr = generateLaticeNum(size, latice);
  	      	if(resultStr==null) {
  		    	System.out.println("Case #" + i + ": IMPOSSIBLE" );
  	      		
  	      	} else {
  		    	System.out.println("Case #" + i + ": POSSIBLE" );
  		    	System.out.println(resultStr);
  	      		
  	      	}
	    	
	    }
	  }
	
		private static String generateLaticeNum(int size, int latice) {
			int n = latice / size;
			int remainder = latice % size;
			
			int big = n+1;
			
			int[] numbers = new int[size];
			
			for(int i = 0; i < size; i++) {
				if(remainder > 0) {
					numbers[i] = big;
					remainder--;
				} else 
					numbers[i] = n;
			}
			
			String resultStr = "";
			StringJoiner j = null;
			int seed = 1;
			int displacedNum = 0;
			int chosenNum = 0;
			
			Map<Integer, List<Integer>> colnDict = new HashMap<>();
			List<Integer> currentRow = null;
			for(int row = 0; row < size; row++) {
				j = new StringJoiner(" ");
				currentRow = new ArrayList<>();
				displacedNum = (seed+row)%size == 0?size:(seed+row)%size;
				for(int coln = 0; coln < size; coln++) {
					if(row==coln) {
						if(colnDict.get(coln) == null || !colnDict.get(coln).contains(numbers[row])) {
							chosenNum = numbers[row];
							j.add(""+numbers[row]);
							addToColnDict(coln, colnDict, chosenNum);
							currentRow.add(chosenNum);
						} else {
							return null;
						}
					} else {
						chosenNum = getNumberToPut(seed, size, displacedNum, coln, numbers[row], colnDict, currentRow);

						if(chosenNum == -1) {
							return null;
						} else {
							j.add(""+chosenNum);
							currentRow.add(chosenNum);
							}
					}
					seed+=1;
				}
				seed+=1;
				resultStr +=( j.toString() + "\n");
			}
			return resultStr;
		}
		
		private static int getNumberToPut(int currentSeed, int size, int displacedNum, int coln, int laticeNum,
				Map<Integer, List<Integer>> colnDict, List<Integer>currentRow) {
			int result = -1;
			int chosenNum = 0;
			int generatedNum = currentSeed%size ==0?size:currentSeed%size;
			if(generatedNum == laticeNum) {
				chosenNum = displacedNum;
				if(colnDict.get(coln) == null || !colnDict.get(coln).contains(chosenNum)) {
					addToColnDict(coln, colnDict, chosenNum);
					return chosenNum;
				} else {
					for(int i = currentSeed; i < (currentSeed + size); i++) {
						chosenNum = i%size ==0?size:i%size;
						if(!currentRow.contains(chosenNum) && !colnDict.get(coln).contains(chosenNum)) {
							addToColnDict(coln, colnDict, chosenNum);
							return chosenNum;
						}
					}
					return -1;
				}
			} else {
				if(colnDict.get(coln) == null || !colnDict.get(coln).contains(generatedNum)) {
					addToColnDict(coln, colnDict, generatedNum);
					return generatedNum;
				} else {
					for(int i = currentSeed; i < (currentSeed + size); i++) {
						chosenNum = i%size ==0?size:i%size;
						if(!colnDict.get(coln).contains(chosenNum)) {
							addToColnDict(coln, colnDict, chosenNum);
							return chosenNum;
						}
					}
					return -1;
				}
				
			}
		}
		
		private static void addToColnDict(int coln, Map<Integer, List<Integer>>colnDict, int value) {
			List<Integer> listing = colnDict.get(coln);
			if(listing == null) {
				listing = new ArrayList<>();
			}
			listing.add(value);
			colnDict.put(coln, listing);
		}
		private static int[] getIntArray(String[] e) {
			  int [] arr = new int [e.length];
		      for(int i=0; i<e.length; i++) {
		         arr[i] = Integer.parseInt(e[i]);
		      }
		      return arr;
		  }
}
