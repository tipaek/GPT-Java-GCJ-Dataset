import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int t = in.nextInt();
	in.nextLine();
    for (int i = 1; i <= t; ++i) {
    	int size = in.nextInt();
    	int trace = in.nextInt();
    	if(trace % size == 0) {
    		System.out.println("Case #"+i+": POSSIBLE");
    		for(int j = 1; j <= size; j++) {
				List<Integer> line = new ArrayList<>();
    			for(int l = 1; l <= size; l++) {
    				line.add(l);
    			}
    			Collections.rotate(line, size - (trace/size)+j);
    			for(int elem : line) {
    				System.out.print(elem + " ");
    			}
    			System.out.println();
    		}
    	}
    	else {
    		System.out.println("Case #"+i+": IMPOSSIBLE");
    	}
    }
  }
}