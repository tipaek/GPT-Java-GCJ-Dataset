import java.io.*;
import java.util.*;



public class Solution {
	public static void main(String[] args) throws IOException {
		//get input separately
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter p = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer s = new StringTokenizer(b.readLine());
		int cases = Integer.parseInt(s.nextToken());
		//store the answers in an int array
		for (int i = 0; i < cases; i++) {
			s = new StringTokenizer(b.readLine());
			int acts = Integer.parseInt(s.nextToken());
			Pair[] time = new Pair[acts];
			for (int j = 0; j < acts; j++) {
				s = new StringTokenizer(b.readLine());
				int x = Integer.parseInt(s.nextToken());
				int y = Integer.parseInt(s.nextToken());
				time[j] = new Pair(x,y, j);
			}
			//System.out.println(Arrays.toString(time));
			Compare obj = new Compare();
			obj.compareByX(time, time.length);
			Pair[] arr = new Pair[acts * 2];
			int counter = 0;
			for (int j = 0; j < acts; j++) {
				arr[counter] = new Pair(time[j].x, j, time[j].orig );
				arr[counter + 1] = new Pair(time[j].y, j, time[j].orig);
				counter += 2;
			}
			obj.compareByX(arr, arr.length);
			//System.out.println(Arrays.toString(arr));
			boolean imp = false;
			String[] ans = new String[acts];
			int c = -1;
			int j = -1;
			for (int f = 0; f < arr.length; f++) {
				if (arr[f].y == c) {
					c = -1;
				} else if (arr[f].y == j) {
					j = -1;
				} else {
					if (c == -1) {
						c = arr[f].y;
						//ans += "C";
						ans[arr[f].orig] = "C";
					} else if (j == -1) {
						j = arr[f].y;
						//ans += "J";
						ans[arr[f].orig] = "J";

					} else {
						imp = true;
						break;
					}
				}
			}
			if (imp) {
				p.println("Case #" + (i + 1) + ": " +  "IMPOSSIBLE");
			} else {
				String fin = "";
				for (int f = 0; f < acts; f++) {
					fin += ans[f];
				}
				p.println("Case #" + (i + 1) + ": " + fin);
			}
		}
		p.close();
		

	}
	
	
	// you should actually read the stuff at the bottom

}
class Pair {
	int x;
	int y;
	int orig;
	
	public Pair(int first, int second, int orig) {
		x = first;
		y = second;
		this.orig = orig;
	}
	public String toString() {
		return (this.x + " " + this.y);
	}
	
	
}
class Compare { 

	  void compareByY(Pair arr[], int n) 
	 { 
	     // Comparator to sort the pair according to second element 
	     Arrays.sort(arr, new Comparator<Pair>() { 
	         @Override public int compare(Pair p1, Pair p2) 
	         { 
	             return (int) (p1.y - p2.y); 
	         } 
	     }); 
	 } 

	void compareByX(Pair arr[], int n) 
	{ 
	    // Comparator to sort the pair according to second element 
	    Arrays.sort(arr, new Comparator<Pair>() { 
	        @Override public int compare(Pair p1, Pair p2) 
	        { 
	            return (int) (p1.x - p2.x); 
	        } 
	    }); 
	} 
	} 
/* REMINDERS
 * PLANNING!!!!!!!! Concrete plan before code
 * DON'T MAKE ASSUMPTIONS
 * DON'T OVERCOMPLICATE
 * NAIVE SOL FIRST
 * CHECK INT VS LONG, IF YOU NEED TO STORE LARGE NUMBERS
 * CHECK CONSTRAINTS, C <= N <= F...
 * CHECK SPECIAL CASES, N = 1...
 * CHECK ARRAY BOUNDS, HOW BIG ARRAY HAS TO BE
 * TO TEST TLE/MLE, PLUG IN MAX VALS ALLOWED AND SEE WHAT HAPPENS
 * ALSO CALCULATE BIG-O, OVERALL TIME COMPLEXITY
 */
