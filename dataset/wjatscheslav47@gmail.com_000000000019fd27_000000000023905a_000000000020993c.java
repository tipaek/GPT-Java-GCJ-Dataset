import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution
{

  public static void main(String[] args)
  {
    List<String> output = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int numberOfTestCases = Integer.valueOf(sc.nextLine());
    for (int i = 0; i < numberOfTestCases; i++)
    {
      int matrixSize = Integer.valueOf(sc.nextLine());

      String[][] matrix = new String[matrixSize][matrixSize];
      for (int j = 0; j < matrixSize; j++)
      {
        matrix[j] = sc.nextLine().split(" ");
      }
      output.add(analyzeMatrix(matrix, i));
    }

    for (String s : output)
    {
      System.out.println(s);
    }
  }

  private static String analyzeMatrix(String[][] matrix, int caseNumber)
  {
    int trace = 0;
    int rowsWithDubs = 0;
    int columnsWithDubs = 0;
    for (int i = 0; i < matrix.length; i++)
    {
      trace += Integer.valueOf(matrix[i][i]);
    }
    for (int i = 0; i < matrix.length; i++)
    {
      Set<Integer> uniqueSymbols = new HashSet<>();
      for (int j = 0; j < matrix.length; j++)
      {
        if (uniqueSymbols.contains(Integer.valueOf(matrix[i][j])))
        {
          rowsWithDubs++;
          break;
        }
        uniqueSymbols.add(Integer.valueOf(matrix[i][j]));
      }
    }

    for (int i = 0; i < matrix.length; i++)
    {
      Set<Integer> uniqueSymbols = new HashSet<>();
      for (int j = 0; j < matrix.length; j++)
      {
        if (uniqueSymbols.contains(Integer.valueOf(matrix[j][i])))
        {
          columnsWithDubs++;
          break;
        }
        uniqueSymbols.add(Integer.valueOf(matrix[j][i]));
      }
    }

    return String.format("Case #%d: %d %d %d", caseNumber, trace, rowsWithDubs, columnsWithDubs);

  }

}
