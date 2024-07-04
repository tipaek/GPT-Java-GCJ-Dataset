import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          String input = in.next();
          boolean binary = true;
          for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j) != '0' && input.charAt(j) != '1'){
                    binary = false;
                }
            }
          StringBuilder output = new StringBuilder();
          StringBuilder ones = new StringBuilder();
          if(binary){
              for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == '0'){
                    if(ones.length()!= 0){
                        output.append(ones);
                        output.append(')');
                        ones = new StringBuilder();
                    }
                    output.append('0');
                }else{
                    if(ones.length()== 0){
                        output.append('(');
                    }
                    ones = ones.append('1');
                    if(j==input.length()-1){
                        output.append(ones);
                        output.append(')');
                    }
                }
            }
          }else{
              String start= ("(((((((((");
              String end= (")))))))))");
              int unm = 0;
              for (int j = 0; j < input.length(); j++) {
                  //System.out.println("Case unm::" + unm);
                  int num = Character.getNumericValue(input.charAt(j));
                  if(j==0){
                      ones.append(start.substring(0, num));
                      ones.append(input.charAt(j));
                      ones.append(end.substring(0, Math.abs(unm-num)));
                  }
                  if(j!=0){
                      ones.append(start.substring(0, Math.abs(unm-Math.abs(unm-num))));
                      ones.append(input.charAt(j));
                      ones.append(end.substring(0, Math.abs(unm-Math.abs(unm-num))));
                  }
                  //System.out.println("Case num:::" + num);
                  unm = num;
                  
              }
              output.append(ones);
          }
          
          System.out.println("Case #" + i + ": " + output.toString());
	}
    }
}