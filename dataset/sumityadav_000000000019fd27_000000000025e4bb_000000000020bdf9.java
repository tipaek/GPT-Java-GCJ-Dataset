import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair>{
	public int l, r, i, p;
	public Pair(int i, int l, int r) {
		this.i = i;
		this.l = l;
		this.r = r;
		this.p = 0;
	}
	public int compareTo(Pair arg) {
		if (this.l < arg.l) {
			return -1;
		}
		if (this.l > arg.l) {
			return 1;
		}
		if (this.r < arg.r) {
			return -1;
		}
		if (this.r > arg.r) {
			return 1;
		}
		if (this.i < arg.i) {
			return -1;
		}
		return 1;
	}
}

public class Solution {
	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		int t = sc.nextInt();
		int c = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[1500];
			Pair[] ranges = new Pair[n];
			for (int i = 0 ; i < n ; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				ranges[i] = new Pair(i, l, r);
				arr[l] += 1;
				arr[r] -= 1;
			}
			boolean possible = true;
			for (int i = 1 ; i < arr.length ; i++) {
				arr[i] += arr[i-1];
				if (arr[i] > 2) possible = false;
			}
			Arrays.sort(ranges);
			if (possible) {
				Pair curr = ranges[0];
				//int end = curr.r;
				while (curr != null) {
					curr.p = 1;
					curr = search(ranges, 0, ranges.length-1, curr.r);
				}
				StringBuilder str = new StringBuilder("Case #"+c+": ");
				int[] res = new int[n];
				for (int i = 0 ; i < ranges.length ; i++) {
					res[ranges[i].i] = ranges[i].p;
				}
				for (int i = 0 ; i < n ; i++) {
					str.append(res[i] == 1 ? "C" : "J");
				}
				System.out.println(str.toString());
			}else {
				System.out.println("Case #"+c+": IMPOSSIBLE");
			}
			c++;
		}
	}
	
	private static Pair search(Pair[] arr, int s, int e, int val) {
		if (s > e) return null;
		int m = s + (e-s)/2;
		if (arr[m].l >= val) {
			Pair temp = search(arr, s, m-1, val);
			if (temp == null) return arr[m];
			return temp;
		}else {
			Pair temp = search(arr, m+1, e, val);
			return temp;
		}
	}
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
        
        public InputReader(InputStream in){
        	try {
        		br = new BufferedReader(new
        				InputStreamReader(in)); 
        	}catch (Exception e) {
        		System.out.println(e.toString());
        	}
        }
        
        String next(){
        	while (st == null || !st.hasMoreElements()){
        		try{
        			st = new StringTokenizer(br.readLine()); 
                }catch (IOException  e){
                	e.printStackTrace(); 
                }
            }
            return st.nextToken(); 
        }
        
        int nextInt(){
        	return Integer.parseInt(next()); 
        }
        
        long nextLong(){
        	return Long.parseLong(next()); 
        }
        
        double nextDouble(){
        	return Double.parseDouble(next()); 
        }
        
        String nextLine(){
        	String str = "";
        	try{
        		str = br.readLine();
        	}catch (IOException e){
        		e.printStackTrace(); 
            }
            return str; 
        }
    }
}
