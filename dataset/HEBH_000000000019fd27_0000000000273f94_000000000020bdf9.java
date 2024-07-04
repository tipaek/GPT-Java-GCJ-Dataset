
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution{

	static PrintWriter go = new PrintWriter(System.out);
	static final BigInteger END = new BigInteger("-999999");

	public static void main(String args[]) throws IOException,FileNotFoundException {
		BufferedReader gi = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		int t = Integer.parseInt(gi.readLine());
		int cas = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(gi.readLine());
			int[] overlap = new int[24 * 60 + 10];
			int[] idx = new int[24 * 60 + 10]; Arrays.fill(idx, -1);
			int[][] ints = new int[n][2];
			for ( int k = 0; k < n; k++ ){
				int[] line = parseArray(gi);
				int L = line[0];
				int R = line[1];
				overlap[L]++;
				overlap[R]--;
				idx[L] = k;
				ints[k][0] = L;
				ints[k][1] = R;
			}
			for ( int k = 1; k < 24 * 60 + 1; k++ )
				overlap[k] += overlap[k - 1];
			boolean[] ans = new boolean[n];
			boolean flag = true;
			for ( int k = 0; k < 24 * 60 + 1; k++ ){
				if (idx[k] != -1 && overlap[k] == 2) {
					ans[idx[k]] = true;
					k = ints[idx[k]][1] - 1;
				}
			}
			for ( int k = 0; k < 24 * 60 + 1; k++ )
				if (overlap[k] > 2)
					flag = false;
			go.print("Case #" + cas++ + ": ");
			if (flag)
				for ( int k = 0; k < n; k++ )
					go.print(ans[k] ? 'C' : 'J');
			else
				go.print("IMPOSSIBLE");
			go.println();
		}
		go.close();
	}

	static int[] parseArray(BufferedReader gi) throws IOException{
		String[] line = gi.readLine().split(" ");
		int[] rez = new int[line.length];
		for ( int k = 0; k < line.length; k++){
			rez[k] =  Integer.parseInt(line[k]);
		}
		return rez;
	}

}
