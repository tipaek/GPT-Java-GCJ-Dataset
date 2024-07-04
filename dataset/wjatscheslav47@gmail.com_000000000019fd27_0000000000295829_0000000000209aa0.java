import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
      String[] in = sc.nextLine().split(" ");
      int matrixRange = Integer.valueOf(in[0]);
      int trace = Integer.valueOf(in[1]);
      output.add(analyzeMatrix(matrixRange, trace, i + 1));
    }

    for (String s : output)
    {
      System.out.println(s);
    }
  }

  private static String analyzeMatrix(int matrixRange, int trace, int testCaseNumber)
  {
    Set<Integer> possibleTraces = getPossibleTraces(matrixRange);
    if (!possibleTraces.contains(trace))
    {
      return String.format("Case #%d: IMPOSSIBLE", testCaseNumber);
    }

    String matrixString = matrixRange % 2 == 1 ? getMatrixStringOdd(matrixRange, trace) : getMatrixStringEven(matrixRange, trace);

    return String.format("Case #%d: POSSIBLE\n%s", testCaseNumber, matrixString);
  }

  private static String getMatrixStringEven(int matrixRange, int trace)
  {
    StringBuilder sb = new StringBuilder();
    int startElement;
    if (trace % matrixRange == 0)
    {
      startElement = trace / matrixRange;
      int[][] matrix = new int[matrixRange][matrixRange];
      matrix[0][0] = startElement;
      for (int i = 1; i < matrixRange; i++)
      {
        matrix[0][i] = getDown(matrix[0][i - 1], matrixRange);
      }
      for (int i = 0; i < matrixRange; i++)
      {
        for (int j = 0; j < matrixRange; j++)
        {
          if (i == 0)
          {
            if (j == matrixRange - 1)
            {
              sb.append(matrix[i][j]);
            }
            else
            {
              sb.append(matrix[i][j]).append(" ");
            }
            continue;
          }
          int el = getUp(matrix[i - 1][j], matrixRange);
          matrix[i][j] = el;
          if (j == matrixRange - 1)
          {
            sb.append(el);
          }
          else
          {
            sb.append(el).append(" ");
          }
        }
        if (i != matrixRange - 1)
        {
          sb.append("\n");
        }
      }
    }
    else
    {
      int[][] matrix = new int[matrixRange][matrixRange];
      fillFirstColumnAndRow(trace, matrix, matrixRange);
      for (int i = 0; i < matrixRange; i++)
      {
        for (int j = 0; j < matrixRange; j++)
        {
          if (j == 0 || i == 0)
          {
            if (j == matrixRange - 1)
            {
              sb.append(matrix[i][j]);
            }
            else
            {
              sb.append(matrix[i][j]).append(" ");
            }
            continue;
          }

          int el = j + 1 >= matrixRange ? matrix[i - 1][0] : matrix[i - 1][j + 1];
          matrix[i][j] = el;
          if (j == matrixRange - 1)
          {
            sb.append(el);
          }
          else
          {
            sb.append(el).append(" ");
          }
        }
        if (i != matrixRange - 1)
        {
          sb.append("\n");
        }
      }
    }

    return sb.toString();
  }

  private static void fillFirstColumnAndRow(int trace, int[][] matrix, int matrixRange)
  {
    Deque<Integer> traceNumbers = new ArrayDeque<>();
    Deque<Integer> nonTraceNumbers = new ArrayDeque<>();
    int halfTrace = trace / 2;

    int iteration = 0;
    while (iteration <= matrixRange)
    {
      for (int j = matrixRange; j > 0; j--)
      {
        if (halfTrace >= j && j <= matrixRange - iteration)
        {
          traceNumbers.add(j);
          halfTrace -= j;
        }
        else
        {
          nonTraceNumbers.add(j);
        }
      }
      if (traceNumbers.size() == nonTraceNumbers.size())
      {
        break;
      }
      else
      {
        traceNumbers.clear();
        nonTraceNumbers.clear();
        halfTrace = trace / 2;
        iteration++;
      }
    }

    for (int i = 0; i < matrixRange; i++)
    {
      if (i % 2 == 0)
      {
        int el = traceNumbers.pollFirst();
        matrix[i][0] = el;
        matrix[0][i] = el;
      }
      else
      {
        int el = nonTraceNumbers.pollFirst();
        matrix[i][0] = el;
        matrix[0][i] = el;
      }
    }
  }

  private static String getMatrixStringOdd(int matrixRange, int trace)
  {
    StringBuilder sb = new StringBuilder();
    int startElement;

    startElement = trace / matrixRange;
    int[][] matrix = new int[matrixRange][matrixRange];
    matrix[0][0] = startElement;
    for (int i = 1; i < matrixRange; i++)
    {
      matrix[0][i] = getUp(matrix[0][i - 1], matrixRange);
    }
    for (int i = 0; i < matrixRange; i++)
    {
      for (int j = 0; j < matrixRange; j++)
      {
        if (i == 0)
        {
          if (j == matrixRange - 1)
          {
            sb.append(matrix[i][j]);
          }
          else
          {
            sb.append(matrix[i][j]).append(" ");
          }
          continue;
        }
        int el = getDown(matrix[i - 1][j], matrixRange);
        matrix[i][j] = el;
        if (j == matrixRange - 1)
        {
          sb.append(el);
        }
        else
        {
          sb.append(el).append(" ");
        }
      }
      if (i != matrixRange - 1)
      {
        sb.append("\n");
      }
    }

    return sb.toString();
  }

  private static int getDown(int previousEl, int matrixRange)
  {
    return previousEl - 1 == 0 ? matrixRange : previousEl - 1;
  }

  private static int getUp(int previousEl, int matrixRange)
  {
    return previousEl + 1 > matrixRange ? 1 : previousEl + 1;
  }

  private static Set<Integer> getPossibleTraces(int matrixRange)
  {
    Set<Integer> traces = new HashSet<>();
    for (int i = 0; i < matrixRange; i++)
    {
      traces.add((i + 1) * matrixRange);
    }

    if (matrixRange % 2 == 0)
    {
      int min = getSum(1, matrixRange / 2) * 2;
      int max = getSum(matrixRange / 2 + 1, matrixRange) * 2;
      for (int i = min; i <= max; i += 2)
      {
        traces.add(i);
      }
    }
    else
    {
      traces.add(matrixRange * (matrixRange + 1) / 2);
    }
    return traces;
  }

  private static int getSum(int from, int to)
  {
    int sum = 0;
    for (int i = from; i <= to; i++)
    {
      sum += i;
    }

    return sum;
  }

}
