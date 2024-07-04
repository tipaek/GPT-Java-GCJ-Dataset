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
      while(total < N) {
    	  System.out.println(position + " " + position);
    	  position++;
    	  total ++;
      }
	  
      
    }
    in.close();
  }
  
}
