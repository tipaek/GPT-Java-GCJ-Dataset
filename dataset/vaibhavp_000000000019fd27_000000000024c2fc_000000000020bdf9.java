import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	private static int[] startArray, endArray;
	private static char[] jobArray;
	private static int activities, cases, max;
	private static String outputString;
	
	private static BufferedReader br;
    private static PrintWriter pw;
	
	private static void setIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }
	
	private static void input(int numCase) throws IOException {
		String line;
		StringTokenizer data;
		
		line = br.readLine();
		data = new StringTokenizer(line);
		
		activities = Integer.parseInt(data.nextToken());
		startArray = new int[activities];
		endArray = new int[activities];
		
		int[] countArray = new int[1440];
		for (int i = 0; i < 1440; i++) countArray[i] = 0;
		
		jobArray = new char[1440];
		for (int i = 0; i < 1440; i++) jobArray[i] = 'N';
		
		outputString = "";
		
		for (int i = 0; i < activities; i++) {
			line = br.readLine();
			data = new StringTokenizer(line);
			
			startArray[i] = Integer.parseInt(data.nextToken());
			endArray[i] = Integer.parseInt(data.nextToken());
			
			for (int j = startArray[i]; j < endArray[i]; j++) {
				countArray[j]++;
				if (countArray[j] > 2) {
					outputString = "IMPOSSIBLE";
					return;
				}
			}
			
			for (int j = startArray[i]; j < endArray[i]; j++) {
				if (jobArray[j] == 'N') jobArray[j] = 'J';
				else {
					if (jobArray[j] == 'J') jobArray[j] = 'B'; 
				}
			}
		}
	}
	
	private static void work() {
		if (outputString.equals("IMPOSSIBLE") == true) return;
		for (int i = 0; i < startArray.length; i++) {
			if (jobArray[startArray[i]] == 'J') outputString += 'J';
			else {
				outputString += 'C';
				for (int j = startArray[i]; j < endArray[i]; j++) {
					if (jobArray[j] == 'B') jobArray[j] = 'J';
				}
			}
		}
	}
	
	private static void output(int caseNum) throws IOException {
		pw.println("Case #" + caseNum + ": " + outputString);
	}
	
	public static void main(String[] args) throws IOException {
		setIO();
		
		cases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= cases; i++) {
        	input(i);
            work();
            output(i);
        }

        br.close();
        pw.close();
	}
}
