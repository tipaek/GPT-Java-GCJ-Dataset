import java.util.*;
import java.io.*;
public class Solution {
// Generic function to check for duplicates in an array
private static <T> boolean checkForDuplicates(int[] array)
{
	// sort the array in natural or reverse order
	Arrays.sort(array);

	// prev stores the previous element for current element in the array
	int prev = -1;

	// do for every element in the array
	for (int e : array)
	{
		// if two consecutive elements is found to be equal,
		// duplicate is found
		if (e==prev)
			return true;

		// set current element as previous
		prev = e;
	}

	// no duplicate found
	return false;
}
 public static void main(String[] args) {
  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int t = in .nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
  for (int i = 1; i <= t; ++i) {
   int size = in .nextInt();
   int trace = 0;
   int rr = 0;
   int rc = 0;
   int[][] rows = new int[size][size];
   int[][] cols = new int[size][size];
   for (int row = 0; row < size; row++) {

    for (int col = 0; col < size; col++) {
     int ce = in .nextInt();
     rows[row][col] = ce;
     cols[col][row] = ce;
     if (row == col) trace += ce;
    }
    rr+=checkForDuplicates(rows[row])?1:0;
    
   }
   for(int col=0;col<size;col++){
       rc+=checkForDuplicates(cols[col])?1:0;
   }
   System.out.println("Case #" +i+": "+ trace + " " + rr + " " + rc);
  }
 }
}