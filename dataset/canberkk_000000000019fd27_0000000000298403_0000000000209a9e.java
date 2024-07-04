import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    String[] ss = in.nextLine().split(" ");
    int cases = Integer.parseInt(ss[0]);
    int B = Integer.parseInt(ss[1]);
    int[][] bits = new int[4][B];
    boolean[] valid = new boolean[4];
    int known = 0;
    int beforeShuffle = 10;

    for (int c = 1; c <= cases; c++) {
      known = 0;
      for (int i = 0; i < B; i++) {
        bits[0][i] = -1;
      }
      while (known <= B/2) {
        if(beforeShuffle == 0){
          for (int i = 0; i < B ; i++) {
            if(bits[0][i]==-1){
              bits[1][i] = -1;
              bits[2][B-i-1] = -1;
              bits[3][B-i-1] = -1;
            } else {
              bits[1][i] = 1-bits[0][i]; //complement
              bits[2][B-i-1] = bits[0][i]; //reverse
              bits[3][B-i-1] = 1-bits[0][i]; //both
            }
          }
          beforeShuffle = 10;
          for (int i = 0; i < 4; i++) valid[i] = true;
          int index = chooseTest(bits,valid);
          do {
            out.println(index + 1);
            out.flush();
            beforeShuffle--;
            int result = Integer.parseInt(in.nextLine());
            for (int i = 0; i < 4; i++) {
              valid[i] = valid[i] && result == bits[i][index];
            }
            index = chooseTest(bits,valid);
          } while (index != -1);
          int i = 0;
          while (!valid[i]) i++;
          bits[0] = bits[i].clone();
        }

        while (beforeShuffle > 0 && known <= B / 2) {
          if (bits[0][known] == -1) {
            out.println(known + 1);
            out.flush();
            beforeShuffle--;
            bits[0][known] = Integer.parseInt(in.nextLine());
          } else if (bits[0][B - known - 1] == -1) {
            out.println(B - known);
            out.flush();
            beforeShuffle--;
            bits[0][B - known - 1] = Integer.parseInt(in.nextLine());
          } else known++;
        }
      }
      String guess = "";
      for (int bit : bits[0]) guess += bit;
      out.println(guess);
      out.flush();
      if(in.nextLine()=="N") System.exit(1);
    }
    in.close();
    out.close();
  }

  private static int chooseTest(int[][] bits, boolean[] valid) {
    int vCount = 0;
    for (int i = 0; i < 4; i++) if(valid[i]) vCount++;
    if (vCount == 1) return -1;
    for (int i = 0; i < bits[0].length; i++) {
      int zeroes = 0;
      int ones = 0;
      for (int j = 0; j < 4; j++) {
        if(valid[j] && bits[j][i] == 0) zeroes++;
        if(valid[j] && bits[j][i] == 1) ones++;
      }
      if(Math.min(zeroes,ones)==vCount/2) return  i;
    }
    return  -1;
  }
}