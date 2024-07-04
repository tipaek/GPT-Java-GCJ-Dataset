import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{

  public static void main(String[] args)
  {
    List<String> output = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int numberOfTestCases = Integer.valueOf(sc.nextLine());
    for (int i = 0; i < numberOfTestCases; i++)
    {
      String s = sc.nextLine();
      output.add(analyzeString(s, i + 1));
    }

    for (String s : output)
    {
      System.out.println(s);
    }
  }

  private static String analyzeString(String s, int testCaseNumber)
  {
    StringBuilder sb = new StringBuilder();
    int currentLevel = 0;
    for (int i = 0; i < s.length(); i++)
    {
      int num = Integer.valueOf(String.valueOf(s.charAt(i)));
      int diff = currentLevel - num;
      currentLevel = num;
      if (diff < 0)
      {
        sb.append("(".repeat(Math.max(0, Math.abs(diff))));
      }
      else if (diff > 0)
      {
        sb.append(")".repeat(Math.abs(diff)));
      }
      sb.append(num);
      if (i + 1 == s.length())
      {
        int lastNum = Integer.valueOf(String.valueOf(s.charAt(i)));
        sb.append(")".repeat(Math.max(0, lastNum)));
      }
    }

    return String.format("Case #%d: %s", testCaseNumber, sb.toString());
  }

}
