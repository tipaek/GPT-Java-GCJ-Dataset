import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    int numberOfBits = in.nextInt();
    for (int i = 1; i <= t; ++i) {
    	StringBuilder output = new StringBuilder();
    	for(int x = 1; x <= numberOfBits; x++) {
    		System.out.println(x);
    		output.append(in.next() + "");
    	}
      System.out.println(output);
      in.next();
    }
  }
}