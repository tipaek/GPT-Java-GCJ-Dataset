import java.io.*;
import java.util.*;
import java.nio.file.*;
import static java.lang.Math.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		int cases = i();
		for(int c=1; c<=cases; c++){
			int numact = i();
				
			int[][] original = new int[numact][2];
			int[][] activites = new int[numact][2];
			for(int k=0; k<numact; k++){
				activites[k][0] = i();
				activites[k][1] = i();

				original[k][0] = activites[k][0];
				original[k][1] = activites[k][1];
			}
			Arrays.sort(activites, new Comparator<int[]>(){
				@Override
				public int compare(int[] a, int[] b){
					return a[0] - b[0];
				}
			});
			int[] map = map(original, activites);
			//out.println(Arrays.toString(map));

			String ret = "";
			int [] endtime = new int[2];
			for(int k =0; k<numact; k++){
				if(endtime[0] <= activites[k][0]){
					ret+="C";
					endtime[0] = activites[k][1];
				}
				else if(endtime[1] <= activites[k][0]){
					ret+="J";
					endtime[1] = activites[k][1];
				}
				else{
					ret = "IMPOSSIBLE";
					break;
				}
			}
			if(!ret.equals("IMPOSSIBLE"))
				ret = unsort(map, ret);
			out.println("Case #"+c+": "+ret);
		}

		out.close();
	}

	public static String unsort(int[] map, String str){
		char[] line = str.toCharArray();
		char[] ret = new char[line.length];
		
		for(int k =0; k<line.length; k++){
			ret[k] = line[map[k]];
		}

		String ans = "";
		for(int k =0; k<line.length; k++){
			ans+=ret[k]+"";
		}

		return ans;
	}

	public static int[] map(int[][] original, int[][] activites){
		int[] ret = new int[original.length];
		for(int k =0; k<original.length; k++){
			int[] temp = original[k];

			for(int j =0; j<activites.length; j++){
				if(activites[j][0] == temp[0] && activites[j][1] == temp[1]){
					ret[j] = k;
					break;
				}
			}
		}
		return ret;
	}

	static BufferedReader in;
	static StringTokenizer st = new StringTokenizer("");
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static {
		try {
			in = Files.newBufferedReader(Paths.get("test.in"));
		} catch (Exception e) {
			in = new BufferedReader(new InputStreamReader(System.in));
		}
	}
	static void check() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
	}
	static String s() throws Exception { check(); return st.nextToken(); }
	static int i() throws Exception { return Integer.parseInt(s()); }
	static long l() throws Exception { return Long.parseLong(s()); }
	static double d() throws Exception { return Double.parseDouble(s()); }
}
