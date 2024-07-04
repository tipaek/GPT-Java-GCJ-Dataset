import java.util.*;
import java.io.*;
public class Solution {
  public static ArrayList<String> arr;
  public static ArrayList<ArrayList<Integer>> times;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for (int i = 1; i <= t; i++) {
      arr = new ArrayList<String>();
      times = new ArrayList<ArrayList<Integer>>();
      int n = in.nextInt();
      for (int j = 0; j < n; j++) {
         ArrayList<Integer> current = new ArrayList<Integer>();
         current.add(in.nextInt());
         current.add(in.nextInt());
         times.add(current);
      }
      makeArr("", n);
      System.out.println("Case #" + i + ": " + findCorrect());
    }
  }
  
  public static void makeArr(String s, int n)
   {
      if (n == 0) {
         arr.add(s);
         return;
      }
      makeArr(s+"C", n-1);
      makeArr(s+"J", n-1);     
   }
   
   public static String findCorrect() {
      for (int i = 0; i < arr.size(); i++) {
         if (test(arr.get(i)))
            return arr.get(i);
      }
      return "IMPOSSIBLE";
   }
 
  public static boolean test(String s) {
      ArrayList<ArrayList<Integer>> c = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(-1);
      temp.add(-1);
      c.add(temp);
      ArrayList<ArrayList<Integer>> j = new ArrayList<ArrayList<Integer>>();
      j.add(temp);
      int x = 0;
      for (int i = 0; i < s.length(); i++) {
         int c1 = times.get(x).get(0);
         int c2 = times.get(x).get(1);
         if (s.charAt(i) == 'C') {
            if (!testCurrent(c, c1, c2))
               return false;
            c.add(times.get(x));
         }
         else if (s.charAt(i) == 'J') {
            if (!testCurrent(j, c1, c2))
               return false;
            j.add(times.get(x));
         }
         x++;
      }
      return true;
  }
  
  public static boolean testCurrent(ArrayList<ArrayList<Integer>> name, int a, int b) {
      for (int i = 0; i < name.size(); i++) {
         if ((a > name.get(i).get(0) && a < name.get(i).get(1)) || (b > name.get(i).get(0) && b < name.get(i).get(1)))
            return false;
         if ((a == name.get(i).get(0) || b == name.get(i).get(1)) && a != b)
            return false;
         if (name.get(i).get(0) > a && name.get(i).get(1) < b)
            return false;
      }
      return true;
  }

}