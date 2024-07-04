import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine();
    for (int case_t = 1; case_t <= t; case_t++) {
      
      String input_t = in.nextLine();
      String output_t = "";

      int open = 0;

      for(int i=0; i < input_t.length();i++){

        int num = Integer.parseInt(String.valueOf(input_t.charAt(i)));

        while(num > open){
          output_t += '(';
          open++;
        }

        output_t += input_t.charAt(i);

        if(i+1 == input_t.length()){
          
          for(int j=0 ; j < open ;j++){
            
            output_t += ')';
          
          }

        } else {
          
          int num_next = Integer.parseInt(String.valueOf(input_t.charAt(i+1)));

          while(num_next < open){
            output_t += ')';
            open--;
          }

        }

      }     

      System.out.println("Case #" + case_t + ": " + output_t);
    }
  }
}