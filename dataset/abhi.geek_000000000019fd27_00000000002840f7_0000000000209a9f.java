import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String input;
    int totalTestCases = -1, testCaseCounter = 1;

    input = scan.nextLine().trim();
    totalTestCases = totalTestCases == -1 ? Integer.parseInt(input) : totalTestCases;

    while (testCaseCounter <= totalTestCases && scan.hasNextLine()) {
      input = scan.nextLine().trim();

      System.out.println("Case #" + testCaseCounter + ": " + addBraces(input));
      ++testCaseCounter;
    }
  }

  private static String addBraces(String input) {
    StringBuilder result = new StringBuilder();
    char ZERO = '0';
    int inputNum = -1, prevInputNum = -1, openBracesCount = 0;

    if(input == null || input.trim().length() == 0) {
      return input;
    }

    int size = input.trim().length();
    inputNum = input.charAt(0) - ZERO;

    for(int i = 0; i < inputNum; i++) {
      result.append('(');
    }
    openBracesCount = inputNum;
    result.append(inputNum);


    for(int i = 1; i < size; i++) {
      prevInputNum = inputNum;
      inputNum = input.charAt(i) - ZERO;

      if(prevInputNum != inputNum) {
        if(prevInputNum < inputNum) {
          for(int j = 0; j < inputNum - openBracesCount; j++) {
            result.append('(');
          }
          openBracesCount += (inputNum - openBracesCount);
        } else {
          for(int j = 0; j < prevInputNum - inputNum; j++) {
            result.append(')');
          }
          openBracesCount -= (prevInputNum - inputNum);
        }
      }
      result.append(inputNum);
    }

    for(int i = 0; i < openBracesCount; i++) {
      result.append(')');
    }
    openBracesCount = 0;

    return result.toString();
  }
}