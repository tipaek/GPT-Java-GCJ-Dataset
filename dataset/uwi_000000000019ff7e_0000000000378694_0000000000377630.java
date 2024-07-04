import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
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
		out.println(0 + " " + 0);
		Random gen = new Random();
		for(int i = 0;i < T;i++){
			while(true){
				int x = gen.nextInt(n);
				int y = gen.nextInt(n);
				if(x == y)continue;
				
				out.print((x+1) + " " + (y+1) + " ");
				break;
			}
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
