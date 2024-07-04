import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
          String s = in.nextLine();
          String center = "";
          ArrayList<String> list = new ArrayList<>();
          for(int j = 0; j < s.length(); j++){
              list.add(Character.toString(s.charAt(0)));
          }
          for(int k = 0; k < list.size(); k++){
              int parens = Integer.parseInt(list.get(k));
              String left = "";
              String right = "";
              for(int l = 0; l < parens; l++){
                  left+="(";
                  right+=")";
              }
              center+=left;
              center+=list.get(k);
              center+=right;
          }
          for(int g = 0; g < center.length(); g++){
              if(center.contains(")("))
                center = center.substring(0, center.indexOf(")("))+center.substring(center.indexOf(")(")+1);
            else
                break;
          }
        System.out.println("Case #" + i + ": " + center);
    }
  }
}