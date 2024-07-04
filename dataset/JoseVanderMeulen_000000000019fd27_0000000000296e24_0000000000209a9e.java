import java.util.Scanner;

//********************************************************************************************
//ESAb ATAd
//https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27
//********************************************************************************************
class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;
  
  static int B;
  static int sz;
  static int[] line = new int[100];

  public static void main(String[] args) {
    t = scanner.nextInt();
    B = scanner.nextInt();
    scanner.nextLine();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  static void prb() {
    query(0, 5);
    query(B - 5, B);
    sz = 5;
    
    for(int i = 0; i != 10; i++) {
      System.out.print(line[i]);
    }
    System.out.println();
    System.out.flush();
    scanner.nextLine();
  }
  
  static void query(int min, int max) {
    for(int i = min; i != max; i++) {
      query(i);
      line[i] = scanner.nextInt();
      scanner.nextLine();
    }
  }
  
  static void query(int idx) {
    System.out.println(idx + 1);
    System.out.flush();
  }
  
  static int existSame() {
    boolean res = false;
    int i = 0;
    while(i != sz && !res) {
      int x = line[i];
      i++;
      int y = line[B - 1];
      res = x == y;
    }
    return i;
  }
  
  static int existDiff() {
    boolean res = false;
    int i = 0;
    while(i != sz && !res) {
      int x = line[i];
      i++;
      int y = line[B - 1];
      res = x != y;
    }
    return i;
  }
}