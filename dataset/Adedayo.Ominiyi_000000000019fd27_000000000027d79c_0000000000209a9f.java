import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Adedayo Ominiyi
 */
public class Solution {

  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));) {
      final int numberOfTestCases = Integer.parseInt(scanner.nextLine());

      for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
        final String line = scanner.nextLine();

        final char[] lineChars = line.toCharArray();
        final StringBuilder builder = new StringBuilder();
        
        final int firstNumber = lineChars[0] - '0';
        for (int i = 0; i < firstNumber; i++) {
          builder.append('(');
        }
        builder.append(firstNumber);
        
        int prevNumber = firstNumber;
        for (int i = 1; i < lineChars.length; i++) {
          final int currentNumber = lineChars[i] - '0';
          
          if (currentNumber  == prevNumber) {
            builder.append(currentNumber);
          }
          
          if (currentNumber < prevNumber) {
            final int difference = prevNumber - currentNumber;
            for (int j = 0; j < difference; j++) {
              builder.append(')');
            }
            builder.append(currentNumber);
          }
          
          if (currentNumber > prevNumber) {
            final int difference = currentNumber - prevNumber;
            for (int j = 0; j < difference; j++) {
              builder.append('(');
            }
            builder.append(currentNumber);
          }
          
          prevNumber = currentNumber;
        }
        
        for (int i = 0; i < prevNumber; i++) {
          builder.append(')');
        }
        
        System.out.println(String.format("Case #%d: %s", testCase + 1,
                builder.toString()));
      }
    }
  }
}
