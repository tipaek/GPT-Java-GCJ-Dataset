import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader scn = new FastReader();
		int t = scn.nextInt();
		int p = t;
		while(t-->0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			String str = scn.next();
			int n = str.length();
			boolean f=false;
			for(int i= 0; i<n+1; i++){
				if(Math.abs(x)+Math.abs(y)<=i){
					f=true;
					System.out.println("Case #" + (p-t) + ": " + i);
					break;
				}
				if(i!=n){
					if(str.charAt(i)=='S') y--;
					else if(str.charAt(i)=='N') y++;
					else if(str.charAt(i)=='E') x++;
					else x--;

				}
			}
			if(!f)
				System.out.println("Case #" + (p-t) + ": IMPOSSIBLE");
		}
		
	}
	
	
	static int gcd(int a, int b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
      
    static int lcm(int a, int b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
    
    static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

	