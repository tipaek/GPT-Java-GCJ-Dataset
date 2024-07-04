import java.util.*;

public class Solution {
  public static boolean solve(Scanner input, int B) {
    int[] guess = new int[B];
    
    for (int i=0; i<B*4-1; i++) {
        System.out.println((i+1) % B);
        int num = input.nextInt();
        guess[i % B] = num;
    }
    
    String result = constructString(guess);
    
    System.out.println(result);
      
    String s = input.next();
    return s.equals("Y");
  }
  
  public static String constructString(int[] array) {
      String str = "";
      
      for(int i : array)
          str += Integer.toString(i); 
      
      return str;
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      if (!solve(input, B)) break;
    }
    
    System.exit(0); 
  }
}