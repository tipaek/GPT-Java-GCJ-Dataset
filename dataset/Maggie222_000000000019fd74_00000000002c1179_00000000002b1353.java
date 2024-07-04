import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    // Scanner has functions to read ints, longs, strings, chars, etc.
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
    int caseNum = input.nextInt();
    input.nextLine();

    for(int i = 1; i <= caseNum; i ++) {
      int sum = Integer.valueOf(input.nextLine());
      List<String> result = solve(sum);
      out.println("Case #" + i + ":");
      for(String s : result) {

        out.println(s);
      }
    }
  }

  private static List<String> solve(int sum) {
    List<String> steps = new ArrayList<>();
    steps.add("1 1");
    int currentSum = 1;
    if(sum == 1) {
      return steps;
    }
    int row = 2;
    while(currentSum < sum) {
      if(sum - currentSum < row - 1) {
        row = row - 1;
        for(int count = 0; count < sum - currentSum; count ++) {
          steps.add(row + " " + row);
          row ++;
        }
        return steps;
      } else {
        steps.add((row) + " " + (row - 1));
        currentSum += row - 1;
      }
      row ++;
    }
    return steps;
  }
}