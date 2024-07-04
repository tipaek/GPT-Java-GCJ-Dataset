import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
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
			int x = getInt();
			int y = getInt();
			
			
			String solv = solve(x, y);
			googleSubmit(solv);
		}
		submit();
	}
	public static String solve(int x, int y)  {
		LinkedList<long[]> q = new LinkedList<long[]>();
		Map<String, Character> mep = new HashMap<String, Character>();
		HashSet<long[]> seen = new HashSet();
		q.add(new long[] {0,0, 0});
		while(!q.isEmpty()) {
			long[] nex = q.remove();
			if(nex[0] == x && nex[1] == y) {
				StringBuilder st = new StringBuilder();
				long pow = (long) Math.pow(2,nex[2]-1);
				while(nex[0] != 0 || nex[1] != 0) {
					Character get = mep.get(strf(nex));
					st.append(get);
					if(get == 'N') {
						nex[1] -= pow;
					}
					else if(get == 'S') {
						nex[1] += pow;
					}
					else if(get == 'E') {
						nex[0] -= pow;
					}
					else if(get == 'W') {
						nex[0] += pow;
					}
					pow /= 2;
					nex[2]--;
				}
				return st.reverse().toString();
			}
			long pow = (long) Math.pow(2,nex[2]);
			if(nex[2] > 28) {
				
			}
			else if(pow > Math.abs(nex[0]-x) && Math.abs(nex[0]-x) > 0) {
				
			}
			else if(pow > Math.abs(nex[1]-y) && Math.abs(nex[1]-y) > 0) {
				
			}
			else {
				long[] north = {nex[0], nex[1] + pow, nex[2] + 1};
				long[] south = {nex[0], nex[1] - pow,  nex[2] + 1};
				long[] east = {nex[0] + pow, nex[1],  nex[2] + 1};
				long[] west = {nex[0] - pow, nex[1],  nex[2] + 1};
				
				
				if(!seen.contains(new long[]{nex[0], nex[1] + pow} )) {
					seen.add(new long[]{nex[0], nex[1] + pow} );
					mep.put(strf(north), 'N');
					q.add(north);
				}
				if(!seen.contains(new long[]{nex[0], nex[1] - pow} )) {
					seen.add(new long[]{nex[0], nex[1] - pow} );
					mep.put(strf(south), 'S');
					q.add(south);

				}
				
				if(!seen.contains(new long[]{nex[0]-pow, nex[1]} )) {
					seen.add(new long[]{nex[0]-pow, nex[1] } );
					mep.put(strf(west), 'W');
					q.add(west);

				}
				if(!seen.contains(new long[]{nex[0]-pow, nex[1]} )) {
					seen.add(new long[]{nex[0]-pow, nex[1] } );
					mep.put(strf(east), 'E');
					q.add(east);

				}
				
			}
		}
		return "IMPOSSIBLE";
		
	}
	private static String strf(long[] east) {
		// TODO Auto-generated method stub
		return String.format("%s %s %s", east[0], east[1], east[2]);
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
