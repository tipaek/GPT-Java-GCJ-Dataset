import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Solution {

	static class QWE implements Comparable<QWE> {
		int index;
		int start;
		int end;
		CharSequence ans;
		
		public QWE(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}



		@Override
		public int compareTo(QWE o) {
			if(start == o.start) {
				return Integer.compare(end, o.end);
			}
			return Integer.compare(start, o.start);
		}
		
		
	}
	
	static Scanner s;
	
	public static void testCase(int t) {
		int n = getInt();
		QWE[] a = new QWE[n];
		for(int i=0; i<n; i++) {
			a[i] = new QWE(i, getInt(), getInt());
		}
		Arrays.sort(a);
		boolean cFree = true;
		int lastTimeCOccupied = -1;
		boolean jFree = true;
		int lastTimeJOccupied = -1;
		for(int i=0; i<n; i++) {
			if(lastTimeCOccupied <= a[i].start) { cFree = true; }
			if(lastTimeJOccupied <= a[i].start) { jFree = true; }
			if(!cFree && !jFree) {
				System.out.println(String.format("Case #%d: %s", t, "IMPOSSIBLE"));
				return;
			}
			if(cFree) {
				a[i].ans = "C";
				cFree = false;
				lastTimeCOccupied = a[i].end;
			} else {
				a[i].ans = "J";
				jFree = false;
				lastTimeJOccupied = a[i].end;
			}
		}
		Arrays.sort(a, new Comparator<QWE>() {
			@Override
			public int compare(QWE o1, QWE o2) {
				return Integer.compare(o1.index, o2.index);
			}
		});
		String qq = Arrays.stream(a).map(b -> b.ans).collect(Collectors.joining());
		System.out.println(String.format("Case #%d: %s", t, qq));
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