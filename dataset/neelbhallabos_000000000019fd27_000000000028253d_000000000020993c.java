import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static PrintWriter pw = new PrintWriter(System.out);
	final static boolean debugmode = true;
	public static int casenum = 1;
	public static void main(String[] args) throws IOException{
		int T = getInt();
		for(int cas = 0;cas < T;cas++){
			int dim = getInt();
			int[][] matr = readMatrix(dim, dim);
			boolean[][] hasSeenRow = new boolean[dim][dim+1];
			boolean[][] hasSeenCol = new boolean[dim][dim+1];
			HashSet<Integer> dupRows = new HashSet<Integer>();
			HashSet<Integer> dupCol = new HashSet<Integer>();
			int tr = 0;
			for(int r = 0; r < dim;r++) {
				boolean dup = false;
				for(int c =0; c < dim;c++) {
					int val = matr[r][c];
					if(hasSeenRow[r][val]) {
						dupRows.add(r);
					}
					if(hasSeenCol[c][val]) {
						dupCol.add(c);
					}
					if(r == c) {
						tr += matr[r][c];
					}
					hasSeenRow[r][val] = true;
					hasSeenCol[c][val] = true;
				}
			}

			googleSubmit(String.format("%s %s %s", tr,dupRows.size(),dupCol.size()));
		}
		submit();
	}
	
	public static void setInputFile(String fn) throws IOException{
		sc = new BufferedReader(new FileReader(fn));
	}
	public static void setOutputFile(String fn) throws IOException{
		 pw = new PrintWriter(new BufferedWriter(new FileWriter(fn)));
	}
	public static void googleSubmit(int q){
		googleSubmit(Integer.toString(q));
	}
	public static void googleSubmit(long q){
		googleSubmit(Long.toString(q));
	}
	public static void googleSubmit(double q){
		googleSubmit(Double.toString(q));
	}
	public static void googleSubmit(String p){
		submit("Case #"+casenum+": "+p,false);
		casenum++;
	}
	
	public static void debug(String toPrint){
		if(!debugmode) {return;}
		pw.println("[DEBUG]: "+toPrint);
	}
	public static void  submit(int[] k,boolean close){
		pw.println(Arrays.toString(k));
		if(close){
			pw.close();
		}
	}
	public static void submit(int p,boolean close){
		pw.println(Integer.toString(p));
		if(close){
			pw.close();
		}
	}
	public static void submit(String k,boolean close){
		pw.println(k);
		if(close){
			pw.close();
		}
	}
	public static void submit(double u,boolean close){
		pw.println(Double.toString(u));
		if(close){
			pw.close();
		}
	}
	public static void submit(long lng,boolean close){
		pw.println(Long.toString(lng));
		if(close){
			pw.close();
		}
		
	}
	public static void submit(){
		pw.close();
	}
	public static int getInt() throws IOException{
		if (st != null && st.hasMoreTokens()){
			return Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(sc.readLine());
		return Integer.parseInt(st.nextToken());
	}
	public static long getLong() throws IOException{
		if (st != null && st.hasMoreTokens()){
			return Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(sc.readLine());
		return Long.parseLong(st.nextToken());
	}
	public static double getDouble()throws IOException{
		if (st != null && st.hasMoreTokens()){
			return Double.parseDouble(st.nextToken());
		}
		st = new StringTokenizer(sc.readLine());
		return Double.parseDouble(st.nextToken());
	}
	public static String getString()throws IOException{
		if(st != null && st.hasMoreTokens()){
			return st.nextToken();
		}
		st = new StringTokenizer(sc.readLine());
		return st.nextToken();
	}
	public static String getLine() throws IOException{
		return sc.readLine();
	}
	public static int[][] readMatrix(int lines,int cols) throws IOException{
		int[][] matrr = new int[lines][cols];
		for (int i = 0;i < lines;i++){
			for(int j = 0;j < cols;j++){
				matrr[i][j] = getInt();
			}
		}
		return matrr;
	}
	public static int[] readArray(int lines) throws IOException{
		int[] ar = new int[lines];		
		for (int i = 0;i<lines;i++) ar[i] =getInt();
		return ar;
	}
	
	
}
