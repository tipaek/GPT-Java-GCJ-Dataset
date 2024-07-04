import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int case_t = 1; case_t <= t; case_t++) {
      
      int input_x = in.nextInt();
      int input_y = in.nextInt();
      String input_m = in.next();

      int out = -1;

      for(int i = 0; i < input_m.length() ; i++){

        if(input_m.charAt(i) == 'N'){
          input_y += 1;
        } else if (input_m.charAt(i) == 'S'){
          input_y -= 1;
        } else if (input_m.charAt(i) == 'E'){
          input_x += 1;
        } else if (input_m.charAt(i) == 'W'){
          input_x -= 1;
        }

        if(Math.abs(input_x) + Math.abs(input_y) <= i+1){
          out = i+1;
          break;
        }

      }

      if(out == -1){
        System.out.println("Case #" + case_t + ": IMPOSSIBLE");  
      } else {
        System.out.println("Case #" + case_t + ": " + out);
      }

      // System.out.println("Case #" + case_t + ": " + input_x + ": " + input_y + ": " + input_m);
    }
  }
    
}