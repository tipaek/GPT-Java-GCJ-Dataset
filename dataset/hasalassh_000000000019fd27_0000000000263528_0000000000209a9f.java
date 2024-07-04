import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine();
    for (int i = 1; i <= t; ++i) {
        String temp = in.nextLine();
        String output = "";
        int max = 1;
        
        for(int j = 0; j < temp.length(); ++j) {
            String character = String.valueOf(temp.charAt(j));
            if( character.equals("0") ) {
                output += character;
                continue;
            }
            else {
                int intValue = Integer.parseInt(character);
                for(int k = 0; k < intValue; ++k) {
                    output += "(";
                } 
                output += character;
                for(int k = 0; k < intValue; ++k) {
                    output += ")";
                }
            }
            
            int intValue = Integer.parseInt(character);
            if(intValue > max) {
                max = intValue;
            }
        }
        
        for(int p = 0; p < max; p++) {
            output = output.replaceAll("\\)\\(", "");
        }
        
        System.out.println("Case #" + i + ": " + output);
    }
  }
}