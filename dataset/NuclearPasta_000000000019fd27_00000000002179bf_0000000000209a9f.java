import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
          String s = in.nextLine();
          String finalstring = "";
          ArrayList<String> list = new ArrayList<>();
          for(int j = 0; j < s.length(); j++){
              
              list.add(Character.toString(s.charAt(0)));
          }
          for(int k = 0; k < list.size(); k++){
              int parens = Integer.parseInt(s);
              String left = "";
              String right = "";
              for(int l = 0; l < parens; l++){
                  left+="(";
                  right+=")";
              }
              list.add(k-1, left);
              list.add(k+1, right);
          }
          for(int g = 0; g < list.size(); g++){
              if(list.contains(")("))
                list.remove(list.indexOf(")("));
            else
                break;
          }
         for(String sj : list){
             finalstring+=sj;
         } 
        System.out.println("Case #" + i + ": " + finalstring);
    }
  }
}