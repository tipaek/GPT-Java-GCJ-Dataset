import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

private static void printLine(String str) {
		System.out.println(str);
		System.out.flush();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		Integer testCases =in.nextInt();
		
		
		while (testCases > 0) {
			Integer B =in.nextInt();
			char res[]=new char[B];
			Arrays.fill(res, '0');
			in.nextInt();
				for(int i=0;i<10;i++) {
					printLine(String.valueOf(i));
					int value =in.nextInt();
					res[i]=(char) ('0'+value);
				}
				int queries=139;
				while(queries>0) {
					printLine(String.valueOf(1));
					in.nextInt();	
					queries--;
				}
				
			printLine(new String(res));
			testCases--;
		}
	}
}