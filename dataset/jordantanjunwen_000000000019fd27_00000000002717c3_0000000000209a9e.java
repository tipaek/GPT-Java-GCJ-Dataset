import java.util.*;
import java.io.*;
public class Solution {
  static char[] complimentString(char[] c) {
   for (int i = 0; i < c.length; i++) {
    c[i] = c[i] == '0' ? '1' : '0';
   }
   return c;
  }

  static char[] reversalString(char[] c) {
   char[] newChar = new char[c.length];
   for (int i = c.length - 1; i >= 0; i--) {
    newChar[c.length - 1 - i] = c[i];
   }
   return newChar;
  }

public static void main(String[] args) {
  Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
   String[] tb = scanner.nextLine().split(" ");

   int t = Integer.parseInt(tb[0]);
   int b = Integer.parseInt(tb[1]);
   for (int i = 0; i < t; i++) {
    char[] array = new char[b];
    String input=scanner.nextLine();
    for (int j = 0; j < b; j++) {
     array[j] = input.charAt(j);
    }

    if (i % 10 == 1) {
     int num = new Random().nextInt(4 + 1) + 1;
     if (num == 1 || num == 3) {
      array = complimentString(array);
     } else if (num == 2 || num == 3) {
      array = reversalString(array);
     }
    }

    int queryNum = scanner.nextInt();

    System.out.println(Arrays.binarySearch(array, (char)queryNum));

    for (char c: array) {
     System.out.print(c);
    }
    if (scanner.nextLine() == "N") {
     break;
    }
   }
  }
 }