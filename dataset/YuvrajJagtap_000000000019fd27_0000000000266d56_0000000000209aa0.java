import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	
	public static String IMPOSSIBLE = "IMPOSSIBLE";
	public static String POSSIBLE = "POSSIBLE";
	public static String SPACE = " ";
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int numberOfTestCases = Integer.parseInt(s);
		Map<Integer, String> itemEntry = new HashMap<Integer, String>();
		for (int i = 0; i < numberOfTestCases; i++) {
			itemEntry.put(i, in.nextLine());
		}
		String entries[] = null;
		int size,trace;
		int factorial;
		for (Integer key : itemEntry.keySet()) {
			entries = itemEntry.get(key).split(" ");
			size = Integer.parseInt(entries[0]);
			trace = Integer.parseInt(entries[1]);
			factorial = ((size*(size+1))/2);
			if (trace%size == 0 || (factorial == trace && (size != 2))) {
				System.out.println("Case #" + (key + 1) + ": " + POSSIBLE);
				printArray(size, trace/size);
			} else {
				System.out.println("Case #" + (key + 1) + ": " + IMPOSSIBLE);
			}
		}
	}
	
	public static void printArray(int size, int startNumber) {
		int toPrint;
		for (int j = 0 ; j < size; j++) {
			for (int i = 0; i < size ; i++) {
				toPrint = (startNumber + i) % size;
				if (toPrint == 0) {
					toPrint = size;
				}
				if (i == size-1) {
					System.out.print( toPrint);
				} else {
					System.out.print( toPrint + SPACE);
				}
			}
			System.out.println("");
			startNumber = startNumber - 1;
			if (startNumber == 0) {
				startNumber = size;
			}
		}
	}
}
