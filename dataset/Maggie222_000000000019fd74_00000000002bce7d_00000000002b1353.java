import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    // Scanner has functions to read ints, longs, strings, chars, etc.
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int caseNum = input.nextInt();
    input.nextLine();

    for(int i = 1; i <= caseNum; i ++) {
      int sum = Integer.valueOf(input.nextLine());
      out.println("Case #" + i + ":");
      for(int j = 0; j < sum; j ++) {
        out.println((j + 1) + " " + 1);
      }
    }
  }
}