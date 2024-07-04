import java.util.Arrays;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int t = scnr.nextInt();
    //System.out.println("Total cases: " + t);
    
    lab: for (int cas = 0; cas < t; cas++) { // Each file
      //System.out.println("Case number: " + cas);
      
      
      int n = scnr.nextInt();
      scnr.nextLine();
      //System.out.println(n);
      String[] strings = new String[n];
      for (int i = 0; i < n; ++i) {
        strings[i] = scnr.nextLine();
        //System.out.println(strings[i]);
      }
      
      Arrays.sort(strings, new java.util.Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            // TODO: Argument validation (nullity, length)
            return s2.length() - s1.length();// comparision
        }
    });
      
      String longest = strings[0];
      //System.out.println("Longest: "+ longest);
      
      for (int i = 1; i < strings.length; ++i) {
        if(longest.lastIndexOf(strings[i].substring(1)) == -1 || longest.lastIndexOf(strings[i].substring(1)) + strings[i].substring(1).length() != longest.length()) {
          //System.out.println(strings[i].substring(1) + " no match");
          System.out.println("Case #" + (cas + 1) + ": *");
          continue lab;
        }
      }
      
      System.out.println("Case #" + (cas + 1) + ": " + longest.substring(1));
      
    }
    
  }
}
