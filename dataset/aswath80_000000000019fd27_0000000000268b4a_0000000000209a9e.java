import java.io.*;
import java.util.*;

class Solution {
  private static Scanner scanner = new Scanner(System.in);
  private static PrintWriter output = new PrintWriter(System.out);

  private static int sendAndReceive(int pos) {
    output.print(pos);
    output.flush();
    return scanner.nextInt();
  }

  private static char sendAndReceive(int[] bitArray) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < bitArray.length; i++) {
      sb.append(bitArray[i]);
    }
    output.print(sb.toString());
    output.flush();
    return (char) scanner.nextInt();
  }

  public static void main(String[] args) {
    String input = scanner.nextLine();
    int tc = Integer.parseInt(input.split(" ")[0].trim());
    int bits = Integer.parseInt(input.split(" ")[1].trim());
    boolean pass = true;
    for (int i = 0; pass && i < tc; i++) {
      pass = solve(i, bits);
    }
  }

  private static boolean solve(int t, int bits) {
    int[] bitArray = new int[bits];
    int tries = 0;
    char status = 'N';
    while (tries < 150) {
      for (int i = 0; i < bitArray.length; i++) {
        bitArray[i] = sendAndReceive(i+1);
      }
      status = sendAndReceive(bitArray);
      break;
    }
    return (status == 'Y');
  }
}