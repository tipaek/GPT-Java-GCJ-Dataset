import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution
{

  public static void main(String[] args)
  {
    List<String> output = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int numberOfTestCases = sc.nextInt();
    for (int i = 0; i < numberOfTestCases; i++)
    {
      int numberOfDigits = sc.nextInt();
      output.add(findKeyString(sc, numberOfDigits, i + 1));
    }

    for (String s : output)
    {
      System.out.println(s);
    }
  }

  private static String findKeyString(Scanner sc, int numberOfDigits, int testCaseNumber)
  {
    Map<Character, Set<Integer>> availableNumbersForChar = new HashMap<>();
    for (int i = 0; i < 1000; i++)
    {
      int inputNumber = sc.nextInt();
      char[] response = sc.next().toCharArray();
      initWithChars(availableNumbersForChar, response);
      // handle fist character
      availableNumbersForChar.get(response[0]).remove(0);

      if (response.length == 1 && inputNumber < 10)
      {
        availableNumbersForChar.get(response[0]).removeIf(number -> number > inputNumber);
      }

      //handle all other characters
      if (response.length > 1)
      {
        int highNumber = inputNumber / 10 * (numberOfDigits - 1);
        availableNumbersForChar.get(response[0]).removeIf(number -> number > highNumber);
      }
      boolean isResolved = checkMapAndGetStatus(availableNumbersForChar);
      if (isResolved)
      {
        break;
      }
    }

    return String.format("Case #%d: %s", testCaseNumber, getResultFromMap(availableNumbersForChar));

  }

  private static String getResultFromMap(Map<Character, Set<Integer>> availableNumbersForChar)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++)
    {
      int finalI = i;
      Character key = availableNumbersForChar.entrySet().stream()
          .filter(entry -> entry.getValue().stream().findFirst().get() == finalI)
          .findFirst().get().getKey();

      sb.append(key);
    }

    return sb.toString();
  }

  private static boolean checkMapAndGetStatus(Map<Character, Set<Integer>> availableNumbersForChar)
  {
    boolean isResolved = true;
    for (Map.Entry<Character, Set<Integer>> entry : availableNumbersForChar.entrySet())
    {
      if (entry.getValue().size() == 1)
      {
        clearEntriesExcept(availableNumbersForChar, entry);
      }
    }
    if (availableNumbersForChar.size() == 10)
    {
      clearByNumbers(availableNumbersForChar);
    }
    for (Map.Entry<Character, Set<Integer>> entry : availableNumbersForChar.entrySet())
    {
      if (entry.getValue().size() > 1)
      {
        isResolved = false;
        break;
      }
    }

    return isResolved;
  }

  private static void clearByNumbers(Map<Character, Set<Integer>> availableNumbersForChar)
  {
    Map<Integer, Integer> countForNumbers = new HashMap<>();

    for (Map.Entry<Character, Set<Integer>> entry : availableNumbersForChar.entrySet())
    {
      entry.getValue().forEach(num -> {
            if (countForNumbers.containsKey(num))
            {
              countForNumbers.put(num, countForNumbers.get(num) + 1);
            }
            else
            {
              countForNumbers.put(num, 1);
            }
          });
    }

    for (Map.Entry<Integer, Integer> count : countForNumbers.entrySet())
    {
      if (count.getValue() == 1)
      {
        availableNumbersForChar.values().forEach(values -> {
              if (values.contains(count.getKey()) && values.size() != 1)
              {
                values.removeIf(value -> !value.equals(count.getKey()));
              }
            });
      }
    }
  }

  private static void clearEntriesExcept(Map<Character, Set<Integer>> availableNumbersForChar,
                                         Map.Entry<Character, Set<Integer>> entryEx)
  {
    for (Map.Entry<Character, Set<Integer>> entry : availableNumbersForChar.entrySet())
    {
      if (entry.getKey().equals(entryEx.getKey()))
      {
        continue;
      }

      if (entry.getValue().size() != 1)
      {
        entry.getValue().remove(entryEx.getValue().stream().findFirst().get());
      }
    }

  }


  private static void initWithChars(Map<Character, Set<Integer>> availableNumbersForChar, char[] response)
  {
    if (availableNumbersForChar.size() < 10)
    {
      for (char ch : response)
      {
        if (!availableNumbersForChar.containsKey(ch))
        {
          availableNumbersForChar.put(ch, new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        }
      }
    }
  }

}
