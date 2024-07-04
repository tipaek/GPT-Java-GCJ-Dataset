import java.util.Scanner;

//********************************************************************************************************
//********************************************************************************************************
public class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;
  
  static int x;
  static int y;
  static char[] line;
  
  static int board[][];
  
  public static void main(String[] args) {
    t = scanner.nextInt();
    scanner.nextLine();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  // ***************************************************************************
  // INPUT
  // ***************************************************************************
  static void read() {    
    x = scanner.nextInt();
    y = scanner.nextInt();
    line = scanner.nextLine().toCharArray();    
 }
  
  static void prb() {
    read();
    int t = 0;
    boolean found = ok(t, x, y);
    
    int i = 1;
    while(i != line.length && !found) {
      t++;
      
      char current = line[i];
      if (current == 'S') {
        y--;
      } else if (current == 'N') {
        y++;
      } else if (current == 'W') {
        x--;
      } else {
        x++;
      }
      found = ok(t, x, y);
      i++;
    }
    
    if (!found) {
      System.out.printf("Case #%d: IMPOSSIBLE\n", num);      
    } else {
      System.out.printf("Case #%d: %d\n", num, t);      
    }
  }
  
  static boolean ok(int t, int x, int y) {
    return abs(x) + abs(y) <= t;
  }
  
  static int abs(int x) {
    if (x < 0) {
      x = -x;
    }
    return x;
  }
}