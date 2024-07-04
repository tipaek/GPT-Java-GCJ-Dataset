import java.util.*;
import java.io.*;

public class Solution {
	static Scanner sc;
	// static BufferedReader br;
	public static void main(String[] args)throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 1; i <= t; ++i) {
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}
	static void solve() {
		long l = sc.nextLong(), r = sc.nextLong();
		int i = 1;
		for(;; i++){
			if(Math.max(l, r) < i)break;
			else if(l < r) r-=i;
			else l-=i;
		}
		System.out.println((i-1)+" "+l+" "+r);
		
	}

}
