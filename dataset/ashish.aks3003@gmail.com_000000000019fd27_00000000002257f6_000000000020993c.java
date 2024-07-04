import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputReader scan = new InputReader(in);
		int t = scan.nextInt();
		for(int i = 0; i<t; i++) {
			int n = scan.nextInt();
			ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
			for(int j=0; j<n; j++) {
				ArrayList<Integer> row = new ArrayList<Integer>();
				for(int k=0; k<n; k++) {
					row.add(scan.nextInt());
				}
				matrix.add(row);				
			}
			int trace=0, r=0, c=0;
			for(int j=0; j<n; j++) {
				HashSet<Integer> rset = new HashSet<Integer>();
				HashSet<Integer> cset = new HashSet<Integer>();
				for(int k=0; k<n; k++) {
					if(k==j)
						trace += matrix.get(j).get(k);				
					rset.add(matrix.get(j).get(k));
					cset.add(matrix.get(k).get(j));
				}
				if(rset.size()!=n)
					r++;
				if(cset.size()!=n)
					c++;
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
		}
		
	}
	
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));			
		}
		
		String next(){
			while(st == null || !st.hasMoreTokens()) {
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
	}
}
