import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    new Solution().run();
  }

  Scanner in = null;
  private int queries;

  public void run() {

    try {
      in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int cases = in.nextInt(), length = in.nextInt();
      int modulo = 10;
      for (int tCase = 1; tCase <= cases; ++tCase) {
        char[] output = new char[length];
        boolean[] parity = new boolean[length];
        int bitsKnown = 0;

        int lastParity = -1, lastImparity = -1;

        queries = 0;

        while (bitsKnown < length || queries % modulo == 0) {
          if (bitsKnown > 0 && queries % modulo == 0) {
            boolean invertParity = false, invertImparity = false;
            if (lastParity >= 0) {
              int check = ask(lastParity);
              if (check != output[lastParity - 1])
                invertParity = true;
            } else
              ask(1);
            if (lastImparity >= 0) {
              int check = ask(lastImparity);
              if (check != output[lastImparity - 1])
                invertImparity = true;
            } else
              ask(1);
            invert(output, parity, invertParity, invertImparity);
          } else {
            int position = bitsKnown / 2 + 1;
            output[position - 1] = ask(position);
            output[length - position] = ask(length - position + 1);
            if (output[position - 1] == output[length - position]) {
              lastParity = position;
              parity[position - 1] = true;
            } else {
              lastImparity = position;
              parity[position - 1] = false;
            }
            bitsKnown += 2;
          }
        }

        System.out.println(output);
        in.nextLine();
        System.err.print("Judgement #" + tCase + " on ");
        System.err.print(output);
        String judge = in.nextLine();
        System.err.println(": " + judge);

        if (!judge.equals("Y"))
          break;
      }

    } finally {
      if (in != null)
        in.close();
    }
  }

  private void invert(char[] output, boolean[] parity, boolean invertParity, boolean invertImparity) {
    for (int i = 0; i < output.length / 2; ++i) {
      if (invertParity && parity[i]) {
        invert(output, i);
        invert(output, output.length - i - 1);
      }
      if (invertImparity && !parity[i]) {
        invert(output, i);
        invert(output, output.length - i - 1);
      }
    }
  }

  private void invert(char[] output, int pos) {
    output[pos] = output[pos] == '0' ? '1' : '0';
  }

  private char ask(int position) {
    System.out.println(position);
    System.out.flush();
    int answer = in.nextInt();
    queries++;
    return answer == 1 ? '1' : '0';
  }
}
