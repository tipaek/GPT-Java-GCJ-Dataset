import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
public class Solution {

	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); //Number of cases
    String unused = in.nextLine();
    for (int i = 1; i <= t; ++i) {//iterate over number of cases
      int N = in.nextInt();//
      unused = in.nextLine();
      
      System.out.println("Case #" + i + ":"); 
      int total = 0;
      int position = 1;
      if(N > 0) {
    	  System.out.println("1 1");
    	  total++;
      }
      if(N >1) {
    	  System.out.println("2 1");
    	  total++;
      }
      if(N==3) {
    	  System.out.println("3 1");
    	  total = 3;
      } else if( N > 3) {
    	  System.out.println("3 2");
    	  total +=2;
      }
      
      position = 3;
      while(total < N) {
    	  System.out.println(position + " 1");
    	  position++;
    	  total ++;
      }
	  
      
    }
    in.close();
  }
  
}
