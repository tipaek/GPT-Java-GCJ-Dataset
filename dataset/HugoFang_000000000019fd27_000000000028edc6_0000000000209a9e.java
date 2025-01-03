import java.util.Scanner;
import java.io.*; 
import java.util.*; 

public class Solution {
	  public static boolean solve(Scanner input, int B) {
		    List<String> set = new ArrayList<String>();
		    String res = "";
		    
		    for(int i = 1; i <= 15; ++i) {
		    	
		    	StringBuilder line = new StringBuilder();
		    	
		    	for(int j = 1; j <= 10; ++j) {
		            System.out.println(j);
		            line.append(input.next().charAt(0));
		    	}
		    	
	            String s = line.toString();
	            if(!set.contains(s)) set.add(s);
		    }
		   
		    for(String item : set) {
		    	res = item;
		    	char[] orig = item.toCharArray();
		    	String rev =  new String(rev(orig));
		    	String cmp = new String(cmp(orig));
		    	String revcmp = new String(revcmp(orig));
		    	
		    	if(set.contains(rev) && set.contains(cmp) &&  set.contains(revcmp)) break;
		    }
		    
		    System.out.println(res);
		    return input.next().equals("Y");
	  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      if(!solve(input, B)) break;
    }
  }
}
