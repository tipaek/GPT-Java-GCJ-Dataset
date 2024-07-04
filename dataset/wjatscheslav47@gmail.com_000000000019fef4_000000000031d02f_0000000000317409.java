import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{

  public static void main(String[] args)
  {
    List<String> output = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int numberOfTestCases = sc.nextInt();
    for (int i = 0; i < numberOfTestCases; i++)
    {
      int eastShift = sc.nextInt();
      int northShift = sc.nextInt();
      char[] directions = sc.next().toCharArray();
      output.add(findIntersection(eastShift, northShift, directions, i + 1));
    }

    for (String s : output)
    {
      System.out.println(s);
    }
  }

  private static String findIntersection(int eastShift, int northShift, char[] directions, int testCaseNumber)
  {
    String result = null;
    int xCoord = eastShift;
    int yCoord = northShift;
    int currentMinute = 0;
    int distanceFromInitialPoint = eastShift + northShift;
    for (int i = 0; i < directions.length; i++)
    {
      char direction = directions[i];
      switch (direction)
      {
        case 'S':
          if (yCoord <= 0)
          {
            distanceFromInitialPoint++;
          }
          else
          {
            distanceFromInitialPoint--;
          }
          yCoord--;
          break;
        case 'N':
          if (yCoord < 0)
          {
            distanceFromInitialPoint--;
          }
          else
          {
            distanceFromInitialPoint++;
          }
          yCoord++;
          break;
        case 'E':
          if (xCoord < 0)
          {
            distanceFromInitialPoint--;
          }
          else
          {
            distanceFromInitialPoint++;
          }
          xCoord++;
          break;
        case 'W':
          if (xCoord <= 0)
          {
            distanceFromInitialPoint++;
          }
          else
          {
            distanceFromInitialPoint--;
          }
          xCoord--;
          break;
        default:
          break;
      }

      currentMinute++;

      if (distanceFromInitialPoint <= currentMinute)
      {
        result = String.valueOf(currentMinute);
        break;
      }
    }

    if (result == null)
    {
      return String.format("Case #%d: IMPOSSIBLE", testCaseNumber);
    }
    else
    {
      return String.format("Case #%d: %s", testCaseNumber, result);
    }
  }

}
