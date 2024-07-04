import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int size = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    ArrayList<Integer> test = new ArrayList<Integer>(size);
    for (int i = 0; i < size; i++) {
      test.add(in.nextInt());
    }

    for (int i = 0; i < size; i++) {
        int j = i + 1;
        System.out.println("Case #" + j + ": ");
        for (int k = 0; k < test.get(i); k++) {
          int h = k+1;
          System.out.println(h + " 1");
        }
    }
  }
}