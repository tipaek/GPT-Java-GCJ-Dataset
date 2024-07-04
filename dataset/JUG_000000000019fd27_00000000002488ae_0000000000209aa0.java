import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
	private static class ReadWrite {
		BufferedReader in;
		PrintWriter out;
		
		public ReadWrite() {
			in = new BufferedReader(new InputStreamReader(System.in));
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));
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
					out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));	
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
	
	private static boolean isInRow(Integer[][] board, int size, int row, Integer number) {
			for (int i = 0; i < size; i++) {
				if (board[row][i] == number) {
					return true;
				}
			}
			return false;
	}
	
	private static boolean isInCol(Integer[][] board, int size, int col, Integer number) {
		for (int i = 0; i < size; i++) {
			if (board[i][col] == number) {
				return true;
			}
		}
		return false;
	}

	private static Boolean isOk(Integer[][] board, int size, int row, int col, Integer number) {
		return !isInRow(board, size, row, number) && !isInCol(board, size, col, number);
	}
	
	private static boolean solveLatinSquare(Integer[][] board, int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				// we search an empty cell
				if (board[row][col] == null) {
					// we try possible numbers
					for (int number = 1; number <= size; number++) {
						if (isOk(board, size, row, col, number)) {
							board[row][col] = number;

							if (solveLatinSquare(board, size)) { // we start backtracking recursively
								return true;
							} else { // if not a solution, we empty the cell and we continue
								board[row][col] = null;
							}
						}
					}
					return false; // we return false
				}
			}
		}
		return true; // finish solving
	}
	
	private static String getLatinSquare(int size, int total) {
		int traceBase = total / size;
		Integer[][] latinSquare = new Integer[size][size];
		for (int i = 0; i < size; i++) {
			latinSquare[i][i] = traceBase;
		}
		
		solveLatinSquare(latinSquare, size);

		StringBuffer sb = new StringBuffer();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (col != 0) {
					sb.append(" ");
				}

				sb.append(latinSquare[row][col]);
			}

			if (row != size - 1) {
				sb.append("\n");	
			}
		}
		
		return sb.toString();
	}
	
	public static String solve(String input, ReadWrite rw) {
		StringBuffer sb = new StringBuffer();
		String[] data = input.split(" ");
		int size = Integer.valueOf(data[0]);
		int total = Integer.valueOf(data[1]);
		if (total % 2 == 0) {
			sb.append("POSSIBLE\n");
			sb.append(getLatinSquare(size, total));
		} else {
			sb.append("IMPOSSIBLE");
		}
		return sb.toString();
	}

	public static void main(String[] arg) throws NumberFormatException, IOException {
        ReadWrite rw = new ReadWrite();
    	int numCases = Integer.valueOf(rw.getIn().readLine());
    	for (int i = 1; i <= numCases; i++) {
    		String output = "Case #" + i + ": " + solve(rw.getIn().readLine(), rw);
    		System.out.println(output);
    		rw.getOut().println(output);
    	}
    	rw.getOut().close();
	}
}
