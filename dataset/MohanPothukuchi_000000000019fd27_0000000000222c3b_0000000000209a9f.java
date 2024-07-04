import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numTests = Integer.parseInt(in.nextLine());

    for (int i=0;i <numTests;i++) {
      String useCase = in.nextLine();
      String[] elements = useCase.split("");
      LinkedList<String> digits = new LinkedList<>(Arrays.asList(elements));
      nestedString(i, digits);
    }
  }

  private static void nestedString(int numTest, LinkedList<String> digits) {
    int bracketSoFar = 0;

    for (int index=0;index<digits.size();index++) {
      int element = Integer.parseInt(digits.get(index));

      if (element > bracketSoFar) {
        for (int i=0; i < element - bracketSoFar;i++) {
          digits.add(index, "(");
          index += 1;
        }
      } else if (bracketSoFar > element) {
        for (int i=0; i < bracketSoFar - element;i++) {
          digits.add(index, ")");
          index += 1;
        }
      }

      bracketSoFar = element;
    }

    if (bracketSoFar > 0) {
      for (int i=0; i<bracketSoFar; i++) {
        digits.addLast(")");
      }
    }

    numTest++;
    String result = digits.toString().replace("[","").replace("]","").replace(",","");
    System.out.println("Case #" +numTest + ": " + result);
  }
}
