import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

// Solution
public class Solution {
	static Scanner in;
	static PrintWriter out;
	static String INPUT = "";
	
	static void solve()
	{
		int T = ni();
		int n = ni(), C = ni();
		int[] found = new int[T];
		Arrays.fill(found, -1);
		for(int i = 0;i < n;i++){
			for(int j = 0;j < T;j++){
				if(found[j] == -1){
					out.print(i+1 + " ");
				}else{
					out.print(0 + " ");
				}
			}
			out.flush();
			for(int j = 0;j < T;j++){
				if(ni() == 0 && found[j] == -1){
					found[j] = i;
				}
			}
		}
		
		for(int i = 0;i < T;i++){
			out.print(0 + " ");
		}
		out.println();
		for(int i = 0;i < T;i++){
			out.print(((found[i]+1)%n+1) + " " + ((found[i]+2)%n+1) + " ");
		}
		out.flush();
	}
	
	public static void main(String[] args) throws Exception
	{
		long S = System.currentTimeMillis();
		in = INPUT.isEmpty() ? new Scanner(System.in) : new Scanner(INPUT);
		out = new PrintWriter(System.out);
		
		solve();
		out.flush();
		long G = System.currentTimeMillis();
		tr(G-S+"ms");
	}
	
	static int ni() { return Integer.parseInt(in.next()); }
	static void tr(Object... o) { if(!INPUT.isEmpty())System.out.println(Arrays.deepToString(o)); }
}
