
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for(int count = 1; count<=t;count++) {
    	int n = in.nextInt();
    	String[] strings = new String[n];
    	int currIndex=0;
    	for(int i = 0;i<n;i++) {
    		strings[currIndex++]=in.next();
    		
    	}
    	System.out.println("Case #" + count + ": " + works(strings));
    }
  }
  
  public static String works(String[] arr) {
	  String biggest  = "";
	  
	  for(int i = 0;i<arr.length;i++) {
		  arr[i]=arr[i].substring(1);
	  }
	  for(int i =0;i<arr.length;i++) {
		  if(biggest.length()<arr[i].length()) {
			  biggest = arr[i];
		  }
	  }
	  
	  for(int i =0;i<arr.length;i++) {
		  if(!biggest.contains(arr[i])) {
			  return "*";
		  }
	  }
	  return biggest;
  }
}