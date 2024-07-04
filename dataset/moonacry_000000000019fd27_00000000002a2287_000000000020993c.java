
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

 class Vestigium {
	public  static  int trace(int[][]mat) {
		int ans = 0;
		for (int i = 0; i < mat.length; i++) {
			ans+=mat[i][i];
		}
		return ans;
	}
	public static  boolean row(int[][]mat,int row) {
		boolean[] mem = new boolean[101];
		for (int i = 0; i < mat.length; i++) {
			if(mem[mat[row][i]])
				return true;
			mem[mat[row][i]]=true;
		}
		return false;
	}
	private static  int countRows(int [][]mat) {
		int ans = 0;
		for (int i = 0; i < mat.length; i++) {
			ans += (row(mat, i)?1:0);
		}
		return ans;
	}
	public static  boolean col(int[][]mat,int col) {
		boolean[] mem = new boolean[101];
		for (int i = 0; i < mat.length; i++) {
			if(mem[mat[i][col]])
				return true;
			mem[mat[i][col]]=true;
		}
		return false;
	}
	private static int countCols(int [][]mat) {
		int ans = 0;
		for (int i = 0; i < mat.length; i++) {
			ans += (col(mat, i)?1:0);
		}
		return ans;
	}

	public static void main(String[] args)throws IOException {
		scan = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = new StringTokenizer("", "");
		//wr = new PrintWriter(new File("src/utils/output"));
		wr = new PrintWriter(System.out);
		int t = readInteger();
		for (int i = 1; i <= t; i++) {
			int n = readInteger();
			int[][] mat =new int[n][n];
			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat.length; j2++) {
					mat[j][j2] = readInteger();
				}
			}
			
			int trace = trace(mat);
			int rows = countRows(mat);
			int cols = countCols(mat);
			
			wr.printf("Case #%d: %d %d %d\n",i,trace,rows,cols);
		}
		wr.close();
	
	}

	private static BufferedReader scan;
	private static StringTokenizer tokenizer;
	private static PrintWriter wr;

	public static int readInteger() throws IOException {
		return Integer.parseInt(read());
	}

	public long readLong() throws IOException {
		return Long.parseLong(read());
	}

	public double readDouble() throws IOException {
		return Double.parseDouble(read());
	}

	public static String read() throws IOException {
		String res = "";
		if (tokenizer.hasMoreTokens()) {
			res = tokenizer.nextToken();
		} else {
			String aux = scan.readLine();
			//if(aux == null){
			//	wr.close();
			//	System.exit(0);
			//}

			tokenizer = new StringTokenizer(aux, " ");
			res = tokenizer.nextToken();
		}
		return res;
	}

	public static void run() {
		try {




			scan.close();
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
			wr.close();
			System.exit(0);
		}
	}
}