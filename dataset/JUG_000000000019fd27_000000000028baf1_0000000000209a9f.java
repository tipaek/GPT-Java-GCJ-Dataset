import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class Solution {
	private static class ReadWrite {
		BufferedReader in;
		PrintWriter out;
		
		public ReadWrite() {
			in = new BufferedReader(new InputStreamReader(System.in));
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("file.out")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ReadWrite(String fileName, Boolean isInput) {
			try {
				if (isInput) {
					in = new BufferedReader(new FileReader(fileName));
				} else {
					in = new BufferedReader(new InputStreamReader(System.in));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (isInput) {
					out = new PrintWriter(new BufferedWriter(new FileWriter("file.out")));	
				} else {
					out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ReadWrite(String inputFileName, String outputFileName) {
			try {
				in = new BufferedReader(new FileReader(inputFileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter(outputFileName)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public BufferedReader getIn() {
			return this.in;
		}
		
		public PrintWriter getOut() {
			return this.out;
		}
	}
	public static String solve(String input, ReadWrite rw) {
		String[] inputArr = input.split("");
		Stack<Integer> numStack = new Stack<Integer>();
		String result = "";
		for (int i = inputArr.length - 1; i >= 0; i--) {
			numStack.push(Integer.valueOf(inputArr[i]));
		}
		
		int prev = 0;
		while (!numStack.isEmpty()) {
			Integer num = numStack.pop();
			Integer numParethesis = num - prev;
			// setup left parenthesis
			for (int i = 0; i < numParethesis; i++) {
				result += "(";
			}

			// add current number 
			result += num;
			
			// get next number if it is the same
			Integer next = numStack.size() > 0 ? numStack.peek() : null;
			while (num == next) {
				num = numStack.pop();
				next = numStack.size() > 0 ? numStack.peek() : null;
				result += num;
			}
			
			// right parenthesis
			if (next != null && num > next) {
				int closeParenthesis = num - next;
				for (int i = 0; i < closeParenthesis; i++) {
					result += ")";
				}
				numParethesis = numParethesis - closeParenthesis;
				num = numStack.pop();
				result += num;
			} else if (next != null && next != num && num < next) {
				prev = num;
				continue;
			} else if (next == null) {
				numParethesis = num;
			}

			for (int i = 0; i < numParethesis; i++) {
				result += ")";
			}
			
			prev = num;
		}
		return result;
	}

	public static void main(String[] arg) throws NumberFormatException, IOException {
		Boolean isDebug = false;
		ReadWrite rw = isDebug ? new ReadWrite("input.in", true) : new ReadWrite();
    	int numCases = Integer.valueOf(rw.getIn().readLine());
    	for (int i = 1; i <= numCases; i++) {
    		String output = "Case #" + i + ": " + solve(rw.getIn().readLine(), rw).toString();
    		System.out.println(output);
    		rw.getOut().println(output);
    	}
    	rw.getOut().close();
	}
}