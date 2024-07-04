import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    in.nextLine();
    for (int testCase = 1; testCase <= t; ++testCase) {
      String s = in.nextLine();
      String newS = "";
      int depth = 0;
      for(int i=0; i<s.length();i++){
        int current = s.charAt(i)-'0';
        while(depth<current){
          newS+="(";
          depth++;
        }

        while(depth>current){
          newS+=")";
          depth--;
        }

        newS+=""+current;

      }

      while(depth>0){
        newS+=")";
        depth--;
      }      

      System.out.println("Case #"+ testCase +": "+newS);
    }
  }
}