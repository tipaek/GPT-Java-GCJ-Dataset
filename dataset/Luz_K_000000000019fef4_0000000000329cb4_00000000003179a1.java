import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    String possiblechars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int[][] numbers = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0},{9,0},{10,0},{11,0},{12,0},{13,0},{14,0},{15,0},{16,0},{17,0},{18,0},{19,0},{20,0},{21,0},{22,0},{23,0},{24,0},{25,0},{26,0}};
    for (int i = 1; i <= t; ++i) {
    		int x = in.nextInt();
    		in.nextLine();
    		StringBuilder strBuilder = new StringBuilder();
    		for(int y = 1; y < 10000;y++) {
    			strBuilder.append(in.nextLine().split(" ")[1]);
    		}
    		for(int y = 0; y < possiblechars.length();y++) {
    			numbers[y][1] = countChar(strBuilder.toString(),possiblechars.charAt(y));
    		}
    		Arrays.sort(numbers, (a, b) -> Integer.compare(a[1], b[1]));
    		System.out.print("Case #" + i + ": ");
    		for(int y = 0; y <= 9; y++) {
    			 System.out.print(possiblechars.charAt(numbers[y][0]-1));
    		}
    		System.out.println();
    }
  }
  public static int countChar(String str, char c)
  {
      int count = 0;
      for(int i = 0; i < str.length(); i++)
      {    if(str.charAt(i) == c)
              count++;
      }
      return count;
  }
}