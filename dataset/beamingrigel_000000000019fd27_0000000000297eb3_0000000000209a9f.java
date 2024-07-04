import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int t = Integer.parseInt(scanner.nextLine().trim());
    
    for (int i = 0; i < t; i++) {
      String n = scanner.nextLine().trim();
      
      calcSDash(n, i+1);
    }
    
    scanner.close();
  }
  
  public static void calcSDash(String n, int t) {
	  StringBuffer res = new StringBuffer();
	  int runningBracket = 0;
	  char[] in = n.toCharArray();
	  
	  for (int i = 0; i < in.length; i++) {
		  int num = in[i] - '0';
		  while(runningBracket != num) {
			  if(runningBracket < num)	{ res.append("("); runningBracket++; }
			  else if(runningBracket > num)	{ res.append(")"); runningBracket--; }
		  }
		  
		  res.append(Character.toString(in[i]));
	  }
	  
	  while(runningBracket > 0)	{ res.append(")"); runningBracket--; }
	  
	  System.out.println("Case #" + t + ": " + res.toString());
  }
  
}
