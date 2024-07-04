import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    int b = input.nextInt();
    StringBuffer arr = new StringBuffer(b); 
    for (int ks = 1; ks <= t; ks++) {
      for(int bt=1; bt<=b; bt++){
          System.out.println(bt);
          int bit = input.nextInt();
          if(bit < 2){
              arr.append(bit);
          } else {
              break;
          }
      }
      if(arr.length() == b){
          System.out.println(arr.toString());
          String s = input.next();
        if (s.equals("Y")){
            arr = new StringBuffer(b);
         } else{
             break;
         }
      } else {
          break;
      }
      
    }
  }
}