import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//scan("problem/qual.p3/input1.txt", in -> {
			int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int i = 1; i <= t; ++i) {
				int n = in.nextInt();
				List<Activity> activities = new ArrayList<>();
				for( int l=0; l<n; l++) {
					activities.add(new Activity(in.nextInt(), in.nextInt()));
				}
				
				System.out.println("Case #" + i + ": " + solve(n,activities) );
			}
		//});
		in.close();
	}
	
	public static final int minutes(int timeInt) {
		return (timeInt/100)*60 + timeInt%100;
	}
	
	static class Activity {
		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
		int start;
		int end;
	}
	
	static final Comparator<Activity> byFinishIncreasing = (a,b) -> Integer.compare(a.end, b.end);

	private static String solve(int n, List<Activity> as) {
		StringBuilder sb = new StringBuilder();
		Activity ca = null, ja = null;

		as.sort((a,b) -> Integer.compare(a.start, b.start));
		for(Activity a : as) {
			
			if(ca == null) {
				ca = a;
				sb.append("C");
			} else if(ja == null) {
				ja = a;
				sb.append("J");
			} else {
				if(ca.end <= ja.end) {
					if( a.start >= ca.end ) {
						ca = a;
						sb.append("C");
					} else if (a.start >= ja.end) {
						ja = a;
						sb.append("J");
					} else {
						return "IMPOSSIBLE";
					}
				} else {
					if (a.start >= ja.end) {
						ja = a;
						sb.append("J");
					} else if( a.start >= ca.end ) {
						ca = a;
						sb.append("C");
					} else {
						return "IMPOSSIBLE";
					}
				}
			}
		}
		return sb.toString();
	}

	static void scan(String filename, Consumer<Scanner> consumer) {
		try (Scanner sc = new Scanner(new File(filename))) {
			consumer.accept(sc);
		} catch (FileNotFoundException e) {
			System.err.printf("Error scanning %s", filename);
			e.printStackTrace();
		}
	}

}