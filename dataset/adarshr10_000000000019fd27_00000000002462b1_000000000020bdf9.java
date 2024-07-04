import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int x = 1; x <= t; ++x) {
    	ArrayList<Tuple<Integer, Integer>> vals = new ArrayList<Tuple<Integer,Integer>>();
    	int size = in.nextInt();
    	int i = 0;
    	while (i < size) {
	    	int n = in.nextInt();
	    	int m = in.nextInt();
	    	Tuple<Integer, Integer> val = new Tuple<Integer, Integer>(n, m);
    		vals.add(val);
    		i++;
    	}
    	String sol = Solution.solve(vals);
      System.out.println("Case #" + x + ": " + sol);

    }
  }
  static String solve(ArrayList<Tuple<Integer, Integer>> input) {
  	int n = input.size();
	String ans = "";
  	ArrayList<Tuple<Integer, Integer>> cam = new ArrayList<Tuple<Integer, Integer>>();
  	ArrayList<Tuple<Integer, Integer>> jam = new ArrayList<Tuple<Integer, Integer>>();
  	int countC = 0;
  	int countJ = 0;
  	for (Tuple<Integer, Integer> val : input) {
  	  	countC = 0;
  	  	for (Tuple<Integer, Integer> camVal : cam) {
  	  		if (val.a >= camVal.b || val.b <= camVal.a) {
				countC++;
  	  		}
  	  	}
  	  	if (countC == cam.size()){
  	  		cam.add(val);
  	  		ans += "C";
  	  	} else {
  	  		countJ = 0;
	  	  	for (Tuple<Integer, Integer> jamVal : jam) {
		  		if (val.a >= jamVal.b || val.b <= jamVal.a) {
					countJ++;
		  		}	
   			}
   	  		if (countJ == jam.size()){
		  	  	jam.add(val);
		  	  	ans += "J";
		  	}
  	  	}
	}
	if (ans.length() != n) {
		return "IMPOSSIBLE";
	} else{
		return ans;
	}
  }
}

class Tuple<A, B> {

    public final A a;
    public final B b;

    public Tuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple<?, ?> tuple = (Tuple<?, ?>) o;
        if (!a.equals(tuple.a)) return false;
        return b.equals(tuple.b);
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}