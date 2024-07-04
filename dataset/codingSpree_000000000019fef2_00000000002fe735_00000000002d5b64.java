import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int j = 1; j <= t; ++j) {
        int r = in.nextInt();
        int s = in.nextInt();
        ArrayList<Integer> res = findOrder(r, s);
        int num = res.size()/2;
        System.out.println("Case #" + j + ": " + num);
        for (int i  = 0; i < res.size(); i++) {
            System.out.println(res.get(i++) + " " + res.get(i));
        }
    }
  }
  
  public static ArrayList<Integer> findOrder(int rank, int suit) {
       ArrayList<Integer> steps = new ArrayList<>();
       int r = rank-1;
       int sCount = 0;
       for (int i = rank * (suit - 1); i >= suit; i--) {
           steps.add(i);
           steps.add(r);
           sCount++;
           if (sCount == suit - 1) {
               sCount = 0;
               r--;
           }
       }
       return steps;
  }
  
}