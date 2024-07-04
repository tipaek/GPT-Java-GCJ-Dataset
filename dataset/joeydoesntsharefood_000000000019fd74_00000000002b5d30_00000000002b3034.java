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
		  List<String> starts = new ArrayList<String>();
		  List<String> ends = new ArrayList<String>();
		  
		  String curr;
		  String middle = "";
		  String longest_start = "";
		  String longest_end = "";
		  String[] parts;
		  for (int i = 0; i < N; i++){
			  curr = in.next();
			  parts = curr.split("\\*", 100);
			  
			  starts.add(parts[0]);
			  ends.add(parts[parts.length - 1]);
			  
			  if (parts[0].length() > longest_start.length()){
				  longest_start = parts[0];
			  }
			  
			  if (parts[parts.length - 1].length() > longest_end.length()){
				  longest_end = parts[parts.length - 1];
			  }
			  
			  if (parts.length > 2){
				  for (int j = 1; j < parts.length - 1; j++){
					  middle += parts[j];
				  }
			  }
		  }
		  
		  for (int i = 0; i < N; i++){
			  if (longest_start.length() > 0 && starts.get(i).length() > 0 && !longest_start.startsWith(starts.get(i))){
				  System.out.println("Case #" + t + ": *");
				  return;
			  }
			  
			  if (longest_end.length() > 0 && ends.get(i).length() > 0 && !longest_end.endsWith(ends.get(i))){
				  System.out.println("Case #" + t + ": *");
				  return;
			  }
		  }
		  
		  System.out.println("Case #" + t + ": " + longest_start + middle + longest_end);
	  }
}
