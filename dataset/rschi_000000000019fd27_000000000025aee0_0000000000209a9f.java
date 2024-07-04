import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {


  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int a = 1; a <= t; ++a) {
      final String digitString = in.next();
      Digits d = new Digits(a, digitString);

      Printer.print(d);
    }
  }
}


class Digits{
  int id;
  String format;

  public Digits(int id, String digits) {
    this.id = id;
    this.format = Arrays.stream(digits.split(""))
        .mapToInt(Integer::parseInt)
        .mapToObj(it -> formatDigit(it))
        .reduce("", (x, y) -> reducePadding(x, y));

  }

  private String reducePadding(String x, String y) {
   String result = x+y;
   while(result.contains(")(")){
     result =result.replace(")(", "");
    }
    return result;
  }

  private String formatDigit(int it) {
    String result = pad(it, "(");
    result += it;
    result += pad(it, ")");
    return result;
  }

  private String pad(int it, String padding) {
    String result = "";
    for (int i = 0; i < it ; i++) {
      result+= padding;
    }
    return result;
  }
}

  class Printer {


  static void print(Digits d) {
    System.out.println("Case #"+ d.id + ": " +d.format);
  }


}