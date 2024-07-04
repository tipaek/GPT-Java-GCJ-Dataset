import java.io.*;
import java.util.*;

public class Solution {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// private static final double EPSILON = 1e-10;

	public static long[] rec(long low, long high, long x, long[] arr) throws IOException {
		if(low >= high){
			if(arr[0]==1)
			return arr;
			return new long[]{0, 0,0};
		}
		long y = (low+high)/2;
		System.out.printf("%d %d", x+1000000000, y+1000000000);
		String res = br.readLine();
		if(res.equals("HIT")){
			if(arr[2]> y )
			return rec(y+1, high,x, new long[]{1,x,y});
			return rec(y+1, high,x, arr);
		}
		if(res.equals("CENTER")){
			return new long[]{-1,-1,-1};
		}
		// if(res.equals("MISS"))
		else{
			return rec(low, y-1, x, new long[]{0,0,0});
			
		}
		

	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

//		PrintWriter out = new PrintWriter(System.out);
		int tc = Integer.parseInt(st.nextToken());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		for (int t = 1; t <= tc; t++) {
			long higher = 1000000000-A;
			long lower = -1 * higher; 
			long[] arr = new long[3];
			for(long i = lower; i <= higher; i++){
				long[] res = rec(lower, higher, i, arr);
				if(res[0]==1)
				arr = res;
				if(res[0]==-1)
				break;
			}

			System.out.printf("%d %d", arr[1]+1000000000, arr[2]+1000000000);

			
		}
		
	}
}
