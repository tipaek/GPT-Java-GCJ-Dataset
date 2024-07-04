import java.util.Scanner;
import java.util.Stack;

public class Solution {
 static String result = "";
 static Stack < String > stack;

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int caseNo = 1;
  int test = sc.nextInt();
  while (test--> 0) {
   result = "";
   stack = new Stack < String > ();
   char[] testCase = sc.next().toCharArray();
   for (int i = 0; i < testCase.length; i++) {
    if (Integer.parseInt(String.valueOf(testCase[i])) > stack.size())
     pushIntoStack(testCase[i]);
    else if (Integer.parseInt(String.valueOf(testCase[i])) < stack.size())
     popFromStack(testCase[i]);
    else
     result += testCase[i];
   }
   while (!stack.empty()) {
    stack.pop();
    result += ")";
   }
   System.out.println("Case #" + caseNo + ": " + result);
   caseNo++;
  }
  sc.close();
 }

 private static void popFromStack(char number) {
  while (Integer.parseInt(String.valueOf(number)) < stack.size()) {
   result += ")";
   stack.pop();
  }
  result = result + number;
 }

 private static void pushIntoStack(char number) {
  while (Integer.parseInt(String.valueOf(number)) > stack.size()) {
   result += "(";
   stack.push("(");
  }
  result = result + number;
 }
}