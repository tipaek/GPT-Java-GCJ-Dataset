import java.util.*;
class Solution {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int x = scan.nextInt();
      scan.nextLine();
      for (int y=0; y<x;y++) {
    	  int lev =0;
    	  String test = scan.nextLine();
    	  String ans = "";
    	  for (int z=0; z<=test.length();z++) {
			  int a=0;
    		  if (z!=test.length()) {
    		  a= Integer.parseInt(""+test.charAt(z));
			  }
    		  if (z==0) {
    			  lev += a;
    			  String repeated = new String(new char[a]).replace("\0", "(");
    			  ans += repeated+a;
    		  }
    		  else if (z==test.length()) {
    			  String repeated = new String(new char[lev]).replace("\0", ")");
    			  ans += repeated;
    		  }
    		  else if (a<=lev) {
    			  String repeated = new String(new char[lev-a]).replace("\0", ")");
    			  ans += repeated+a;
    			  lev -= lev-a;
    		  }
    		  else if (a>lev) {
    			  String repeated = new String(new char[a-lev]).replace("\0", "(");
    			  ans += repeated+a;
    			  lev += a-lev;
    		  }

    	  }
    	  System.out.println("Case #" + (y+1)+": " + ans);
  }
 }
}
