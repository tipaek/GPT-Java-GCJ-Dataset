import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases;
    testCases = sc.nextInt();

    for (int testCase = 1; testCase <= testCases; testCase++) {
      String inputString = sc.next();
      System.out.print("Case #" + testCase + ": ");
      Stack<Character> characterStack = new Stack<Character>();
      for (int i = inputString.length() - 1; i >= 0; i--) {
        int number = inputString.charAt(i) - '0';
        for (int k = 0; k < number; k++) {
          characterStack.push(')');
        }
        characterStack.push(inputString.charAt(i));
        for (int k = 0; k < number; k++) {
          characterStack.push('(');
        }
      }
      Stack<Character> updatedStack = new Stack<Character>();
      while (!characterStack.isEmpty()) {
        Character current = characterStack.pop();
        if (updatedStack.isEmpty() || (current >= '0' && current <= '9')) {
          updatedStack.push(current);
        } else {
          if (current.equals('(') && updatedStack.peek().equals(')')) {
            updatedStack.pop();
          } else {
            updatedStack.push(current);
          }
        }
      }
      StringBuffer stringBuffer = new StringBuffer();
      while (!updatedStack.isEmpty()) {
        stringBuffer.append(updatedStack.pop());
      }
      System.out.println(stringBuffer.reverse().toString());
    }
  }
}