import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt();
    //System.out.println(t);
    scnr.nextLine();
    
    for (int cas = 0; cas <t; ++cas) {
      String s = scnr.nextLine();
      char[] ch = s.toCharArray();
      //System.out.println(ch);

      
      int parCount = 48;
      System.out.print("Case #" + (cas + 1) + ": ");
      for (int i = 0; i < ch.length;) {
        if(parCount < ch[i]) {
          System.out.print('(');
          parCount++;
        } else if (parCount > ch[i]) {
          System.out.print(')');
          parCount--;
        } else {
          System.out.print(ch[i]);
          ++i;
        }
      }
      
      while(parCount > 48) {
        System.out.print(')');
        --parCount;
      }
      System.out.println();
      
    }
  }

}
