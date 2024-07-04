import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
	  public static void main(String[] args) {
		  Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		  int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		  for (int i = 1; i <= t; i++) {
			  solve(i, in);
		  }
	  }
	  
	  public static void solve(int t, Scanner in){
		  int N = in.nextInt();
		  List<IndexPair> pairs = new ArrayList<IndexPair>();
		  
		  int x, y;
		  for (int i = 0; i < N; i++){
			  x = in.nextInt();
			  y = in.nextInt();
			  pairs.add(new IndexPair(x, y, i));
		  }
		  
		  Collections.sort(pairs, new Comparator<IndexPair>() { 
	            public int compare(IndexPair pair1, IndexPair pair2){
	            	Integer X = pair1.x;
	            	Integer Y = pair2.x;
	            	return X.compareTo(Y);
	            }
		  });

		  int zero_max = 0;
		  int one_max = 0;
		  List<IndexPair> assignment = new ArrayList<IndexPair>();
		  for (IndexPair p : pairs){
			  if (p.x >= zero_max){
				  assignment.add(new IndexPair(p.index, 0, 0));
				  zero_max = Math.max(zero_max, p.y);
			  } else if (p.x >= one_max){
				  assignment.add(new IndexPair(p.index, 1, 0));
				  one_max = Math.max(one_max, p.y);
			  } else {
				  System.out.println("Case #" + t + ": IMPOSSIBLE");
				  return;
			  }
		  }
		  
		  Collections.sort(assignment, new Comparator<IndexPair>() { 
	            public int compare(IndexPair pair1, IndexPair pair2){
	            	Integer X = pair1.x;
	            	Integer Y = pair2.x;
	            	return X.compareTo(Y);
	            }
		  });
		  
		  String output = "";
		  
		  for (IndexPair p : assignment){
			  if (p.y == 0){
				  output += "C";
			  } else {
				  output += "J";
			  }
		  }

		  System.out.println("Case #" + t + ": " + output);
	  }
	  
	  private static class IndexPair {
		  int x;
		  int y;
		  int index;
		  
		  public IndexPair(int x, int y, int index){
			  this.x = x;
			  this.y = y;
			  this.index = index;
		  }
	  }
}
