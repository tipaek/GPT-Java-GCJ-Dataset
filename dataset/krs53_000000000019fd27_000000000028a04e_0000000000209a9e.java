import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    int b = input.nextInt();
    StringBuffer arr = new StringBuffer(b);
    for (int i = 1; i <= t; i++) {
      for(int bi = 1; bi <= b; bi++){
          System.out.println(bi);
          int bit = input.nextInt();
          arr.append(bit);
      }
      //if(arr.length() == b){
          System.out.println(arr.toString());
          String s = input.next();
        if (s.equals("Y")){
            arr = new StringBuffer(b);
         } else {
             break;
         }
      /*} else {
          break;
      }*/
     
    }
  }
}