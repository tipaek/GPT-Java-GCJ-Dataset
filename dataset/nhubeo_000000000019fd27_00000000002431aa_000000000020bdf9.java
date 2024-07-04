
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class Solution {
	public static String compute(LinkedList<int[]> times) {
		Collections.sort(times, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]>o2[0]?1:(o1[0] == o2[0]?0:-1);  
			}
			
		});
		LinkedList<int[]> taskC = new LinkedList<int[]>();
		LinkedList<int[]> taskJ = new LinkedList<int[]>();
		char[] arr = new char[times.size()];
		
		taskC.add(times.remove(0));
		taskJ.add(times.remove(0));
		
		while (times.size() >0) {
			int[] nextTask = times.remove(0);
			int[] curTaskC = taskC.get(0);
			int[] curTaskJ = taskJ.get(0);
			//System.out.println(nextTask.length + " " + curTaskC[1] + " " + curTaskJ[1]);
			if (nextTask[0] >= curTaskC[1]) {
				
				taskC.add(0,nextTask);
				//result += "C";
			} else if (nextTask[0] >= curTaskJ[1]) {
				taskJ.add(0, nextTask);
				//result += "J";
			} else {
				return "IMPOSSIBLE";
			}
		}
		
		while(taskC.size() >0) {
			//System.out.println(taskC.get(0).length);
			arr[taskC.remove(0)[2]] = 'C';
		}
		while(taskJ.size() >0) {
			arr[taskJ.remove(0)[2]] = 'J';
		}
		return String.valueOf(arr);
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			int tasks = scanner.nextInt();
			LinkedList<int[]> time = new LinkedList<int[]>();
			for (int j = 0; j<tasks; j++) {
				time.add(new int[] {scanner.nextInt(),scanner.nextInt(),j});
			}
		    System.out.println("Case #" + (i+1) + ": " + compute(time));
		}
	}
}
