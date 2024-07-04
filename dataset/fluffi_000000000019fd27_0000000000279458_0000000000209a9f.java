import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.lang.Integer.parseInt;

public class Solution {

  public static class Context {
    String string;
    int depth;

    public Context(String string) {
      this.string = string;
    }
  }

  public static Function<Context, String> SOLUTION = input -> {
    String result = "";
    int last = -1;
    for (int i = 0; i < input.string.length(); i++) {
      int current = Integer.parseInt(input.string.substring(i, i + 1));
      if (last == -1) {
        last = current;
      }
      while(current > input.depth) {
        result += "(";
        input.depth++;
      }

      for (int j = current; j < last; j++) {
        result += ")";
        input.depth--;
      }
      result += current;
      last = current;
    }
    while (input.depth > 0) {
      result += ")";
      input.depth--;
    }
    return result;
  };

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(args.length > 0 ? new FileInputStream(args[0]) : System.in));

    List<Solution.Result> results = new ArrayList<>();

    // # of tests
    int t = parseInt(in.readLine());

    // per test...
    for (int i = 0; i < t; i++) {
      results.add(new Result(i + 1, SOLUTION.apply(new Context(in.readLine()))));
    }

    OutputStream out = args.length > 0 ? new FileOutputStream(args[1]) : System.out;
    for (Result result : results) {
      out.write((result.toString() + "\n").getBytes());
    }
  }

  public static class Result {
    public int n;
    public String result;

    public Result(int n, String result) {
      this.n = n;
      this.result = result;
    }

    @Override
    public String toString() {
      return "Case #" + n + ": " + result;
    }
  }
}
