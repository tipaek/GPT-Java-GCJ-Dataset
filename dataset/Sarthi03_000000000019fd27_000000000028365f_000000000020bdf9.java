import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int ar[][] = new int[n][3];     
      for(int j=0;j<n;j++){
      	ar[j][0] = in.nextInt();
      	ar[j][1] = in.nextInt();
      }
      String str ="";
      if(!check(ar,n,0))
      	str = "IMPOSSIBLE";
      else{
      	for(int k =0;k<n;k++)
      		str += Character.toString((char)ar[k][2]);
      }
      System.out.println("Case #" + i + ": " + str);
    }
  }

  public static boolean check(int ar[][], int n, int i){
  	if(i>=n)
  		return true;
  	boolean cp = true, jp = true;
  	for(int j=0;j<i;j++){
  		if((ar[i][0] >= ar[j][0] && ar[i][0] < ar[j][1]) || (ar[i][1] >= ar[j][0] && ar[i][1] <= ar[j][1]))
  		{	
  			if(ar[j][2] == 67)
  				cp = false;
  			else
  				jp = false;
  		}
  	}
  	if(!cp && !jp)
  		return false;
  	if(cp)
  	{
  		ar[i][2] = 67;
  		if(check(ar, n, i+1))
  			return true;
  	}
  	if(jp)
  	{
  		ar[i][2] = 74;
  		if(check(ar, n, i+1))
  			return true;
  	}
  	return false;
  }
}