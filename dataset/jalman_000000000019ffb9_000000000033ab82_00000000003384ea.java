import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int tt = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    Loop: for (int qq = 1; qq <= tt; ++qq) {
      long l = in.nextLong();
      long r = in.nextLong();
      
	  boolean swap = false;
	  if(r>l) {
		  swap = true;
		  long tmp = l;
		  l = r;
		  r = tmp;
	  }
	  
	  long apx = (long)((-1.0 + Math.sqrt(1 + 8*(l-r)))/2.0);
	  
	  long n = apx-3;
	  if(n<0) n=0;
	  
	  while(!swap && l - n*(n+1)/2 >= r) n++;
	  while(swap && l - n*(n+1)/2 > r) n++;
	  
	  if (l - n*(n+1)/2 < 0) {
		  n--;
		  if(!swap) {
			System.out.println("Case #" + qq + ": " + n + " " + (l - n*(n+1)/2) + " " + r);
		  } else {
			System.out.println("Case #" + qq + ": " + n + " " + r + " " + (l - n*(n+1)/2));
		  }
		  continue Loop;
	  }
	  
	  if(!swap) n--;
	  
	  l = l - n*(n+1)/2;
	  
	  if(swap) {
		  long tmp = l;
		  l = r;
		  r = tmp;
	  }	  
	  
	  apx = (long)((-(double)n + Math.sqrt(((double)n)*((double)n) + 4.0*(l)))/2.0);
	  
	  long a = apx-3;
	  if(a<0) a=0;
	  
	  boolean odd = false;
	  
	  while(l - a*(n+a) >= 0 && r - a*(n+a+1) >= 0) a++;
	  
	  a--;
	  
	  if(l - (a+1)*(n+a+1) >= 0) odd=true;
	  
	  //System.out.println("ASDF " + n + " " + a + " " + odd);
	  
	  if(!odd) {
		System.out.println("Case #" + qq + ": " + (n+2*a) + " " + (l - a*(n+a)) + " " + (r - a*(n+a+1)));
	  } else {
		System.out.println("Case #" + qq + ": " + (n+2*a+1) + " " + (l - (a+1)*(n+a+1)) + " " + (r - a*(n+a+1)));
	  }
	  
    }
  }
}