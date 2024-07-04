import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class Solution {

	static Scanner s;
	
	public static void testCase(int t) {

		int n = getInt();
		Integer[][] mat = getMatrixInt(n, n);
		int tr = 0;
		for(int i=0; i<n; i++) {
			tr += mat[i][i];
		}
		int rr = 0;
		for(int i=0; i<n; i++) {
			Set<Integer> s = new HashSet<Integer>();
			for(int j=0; j<n; j++) {
				s.add(mat[i][j]);
			}
			if(s.size() < n) {
				rr++;
			}
		}
		
		int cc = 0;
		for(int i=0; i<n; i++) {
			Set<Integer> s = new HashSet<Integer>();
			for(int j=0; j<n; j++) {
				s.add(mat[j][i]);
			}
			if(s.size() < n) {
				cc++;
			}
		}
		
		System.out.println(String.format("Case #%d: %d %d %d", t, tr, rr, cc));
	}
	
	
	
	
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int T = s.nextInt();
		for(int i=0; i<T; i++) {
			testCase(i+1);
		}
	}
	
	static public int getInt(){ return s.nextInt(); }
	static public long getLong(){ return s.nextLong(); }
	static public String getString(){ return s.next();}
	static public Integer[] getArrayInt(int size){
		Integer[] ans = new Integer[size];
		for(int i=0; i<size; i++)
			ans[i]=getInt();
		return ans;
	}
	static public Long[] getArrayLong(int size){
		Long[] ans = new Long[size];
		for(int i=0; i<size; i++)
			ans[i]=getLong();
		return ans;
	}
	static public Integer[][] getMatrixInt(int n, int m){
		Integer[][] ans = new Integer[n][m];
		for(int i=0; i<n; i++){
			ans[i] = getArrayInt(m);
		}
		return ans;
	}
	static public void forn(String str, Consumer<Character> c){	
		for(int i=0; i<str.length(); i++){
			c.accept(str.charAt(i));
		}
	}
	static public <T> void forn(T[] arr, Consumer<T> c){
		for(int i=0; i<arr.length; i++){
			c.accept(arr[i]);
		}
	}
	
}