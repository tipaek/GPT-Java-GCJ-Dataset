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
    		vals.add(new Tuple(n, m));
    		i++;
    	}
      System.out.println("Case #" + x + ": " + Solution.solve(vals));
    }
  }
  static String solve(ArrayList<Tuple<Integer, Integer>> input) {
  	int n = input.size();
	ArrayList<Tuple<Integer, Integer>> copy = new ArrayList<Tuple<Integer, Integer>>();
	copy.addAll(input);

	String ans = "";

  	ArrayList<Tuple<Integer, Integer>> cam = new ArrayList<Tuple<Integer, Integer>>();
  	ArrayList<Tuple<Integer, Integer>> jam = new ArrayList<Tuple<Integer, Integer>>();

	if (cam.size() == 0){
		cam.add(copy.get(0));
		//System.out.println("Cam Addition: " + copy.get(0).a + " " + copy.get(0).b);
		ans += "C";
		copy.remove(0);
		input.remove(0);
  	}
  	Iterator<Tuple<Integer, Integer>> iter = cam.iterator();
  	  int countC = 0;
  	  int countJ = 0;
  	  for (Tuple<Integer, Integer> val : input) {
  	  	for (Tuple<Integer, Integer> camVal : cam) {
  	  		if (val.a < camVal.a && val.b <= camVal.a || val.a >= camVal.b && val.b > camVal.b) {
				countC++;
  	  		}
  	  	}
  	  	if (countC == cam.size()){
  	  		countC = 0;
  	  		cam.add(val);
  	  		ans += "C";
  	  		//System.out.println("Cam Addition: " + val.a + " " + val.b);
  	  		copy.remove(copy.indexOf(val));
  	  	} else {
  	  		if (jam.size() == 0){
  	  			jam.add(val);
  	  			//System.out.println("Jam Addition: " + val.a + " " + val.b);
  	  			ans += "J";
  	  			copy.remove(copy.indexOf(val));
  	  		}
  	  		else {
	  	  		for (Tuple<Integer, Integer> jamVal : jam) {
		  	  		if (val.a < jamVal.a && val.b <= jamVal.a || val.a >= jamVal.b && val.b > jamVal.b) {
						countJ++;
		  	  		}	
  	  			}
  	  			if (countJ == jam.size()){
  	  				countJ = 0;
		  	  		jam.add(val);
		  	  		//System.out.println("Jam Addition: " + val.a + " " + val.b);
		  	  		ans += "J";
		  	  		copy.remove(copy.indexOf(val));
		  	  	}
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