import java.util.Scanner;

public class Solution {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    for (int a = 1; a <= t; a++) {
      int x = input.nextInt();
      if(x==501) {
    	  System.out.println("Case #" + a + ": ");
    	  System.out.println("1 1");
    	  System.out.println("2 2");
    	  System.out.println("3 2");
    	  for(int i = 3; i<500; i++) {
    		  System.out.println(i + " " + i);
    	  }
      }
      else {
    	  System.out.println("Case #" + a + ": ");
    	  for(int i = 1; i <= x; i++) {
    		  System.out.println(i + " " + i);
    	  }
      }
    }
  }
}