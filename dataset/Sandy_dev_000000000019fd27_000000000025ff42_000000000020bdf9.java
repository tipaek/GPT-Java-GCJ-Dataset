import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for(int i=1;i<=t;i++) {
			int n = Integer.parseInt(in.readLine());
			List<Integer>[] a = new List[n];
			for(int j=0;j<n;j++) {
				String l[] = (in.readLine()).split(" ");
				a[j] = new ArrayList<Integer>(2);
				a[j].add(Integer.parseInt(l[0]));
				a[j].add(Integer.parseInt(l[1]));
			}
			
			System.out.println("Case #"+i+": "+comp(n,a));
		}
	}
	
	/**
	 * @param n
	 * @param a
	 * @return
	 */
	/**
	 * @param n
	 * @param a
	 * @return
	 */
	/**
	 * @param n
	 * @param a
	 * @return
	 */
	public static String comp(int n, List<Integer>[] a) {
		int c=-1;
		int j=-1;
		Arrays.sort(a, new Comparator<List<Integer>>() {
			public int compare(List<Integer> a, List<Integer> b) {
				return a.get(0) - b.get(0);
			}
		});
		char ans[] = new char[n];
		int i = 0;
		for(List<Integer> x: a) {
			if(x.get(0) >= c) {
				c = x.get(1);
				ans[i++] = 'C';
			}
				
			else if(x.get(0) >= j) {
				j = x.get(1);
				ans[i++] = 'J';
			}
			
			else
				return "IMPOSSIBLE";

		}
		return new String(ans,0,n);
	}
}
