import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
        processTest(in,i);
    }
  }
  
  private static void processTest(final Scanner scannerInput,int i) {
      System.out.print("Case #"+i+": ");
      final String input = scannerInput.next();
      
      int index = 0;
      for (int j = 0; j < input.length(); j++) {
         int currentValue = Character.getNumericValue(input.charAt(j));
         int value = currentValue - index;
         for(int m = value; m > 0; m --) {
                System.out.print("(");
                }
                
         for(int m = value; m < 0; m ++) {
                System.out.print(")");
                }  
         index = currentValue;
         System.out.print(currentValue);
        }
    for(int j = 0; j < index; j++) {
        System.out.print(")");
    }
    System.out.println();
  }
} 