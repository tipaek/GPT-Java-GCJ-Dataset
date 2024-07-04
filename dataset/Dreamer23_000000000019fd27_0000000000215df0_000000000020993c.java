
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	private static void test() throws IOException {
		String s;
		BufferedReader read = new BufferedReader(new FileReader("data/testIn"));
		String total = "";
		while((s = read.readLine())!= null) total += s + "\n";
		InputStream testInput = new ByteArrayInputStream( total.getBytes("UTF-8") );
		System.setIn(testInput);
		read.close();
	}

	// No large test set? This is weird - that seems overly easy :/
	// Oh well, let's brute force then! :)
	public static void main(String[] args) throws IOException {
//		test();
		final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		final int t = Integer.parseInt(in.nextLine());
		for (int x = 1; x <= t; ++x) {
			int rows = Integer.parseInt(in.nextLine());
			System.out.println("Case #" + x + ": " + getResult(rows, in));
		}
		in.close();
	}
		
	private static String getResult(int rows, Scanner in) {
		final int[][] numberInCol = new int[rows][rows+1]; // column -> number
		final int[][] numberInRow = new int[rows][rows+1]; // row -> number
		int trace = 0;
		for(int i = 0; i < rows; i++) {
			final String[] raw = in.nextLine().split(" ");
			for(int j = 0; j < rows; j++) {
				final int n = Integer.parseInt(raw[j]);
				if (i == j) trace += n;
				numberInCol[j][n]++;
				numberInRow[i][n]++;
			}
		}
		int dupInCol = 0;
		int dupInRow = 0;
		for (int i = 0; i < rows; i++) {
			boolean hasDupCol = false;
			boolean hasDupRow = false;
			for(int j = 1; j <= rows; j++) {
				if(numberInCol[i][j] > 1) hasDupCol = true;
				if(numberInRow[i][j] > 1) hasDupRow = true;
				if(hasDupCol && hasDupRow) break;
			}
			if(hasDupCol) dupInCol++;
			if(hasDupRow) dupInRow++;
		}
		return trace + " " + dupInRow + " " + dupInCol;
	}	
}
