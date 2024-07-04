import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
//	private static int[] input, inputArray;
	private static String inputString, outputString;
	private static int cases;
	
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
		inputString = line;		
	}
	
	private static void work() {
//		Stack<Integer> stack = new Stack<Integer>();
		int currentVal = 0;
		outputString = "";
		
		for (int i = 0; i < inputString.length(); i++) {
			if (value(i) > currentVal) {
				increase(value(i) - currentVal);
				currentVal = value(i);
				outputString += inputString.charAt(i);
			}
			else {
				decrease(Math.abs(value(i) - currentVal));
				currentVal = value(i);
				outputString += inputString.charAt(i);
			}
		}
		decrease(Math.abs(0 - currentVal));
	}
	
	private static int value(int index) {
		return Character.getNumericValue(inputString.charAt(index));
	}
	
	private static void increase(int num) {
		for (int i = 0; i < num; i++) {
			outputString += '(';
		}
	}
	
	private static void decrease(int num) {
		for (int i = 0; i < num; i++) {
			outputString += ')';
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
