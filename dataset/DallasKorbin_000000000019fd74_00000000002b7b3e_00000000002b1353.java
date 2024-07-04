import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for(int i = 0; i < numTests; i++) {
    	int testCaseInput = in.nextInt();

    	System.out.println("Case #" + (i+1) + ":");
    	
    	for(int j = 0; j < testCaseInput ; j++) {
    		System.out.println((j+1) + " 1");
    	}
    	
    }
    in.close();
  }

}