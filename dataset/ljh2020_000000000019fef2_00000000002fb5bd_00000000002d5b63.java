
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    long a = in.nextLong();
    long b = in.nextLong();
    for (int i = 1; i <= t; i++) {
      	solve(in, a, b);
    }
  }
  public static void solve(Scanner in, long a, long b){	 
	  if(a == (long) Math.pow(10, 9) - 5) {
		  for(int x = -10; x <= 10; x++) {
			  for(int y = -10; y <= 10; y++) {
				  System.out.println(x + " " + y);
				  String str = in.next();
				  if(str.equals("CENTER")) return;
			  }
		  }
	  }else if(a == (long) Math.pow(10, 9) - 50) {
		  long x = binX(in, a, -50, 50);
		  long y = binY(in, b, -50, 50);
		  System.out.println(x + " " + y);
		  String str = in.next();
		  return;
		  
	  }else {
		  long x = binX(in, a, (long) Math.pow(10, 9), (long) Math.pow(10, 9));
		  long y = binY(in, b, (long) Math.pow(10, 9), (long) Math.pow(10, 9));
		  System.out.println(x + " " + y);
		  String str = in.next();
		  return;
	  }
	  System.out.println("0.0 FAIL");
	  return;
	  
  }
  public static long binX(Scanner in, long a, long x1, long x2) {
	  long low = x1;
	  long high = x2;
	  while(low < high) {
		  //System.out.println(low + " " + high);
		  long mid = (long) (low + (high - low + 1)/2); 
		  System.out.println(mid+a + " " + 0);
		  String response = in.next();
		  if(response.equals("HIT")) {
			  low = mid;
		  }else {
			  high = mid;
		  }
	  }
	  return low;
	  
  }
  public static long binY(Scanner in, long b, long y1, long y2) {
	  long low = y1;
	  long high = y2;
	  while(low < high) {
		  //System.out.println(low + " " + high);
		  long mid = (long) (low + (high - low + 1)/2); 
		  System.out.println(mid+b + " " + 0);
		  String response = in.next();
		  if(response.equals("HIT")) {
			  low = mid;
		  }else {
			  high = mid;
		  }
	  }
	  return low;
	  
  }

}