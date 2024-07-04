import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class Solution {

	static Scanner s;
	
	public static void testCase(int t) {
		String a = getString();
		a = a.replaceAll("1", "(1)");
		a = a.replaceAll("2", "((2))");
		a = a.replaceAll("3", "(((3)))");
		a = a.replaceAll("4", "((((4))))");
		a = a.replaceAll("5", "(((((5)))))");
		a = a.replaceAll("6", "((((((6))))))");
		a = a.replaceAll("7", "(((((((7)))))))");
		a = a.replaceAll("8", "((((((((8))))))))");
		a = a.replaceAll("9", "(((((((((9)))))))))");
		
		for(int i=0; i<10; i++) {
			a = a.replaceAll("\\)\\(", "");
		}
		
		System.out.println(String.format("Case #%d: %s", t, a));
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