// package;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      int numberOfCases = input.nextInt();

      for (int j = 1; j <= numberOfCases; j++) {
         int numberOfString = input.nextInt();
         input.nextLine();

         ArrayList<String> strings = new ArrayList<>(numberOfString);

         for (int i = 0; i < numberOfString; i++) {
            strings.add(input.nextLine());
         }

         Solution solution = new Solution();
         System.out.println("Case #" + j + ": " + solution.solve(strings));

      }

   }

   public String solve(ArrayList<String> strings) {
      String smallest = findSmallestString(strings);

      if (!isMatchPossible(smallest, strings))
         return "*";

      return findMatchingString(strings);
   }

   public String findMatchingString(ArrayList<String> strings) {
      String longestString = findLongestStirng(strings).replace("*", "");

      for (int i = 0; i < strings.size(); i++) {
         if (!longestString.contains(strings.get(i).replace("*", "")))
            return "*";

      }

      return longestString;
   }

   public boolean isMatchPossible(String smallest, ArrayList<String> strings) {
      for (String s : strings) {
         if (!s.replace("*", "").endsWith(smallest.replace("*", "")))
            return false;
      }
      return true;
   }

   public String findSmallestString(ArrayList<String> strings) {

      String shortest = strings.get(0);

      for (String str : strings) {
         if (str.length() < shortest.length()) {
            shortest = str;
         }
      }

      return shortest;
   }

   public String findLongestStirng(ArrayList<String> strings) {

      String largest = "";

      for (int i = 0; i < strings.size(); i++) {
         if (strings.get(i).length() > largest.length()) {
            largest = strings.get(i);
         }
      }
      return largest;
   }

}